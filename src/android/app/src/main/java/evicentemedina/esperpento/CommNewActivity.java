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

public class CommNewActivity extends AppCompatActivity implements View.OnClickListener {

    private String user, pass;
    private EditText etName, etDescrip;
    private Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comm_new);
        Toolbar toolbar = findViewById(R.id.toolbar_comm_new);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        etName = findViewById(R.id.comm_new_name);
        etDescrip = findViewById(R.id.comm_new_descrip);

        etName.setFilters(Constants.getInputFilters(etName.getFilters()));
        etDescrip.setFilters(Constants.getInputFilters(etDescrip.getFilters()));

        btnCreate = findViewById(R.id.comm_new_create);
        btnCreate.setOnClickListener(this);

        if (savedInstanceState == null) {
            SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
            user = sp.getString("user", "");
            pass = sp.getString("pass", "");
        }
    }

    @Override
    public void onClick(final View v) {
        if (v.getId() == R.id.comm_new_create) {
            String name = etName.getText().toString(),
                   descrip = etDescrip.getText().toString();
            if (!name.isEmpty()) {
                btnCreate.setEnabled(false);
                VolleySingleton.getInstance().addToRequestQueue(new JsonObjectRequest(
                    Request.Method.GET, Constants.getUrlInsComm(user, pass, name, descrip),
                    null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            String msg;
                            try {
                                if (response.getInt("s") == 1)
                                    msg = getString(R.string.community_created);
                                else {
                                    msg = getString(R.string.community_already_exists);
                                    btnCreate.setEnabled(true);
                                }
                            } catch(JSONException e) {
                                e.printStackTrace();
                                msg = getString(R.string.bad_response);
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
                                msg = getString(R.string.error) + " " + error.networkResponse.statusCode;
                            else
                                msg = getString(R.string.connection_error);
                            Snackbar.make(v, msg, Snackbar.LENGTH_LONG).show();
                            btnCreate.setEnabled(true);
                        }
                    }
                ));
            } else
                Snackbar.make(v, R.string.name_cant_be_empty, Snackbar.LENGTH_LONG).show();
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
