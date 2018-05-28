package evicentemedina.esperpento;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import evicentemedina.esperpento.fragments.ErrorFragment;
import evicentemedina.esperpento.fragments.LoadingFragment;
import evicentemedina.esperpento.fragments.ThreadsListFragment;
import evicentemedina.esperpento.objects.Constants;
import evicentemedina.esperpento.objects.VolleySingleton;

public class CommDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private String username, userpass, comm;

    private TextView tvName, tvAdmin, tvThreads, tvTime, tvDescrip, tvSubscriptors, tvSubscribe;
    private Switch swSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comm_detail);
        Toolbar toolbar = findViewById(R.id.toolbar_comm_detail);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        tvName = findViewById(R.id.comm_detail_name);
        tvAdmin = findViewById(R.id.comm_detail_admin);
        tvThreads = findViewById(R.id.comm_detail_threads);
        tvTime = findViewById(R.id.comm_detail_time);
        tvDescrip = findViewById(R.id.comm_detail_descrip);
        tvSubscriptors = findViewById(R.id.comm_detail_subscriptors);
        tvSubscribe = findViewById(R.id.comm_detail_sub_tv);
        swSub = findViewById(R.id.comm_detail_sub_sw);

        SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
        username = sp.getString("user", "");
        userpass = sp.getString("pass", "");

        loadContent();

        swSub.setOnClickListener(this);
    }

    private void loadContent() {
        Fragment fragment = new LoadingFragment();
        getFragmentManager().beginTransaction().replace(R.id.comm_detail_framelayout, fragment)
                .commit();

        try {
            JSONObject jsonObject = new JSONObject(getIntent().getStringExtra("json"));
            comm = jsonObject.getString("name");

            getSharedPreferences("comm", MODE_PRIVATE).edit().putString("comm", comm).apply();

            tvName.setText(comm);
            tvAdmin.setText(String.format("%s %s", getString(R.string.admin),
                    jsonObject.getString("admin")));
            tvThreads.setText(String.format("%s %s", jsonObject.getString("threads"),
                    getString(R.string.threads)));
            tvTime.setText(jsonObject.getString("time").split("[.]")[0]);
            tvSubscriptors.setText(String.format("%s %s", jsonObject.getString("subs"),
                    getString(R.string.subscriptors)));
            tvDescrip.setText(jsonObject.getString("descrip"));

            VolleySingleton.getInstance().addToRequestQueue(new JsonObjectRequest(
                Request.Method.GET, Constants.getUrlIsUsrSub(username, comm), null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.getInt("s") == 1) {
                                swSub.setChecked(true);
                                tvSubscribe.setText(R.string.subscribed);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
            ));

            VolleySingleton.getInstance().addToRequestQueue(new JsonObjectRequest(
                Request.Method.GET, Constants.getUrlGetThreadsComm(comm), null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Fragment frag;
                        try {
                            if (response.getInt("s") == 1) {
                                frag = new ThreadsListFragment();
                                Bundle args = new Bundle();
                                args.putString("args", response.getJSONArray("c").toString());
                                frag.setArguments(args);
                            } else {
                                frag = new ThreadsListFragment();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            frag = new ErrorFragment();
                        }
                        getFragmentManager().beginTransaction()
                                .replace(R.id.comm_detail_framelayout, frag).commit();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Fragment frag = new ErrorFragment();
                        getFragmentManager().beginTransaction()
                                .replace(R.id.comm_detail_framelayout, frag).commit();
                    }
                }
            ));
        } catch (JSONException e) {
            e.printStackTrace();
            fragment = new ErrorFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.comm_detail_framelayout, fragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_refresh:
                loadContent();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(final View v) {
        if (v.getId() == R.id.comm_detail_sub_sw) {
            VolleySingleton.getInstance().addToRequestQueue(new JsonObjectRequest(
                Request.Method.GET, Constants.getUrlSubComm(username, userpass, comm), null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String msg = "";
                        try {
                            if (response.getInt("s") == 1) {
                                if (response.getInt("c") == 1) {
                                    tvSubscribe.setText(R.string.subscribed);
                                    swSub.setChecked(true);
                                } else if (response.getInt("c") == 0) {
                                    tvSubscribe.setText(R.string.unsubscribed);
                                    swSub.setChecked(false);
                                }
                                VolleySingleton.getInstance().addToRequestQueue(new JsonObjectRequest(
                                    Request.Method.GET, Constants.getUrlGetSubsComm(comm), null,
                                    new Response.Listener<JSONObject>() {
                                        @Override
                                        public void onResponse(JSONObject response) {
                                            try {
                                                if (response.getInt("s") == 1) {
                                                    tvSubscriptors.setText(String.format(
                                                            "%s %s",
                                                            response.getString("c"),
                                                            getString(R.string.subscriptors)
                                                    ));
                                                }
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }, new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            error.printStackTrace();
                                        }
                                    }
                                ));
                            } else {
                                msg = getString(R.string.error);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            msg = getString(R.string.bad_response);
                        }
                        if (!msg.isEmpty()) {
                            swSub.setChecked(!swSub.isChecked());
                            Snackbar.make(v.getRootView(), msg, Snackbar.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        swSub.setChecked(!swSub.isChecked());
                        String msg;
                        if(error.networkResponse != null)
                            msg = getString(R.string.error) + " " + error.networkResponse.statusCode;
                        else
                            msg = getString(R.string.connection_error);
                        Snackbar.make(v.getRootView(), msg, Snackbar.LENGTH_LONG).show();
                    }
                }
            ));
        }
    }
}
