package evicentemedina.esperpento;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity
        implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private EditText etUser, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etUser = findViewById(R.id.loginEtUser);
        etPass = findViewById(R.id.loginEtPass);
        CheckBox cbShowPass = findViewById(R.id.loginCbShowPass);
        Button btnLogin = findViewById(R.id.loginBtnLogin),
               btnSignin = findViewById(R.id.loginBtnSignin);

        cbShowPass.setOnCheckedChangeListener(this);
        btnLogin.setOnClickListener(this);
        btnSignin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if(id == R.id.loginBtnLogin) {
            String user = etUser.getText().toString(),
                    pass = etPass.getText().toString();
            if(!user.isEmpty() && !pass.isEmpty()) {
                startActivity(new Intent(v.getContext(), MainActivity.class));
                finish();
            }
        }else if(id == R.id.loginBtnSignin) {
            startActivity(new Intent(v.getContext(), SignInActivity.class));
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            etPass.setInputType(
                    InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }else{
            etPass.setInputType(
                    InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }
}