package com.design.design.design;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class NotificationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton info = (FloatingActionButton) findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNewnotice();
                Snackbar.make(view, "Ok you have started a new notification", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    protected void setNewnotice() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getBaseContext())
                .setSmallIcon(R.drawable.newsms)
                .setContentTitle("A new sms")
                .setContentText("This is a ne smsm for you by your baby");
        Intent notificationintent = new Intent(this, OpenNotificationActivity.class);

        PendingIntent contentIntent = PendingIntent.getActivity(this,0,notificationintent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0,builder.build());
    }
}
