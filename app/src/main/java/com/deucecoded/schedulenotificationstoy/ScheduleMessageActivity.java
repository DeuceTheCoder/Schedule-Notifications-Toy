package com.deucecoded.schedulenotificationstoy;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ScheduleMessageActivity extends AppCompatActivity {

    private static String TAG = ScheduleMessageActivity.class.getName();
    public static final String TOAST_MESSAGE = "MESSAGE_TO_DISPLAY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_toast);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button toastButton = (Button) findViewById(R.id.toast_button);
        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText toastMessage = (EditText) findViewById(R.id.message_edit_text);
                String message = toastMessage.getText().toString();
                scheduleToast(message);
            }
        });
    }

    protected void scheduleToast(String message) {
        // display the message as a toast
//        Intent displayIntent = new Intent(ScheduleMessageActivity.this, DisplayToast.class);
//        displayIntent.putExtra(DisplayToast.TOAST_MESSAGE, message);
//        PendingIntent pendingIntent = PendingIntent.getActivity(ScheduleMessageActivity.this, 0, displayIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        // display the message as a notification
        Intent serviceIntent = new Intent(ScheduleMessageActivity.this, NotifyUserService.class);
        serviceIntent.putExtra(TOAST_MESSAGE, message);
        PendingIntent pendingIntent = PendingIntent.getService(ScheduleMessageActivity.this, 0, serviceIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) this.getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + 5000L, pendingIntent);
    }
}
