package com.design.design.design;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ImageView slide = (ImageView) findViewById(R.id.headerimage2);
        android.view.animation.Animation slideanimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide);
        slide.startAnimation(slideanimation);
    }

    public void fade(View view) {
        ImageView image = (ImageView) findViewById(R.id.headerimage);
        android.view.animation.Animation fadeanimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        image.startAnimation(fadeanimation);
    }
    public void move(View view){
        ImageView image = (ImageView) findViewById(R.id.headerimage1);
        android.view.animation.Animation moveanimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        image.startAnimation(moveanimation);
    }
}
