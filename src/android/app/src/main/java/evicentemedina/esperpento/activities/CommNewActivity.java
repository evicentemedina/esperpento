package evicentemedina.esperpento.activities;

import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import evicentemedina.esperpento.R;
import evicentemedina.esperpento.objects.Constants;
import evicentemedina.esperpento.objects.VolleySingleton;

public class CommNewActivity extends AppCompatActivity implements View.OnClickListener {
    // TODO: Activity acts weird, doesn't show Snackbars or back button & system bar is white
    private String user, pass;
    private EditText etName, etDescrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comm_new);
        Toolbar toolbar = findViewById(R.id.toolbar_comm_new);
        setSupportActionBar(toolbar);

        etName = findViewById(R.id.comm_new_name);
        etDescrip = findViewById(R.id.comm_new_descrip);

        etName.setFilters(Constants.INPUT_FILTER);
        etDescrip.setFilters(Constants.INPUT_FILTER);

        Button btnCreate = findViewById(R.id.comm_new_create);
        btnCreate.setOnClickListener(this);

        if(savedInstanceState == null){
            SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
            user = sp.getString("user", "");
            pass = sp.getString("pass", "");
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.comm_new_create){
            String name = etName.getText().toString(),
                   descrip = etDescrip.getText().toString();
            if(!name.isEmpty()){
                final View fv = v;
                VolleySingleton.getInstance().addToRequestQueue(new JsonObjectRequest(
                    Request.Method.GET, Constants.getUrlInsComm(user, pass, name, descrip),
                    null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            String msg;
                            try{
                                if(response.getInt("s") == 1)
                                    msg = "Community created";
                                else
                                    msg = "There is already a community with that name";
                            }catch(JSONException e){
                                e.printStackTrace();
                                msg = "Bad response";
                            }
                            Snackbar.make(fv, msg, Snackbar.LENGTH_LONG).show();
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            String msg;
                            if(error.networkResponse != null)
                                msg = "Error "+error.networkResponse.statusCode;
                            else
                                msg = "Connection error";
                            Snackbar.make(fv, msg, Snackbar.LENGTH_LONG).show();
                        }
                    }
                ));
            }else
                Snackbar.make(v, "Name can't be empty", Snackbar.LENGTH_LONG).show();
        }
    }
}
