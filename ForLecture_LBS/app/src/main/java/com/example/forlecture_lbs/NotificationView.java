package com.example.forlecture_lbs;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by KWAK on 2018-06-07.
 */

public class NotificationView extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(getIntent().getExtras().getInt("notificationID"));
    }
}
