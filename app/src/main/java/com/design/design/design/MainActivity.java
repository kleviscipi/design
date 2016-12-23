package com.design.design.design;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String msd = "Are you sure";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                    public void onClick(DialogInterface arg0, int arg1) {
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
}
