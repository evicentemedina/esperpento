package evicentemedina.esperpento;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import evicentemedina.esperpento.objects.Constants;
import evicentemedina.esperpento.objects.VolleySingleton;

public class ThreadNewActivity extends AppCompatActivity implements View.OnClickListener {

    private String user, pass, comm;
    private EditText etTitle, etContent;
    private Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_new);
        Toolbar toolbar = findViewById(R.id.toolbar_thread_new);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        etTitle = findViewById(R.id.thread_new_title);
        etContent = findViewById(R.id.thread_new_content);

        etTitle.setFilters(Constants.getInputFilters(etTitle.getFilters()));
        etContent.setFilters(Constants.getInputFilters(etContent.getFilters()));

        btnCreate = findViewById(R.id.thread_new_create);
        btnCreate.setOnClickListener(this);

        if (savedInstanceState == null) {
            SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
            user = sp.getString("user", "");
            pass = sp.getString("pass", "");

            comm = getIntent().getStringExtra("comm");
        }
    }

    @Override
    public void onClick(final View v) {
        if (v.getId() == R.id.thread_new_create) {
            String title = etTitle.getText().toString(),
                   content = etContent.getText().toString();
            if (!title.isEmpty() && !content.isEmpty()) {
                btnCreate.setEnabled(false);
                VolleySingleton.getInstance().addToRequestQueue(new JsonObjectRequest(
                    Request.Method.GET, Constants.getUrlInsThread(user, pass, comm, title, content),
                    null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            String msg;
                            try {
                                if (response.getInt("s") == 1)
                                    msg = "Thread created";
                                else {
                                    msg = "Error creating thread";
                                    btnCreate.setEnabled(true);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                msg = "Bad response";
                                btnCreate.setEnabled(true);
                            }
                            Snackbar.make(v, msg, Snackbar.LENGTH_LONG).show();
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                            String msg;
                            if (error.networkResponse != null)
                                msg = "Error "+error.networkResponse.statusCode;
                            else
                                msg = "Connection error";
                            Snackbar.make(v, msg, Snackbar.LENGTH_LONG).show();
                            btnCreate.setEnabled(true);
                        }
                    }
                ));
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
