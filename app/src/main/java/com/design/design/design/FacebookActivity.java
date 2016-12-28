package com.design.design.design;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class FacebookActivity extends AppCompatActivity {
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
        img = (ImageView) findViewById(R.id.imageView);
        Button b1 = (Button) findViewById(R.id.buttonfb);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                Uri screenshotUri = Uri.parse("android.resource://com.design.design.design/*");
                try {
                    InputStream stream = getContentResolver().openInputStream(screenshotUri);

                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }
                sharingIntent.setType("image/jpeg");
                sharingIntent.putExtra(Intent.EXTRA_STREAM,screenshotUri);
                startActivity(Intent.createChooser(sharingIntent,"SHare image using"));
            }
        });

    }
}
