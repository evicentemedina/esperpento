package evicentemedina.esperpento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

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
        CheckBox cbShowPass = findViewById(R.id.signInCbShowPass);
        Button btnSignIn = findViewById(R.id.signInBtnSignIn);

        cbShowPass.setOnCheckedChangeListener(this);
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if(id == R.id.signInBtnSignIn) {
            String user = etUser.getText().toString(),
                    pass1 = etPass1.getText().toString(),
                    pass2 = etPass2.getText().toString();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked) {
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
