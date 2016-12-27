package com.design.design.design;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Camera;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String msd = "Are you sure";
    Button bluetooth,gotoplanets,gotocamera,gotofacebook,fire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView slide = (ImageView) findViewById(R.id.headerimage2);
        Animation slideanimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide);
        slide.startAnimation(slideanimation);
        myfragment();
        startBluetooth();
        startCamera();
        startFacebook();
        startFirebase();
    }
    public void startLogin(View view){
        Intent thislogin = new Intent(this,LoginActivity.class);
        startActivity(thislogin);
    }

    public void openDialog(View view) {
        AlertDialog.Builder sure = new AlertDialog.Builder(this);
        sure.setMessage(this.msd);
        sure.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whith) {
                        Toast.makeText(MainActivity.this, "You clicked yes button", Toast.LENGTH_LONG).show();
                    }
                });

        sure.setPositiveButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "You clicke no", Toast.LENGTH_LONG).show();
                    }
                });
        AlertDialog startSure = sure.create();
        startSure.show();
    }

    public void fade(View view) {
        ImageView image = (ImageView) findViewById(R.id.headerimage);
        Animation fadeanimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        image.startAnimation(fadeanimation);
    }
    public void move(View view){
        ImageView image = (ImageView) findViewById(R.id.headerimage1);
        Animation moveanimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        image.startAnimation(moveanimation);
    }
    private void startBluetooth(){
        bluetooth = (Button) findViewById(R.id.bluetooth);
        bluetooth.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent blo = new Intent(getBaseContext(),BloActivity.class);
                startActivity(blo);
            }
        });
    }
    public void myfragment(){
        gotoplanets = (Button) findViewById(R.id.gotoplanets);
        gotoplanets.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent frag = new Intent(getBaseContext(),Myfragment.class);
                startActivity(frag);
            }
        });
    }
    protected void startCamera(){
        gotocamera = (Button) findViewById(R.id.gotocamera);
        gotocamera.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera  = new Intent(getBaseContext(), CameraActivity.class);
                startActivity(camera);
            }
        });
    }
    protected void startFacebook(){
        gotofacebook = (Button) findViewById(R.id.gotofacebook);
        gotofacebook.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent facebook = new Intent(getBaseContext(),FacebookActivity.class);
                startActivity(facebook);
            }
        });
    }
    protected void startFirebase(){
        fire = (Button) findViewById(R.id.gotofirebase);
        fire.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent firebase = new Intent(getBaseContext(),FirebaseActivity.class);
                startActivity(firebase);
            }
        });
    }
}
