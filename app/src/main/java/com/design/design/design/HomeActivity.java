package com.design.design.design;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity  {
    String msg = "Ok you are nome page";
    boolean home;
    Button charge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        home = checkhome();
        if(home){
            checkhome();
        }
        charge =  (Button) findViewById(R.id.charge);
        charge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent logout = new Intent(getBaseContext(),MainActivity.class);
                startActivity(logout);
            }
        });



    }

    private boolean checkhome() {
          Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
          return true;
    }

    public void witStart(View view){

        String accessToken = "OUNXAEDF6TDQAGG7US5QF76SCCI3XW5L";
        String text = "What is weather in Paris?";

    }



}
