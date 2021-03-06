package evicentemedina.esperpento;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
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

public class LoginActivity extends AppCompatActivity
        implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private EditText etUser, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUser = findViewById(R.id.loginEtUser);
        etPass = findViewById(R.id.loginEtPass);

        etUser.setFilters(Constants.getInputFilters(etUser.getFilters()));
        etPass.setFilters(Constants.getInputFilters(etPass.getFilters()));

        CheckBox cbShowPass = findViewById(R.id.loginCbShowPass);
        Button btnLogin = findViewById(R.id.loginBtnLogin),
               btnSignin = findViewById(R.id.loginBtnSignin);

        cbShowPass.setOnCheckedChangeListener(this);
        btnLogin.setOnClickListener(this);
        btnSignin.setOnClickListener(this);

        if (savedInstanceState == null) {
            getSharedPreferences("user", MODE_PRIVATE).edit().clear().apply();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menuLogin_toggleUrl) {
            Constants.toggleUrl();
            item.setChecked(!item.isChecked());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.loginBtnLogin){
            final String user = etUser.getText().toString(),
                         pass = etPass.getText().toString();
            if(!user.isEmpty() && !pass.isEmpty()){
                VolleySingleton.getInstance().getRequestQueue().cancelAll("cancelable");
                final View fv = v;
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET, Constants.getUrlLogin(user, pass), null,
                    new Response.Listener<JSONObject>(){
                        @SuppressLint("ApplySharedPref")
                        @Override
                        public void onResponse(JSONObject response){
                            String msg = "";
                            try{
                                if(response.getInt("s") == 1){
                                    SharedPreferences.Editor editor =
                                            getSharedPreferences("user", MODE_PRIVATE).edit();
                                    editor.putString("user", user);
                                    editor.putString("pass", pass);
                                    editor.commit();

                                    startActivity(new Intent(fv.getContext(), MainActivity.class));
                                    finish();
                                }else
                                    msg = getString(R.string.user_or_pass_incorrect);
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
            }else
                Snackbar.make(v, R.string.user_or_password_empty, Snackbar.LENGTH_LONG).show();
        }else if(id == R.id.loginBtnSignin)
            startActivity(new Intent(v.getContext(), SignInActivity.class));
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked)
            etPass.setInputType(
                    InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        else
            etPass.setInputType(
                    InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }
}
