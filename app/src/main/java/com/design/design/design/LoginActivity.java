package com.design.design.design;

import android.content.Intent;
import android.preference.EditTextPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void initLogin(View view){
        EditText email =(EditText) findViewById(R.id.ins_email);
        EditText password =(EditText) findViewById(R.id.ins_password);
        Log.d("Login email",email.getText().toString());
        Log.d("Login email",password.getText().toString());
        if(email.getText().toString().equals("admin") && password.getText().toString().equals("admin")){

            Intent gotohome = new Intent(this,HomeActivity.class);
            Log.d("LOgin","Suuccess");
            startActivity(gotohome);
        }else{
            Log.d("LOgin","Falied");
            Toast.makeText(this,"Password or email dont match",Toast.LENGTH_LONG).show();

        }

    }

    public void startRegister(View view){
        Intent thisregister = new Intent(this, RegisterActivity.class);
        startActivity(thisregister);
    }


}
