package com.deucecoded.schedulenotificationstoy;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

public class NotifyUserService extends IntentService {
    private static String TAG = NotifyUserService.class.getName();
    private static int NOTIFICATION_ID = 33823;

    public NotifyUserService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String message = intent.getStringExtra(ScheduleMessageActivity.TOAST_MESSAGE);
        notifyWithMessage(message);
    }

    private void notifyWithMessage(String message) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        builder.setContentTitle("You've been notified!")
                .setSmallIcon(R.drawable.ic_message_black_24dp)
                .setContentText(message);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}
