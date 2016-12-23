package com.design.design.design;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;



public class HomeActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String accessToken = "OUNXAEDF6TDQAGG7US5QF76SCCI3XW5L";
        String text = "What is weather in Paris?";

        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response
        String url = "https://api.wit.ai/message?q="+text+"&access_token="+accessToken;
        String jsonStr = sh.makeServiceCall(url);
        Log.e("WIT", "Response from url: " + jsonStr);
    }


}
