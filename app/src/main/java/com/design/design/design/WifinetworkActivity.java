package com.design.design.design;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


/**
 * Created by klevis on 27.12.2016.
 */

public class WifinetworkActivity extends AppCompatActivity {

    Button panel,enable,disabe,check;

    String msgtrue = "Wifi is enable";
    String msgfalse = "Wifi is not enable!";
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifinetwork);
        goPanel();
        enableWifi();
        disableWifi();
        checkState();
    }
    protected void goPanel(){
        panel = (Button) findViewById(R.id.panel);
        panel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent panel = new Intent(getBaseContext(),PanelActivity.class);
                startActivity(panel);
            }
        });
    }
    protected void enableWifi(){
        enable = (Button) findViewById(R.id.enable);
        enable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(true);
            }
        });
    }
    protected void disableWifi(){
        disabe = (Button) findViewById(R.id.disable);
        disabe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(false);
            }
        });
    }
    private void checkState(){
        check = (Button) findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager ison = (WifiManager) getSystemService(Context.WIFI_SERVICE);

                if(ison.isWifiEnabled()){
                    Toast.makeText(getBaseContext(),msgtrue,Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getBaseContext(),msgfalse,Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
