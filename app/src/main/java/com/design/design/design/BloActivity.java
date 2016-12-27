package com.design.design.design;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static android.R.id.list;

public class BloActivity extends AppCompatActivity {
    Button on,off,devices,visible;
    String turnedon = "Bluetooth is turned on,!";
    String showdevices = "Showing paired devices";
    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;

    ListView lv;

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
        lv = (ListView)findViewById(R.id.listView);
        off = (Button) findViewById(R.id.offblo);
        visible = (Button) findViewById(R.id.visible);
        devices = (Button) findViewById(R.id.devices);
        on();
        list();
        off();
        visible();
        list();
    }

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
    private void off(){
        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BA.disable();
                Toast.makeText(getApplicationContext(),"Bluetoof is turned off",Toast.LENGTH_LONG).show();
            }
        });

    }
    private void visible(){
        visible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                startActivityForResult(getVisible,0);
            }
        });

    }
    private void  list(){
        devices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pairedDevices = BA.getBondedDevices();

                ArrayList list = new ArrayList();

                for(BluetoothDevice bt : pairedDevices) list.add(bt.getName());
                Toast.makeText(getApplicationContext(), "Showing Paired Devices",Toast.LENGTH_SHORT).show();

                final ArrayAdapter adapter = new  ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1, list);

                lv.setAdapter(adapter);
            }
        });


    }

}
