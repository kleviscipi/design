package com.design.design.design;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BloActivity extends AppCompatActivity {
    Button on,off,devices,visible;
    String turnedon = "Bluetooth is turned on,!";
    private BluetoothAdapter BA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        BA = BluetoothAdapter.getDefaultAdapter();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        on();
    }
//    protected void onStart(){
//        super.onStart(onSaveInstanceState   (););
//    }
    private void on(){

        on = (Button) findViewById(R.id.onblo);
        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!BA.isEnabled()){
                    Intent turnon = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(turnon,0);
                    Toast.makeText(getApplicationContext(),turnedon,Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Alredy Is ON!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
