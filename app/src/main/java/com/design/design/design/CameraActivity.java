package com.design.design.design;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class CameraActivity extends AppCompatActivity {
    FloatingActionButton oncamera,ongallery;
    ImageButton onvideo;
    private static int IMG_RESULT = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        on();
        ongallery();
        onvideo();
    }
    protected void on(){
        oncamera = (FloatingActionButton) findViewById(R.id.camerastart);
        oncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent on = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(on,0);

            }
        });
    }
    protected void ongallery(){
        ongallery = (FloatingActionButton) findViewById(R.id.gotogallery);
        ongallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gallery,IMG_RESULT);
            }
        });
    }
    protected void onvideo(){
        onvideo = (ImageButton) findViewById(R.id.gotovideo);
        onvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent video = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(video,0);
            }
        });
    }

}
