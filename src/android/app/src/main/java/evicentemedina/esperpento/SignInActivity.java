package evicentemedina.esperpento;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import evicentemedina.esperpento.objects.Constants;
import evicentemedina.esperpento.objects.VolleySingleton;

public class SignInActivity extends AppCompatActivity
        implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private EditText etUser, etPass1, etPass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        etUser = findViewById(R.id.signInEtUser);
        etPass1 = findViewById(R.id.signInEtPass1);
        etPass2 = findViewById(R.id.signInEtPass2);

        etUser.setFilters(Constants.getInputFilters(etUser.getFilters()));
        etPass1.setFilters(Constants.getInputFilters(etPass1.getFilters()));
        etPass2.setFilters(Constants.getInputFilters(etPass2.getFilters()));

        CheckBox cbShowPass = findViewById(R.id.signInCbShowPass);
        Button btnSignIn = findViewById(R.id.signInBtnSignIn);

        cbShowPass.setOnCheckedChangeListener(this);
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if(id == R.id.signInBtnSignIn){
            final String user = etUser.getText().toString(),
                         pass1 = etPass1.getText().toString(),
                         pass2 = etPass2.getText().toString();
            if(!user.isEmpty() && !pass1.isEmpty() && !pass2.isEmpty()){
                if(pass1.equals(pass2)){
                    VolleySingleton.getInstance().getRequestQueue().cancelAll("cancelable");
                    final View fv = v;
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.GET, Constants.getUrlSignIn(user, pass1), null,
                        new Response.Listener<JSONObject>(){
                            @Override
                            public void onResponse(JSONObject response) {
                                String msg = "";
                                try{
                                    if(response.getInt("s") == 1){
                                        msg = getString(R.string.user_created);
                                        etUser.setText("");
                                        etPass1.setText("");
                                        etPass2.setText("");
                                    }else if(response.getInt("s") == 0){
                                        msg = getString(R.string.user_already_exists);
                                    }else if(response.getInt("s") == -1){
                                        msg = getString(R.string.user_or_password_too_long);
                                    }
                                }catch(JSONException e){
                                    msg = response.toString();
                                }
                                Snackbar.make(fv, msg, Snackbar.LENGTH_LONG).show();
                            }
                        }, new Response.ErrorListener(){
                            @Override
                            public void onErrorResponse(VolleyError error){
                                String msg;
                                if(error.networkResponse != null)
                                    msg = getString(R.string.error) + " " + error.networkResponse.statusCode;
                                else
                                    msg = getString(R.string.connection_error);
                                Snackbar.make(fv, msg, Snackbar.LENGTH_LONG).show();
                            }
                        }
                    );
                    VolleySingleton.getInstance().addToRequestQueue(jsonObjectRequest);
                }else{
                    Snackbar.make(v, R.string.passwords_dont_match, Snackbar.LENGTH_LONG).show();
                }
            }else{
                Snackbar.make(v, R.string.fill_all_inputs, Snackbar.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            int inputType = InputType.TYPE_CLASS_TEXT |
                    InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD;
            etPass1.setInputType(inputType);
            etPass2.setInputType(inputType);
        }else{
            int inputType = InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD;
            etPass1.setInputType(inputType);
            etPass2.setInputType(inputType);
        }
    }
}
