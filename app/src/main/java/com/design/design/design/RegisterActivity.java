package com.design.design.design;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void  initRegister(View view){
        EditText name       = (EditText) findViewById(R.id.reg_name);
        EditText subname    = (EditText) findViewById(R.id.reg_subname);
        EditText email      = (EditText) findViewById(R.id.reg_email);
        EditText password   = (EditText) findViewById(R.id.reg_password);
        boolean valname;
        boolean valsubnane;
        boolean valemail;
        if( name.getText().toString().length()  > 3) {
            valname = true;
        }else{
            Toast.makeText(this,"Name is to smalll",Toast.LENGTH_LONG).show();
            valname = false;
        }
        if( subname.getText().toString().length()  > 3) {
            valsubnane = true;
        }else{
            Toast.makeText(this,"subname is to smalll",Toast.LENGTH_LONG).show();
            valsubnane = false;
        }
        if( email.getText().toString().length()  > 3) {
            if(isValidEmaillId(email.getText().toString())){
                valemail = true;
            }else{
                valemail = false;
                Toast.makeText(this,"NOt a valid email ",Toast.LENGTH_LONG).show();
            }

        }else{
            Toast.makeText(this,"Email is to smalll",Toast.LENGTH_LONG).show();
            valemail = false;
        }
        if(valname &&  valsubnane && valemail){
            if( password.getText().toString().length()  > 3){

                Toast.makeText(this,"OK have register your self successfully",Toast.LENGTH_LONG).show();
                Intent gotohome = new Intent(getBaseContext(),HomeActivity.class);
                startActivity(gotohome);


            }else{
                Toast.makeText(this,"Your password isto small ", Toast.LENGTH_LONG).show();
            }
        }



    }

    private boolean isValidEmaillId(String email){

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();

    }


}
