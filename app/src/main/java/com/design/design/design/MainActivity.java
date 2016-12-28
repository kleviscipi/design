package com.design.design.design;

import android.app.AlertDialog;
import android.app.Notification;
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

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;


public class MainActivity extends AppCompatActivity {
    String msd = "Are you sure";
    Button bluetooth,
            gotoplanets,
            gotocamera,
            gotofacebook,
            fire,
            anime,
            notice,
    google,
    panel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myfragment();
        startBluetooth();
        startCamera();
        startFacebook();
        startFirebase();
        startAnimations();
        startNotifications();
        startPanel();
        googlestart();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
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
    protected void startAnimations(){
        anime = (Button) findViewById(R.id.gotoanimations);
        anime.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anime = new Intent(getApplicationContext(),AnimationActivity.class);
                startActivity(anime);
            }
        });
    }
    protected void startNotifications(){
        notice = (Button) findViewById(R.id.gotonotifications);
        notice.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent notices = new Intent(getBaseContext(), NotificationsActivity.class);
                startActivity(notices);
            }
        });
    }
    protected void startPanel(){
        panel = (Button) findViewById(R.id.gotopanel);
        panel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent notices = new Intent(getBaseContext(), PanelActivity.class);
                startActivity(notices);
            }
        });
    }
    protected void googlestart(){
        google = (Button) findViewById(R.id.gotogoogle);
        google.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(getBaseContext(),WebActivity.class);
                startActivity(go);
            }
        });
    }
}
