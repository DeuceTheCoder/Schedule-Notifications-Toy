package com.deucecoded.schedulenotificationstoy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class DisplayToast extends AppCompatActivity {

    String messageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        messageText = getIntent().getStringExtra(ScheduleMessageActivity.TOAST_MESSAGE);
        showMessage();
    }

    private void showMessage() {
        Toast.makeText(this, messageText, Toast.LENGTH_LONG).show();
        finish();
    }
}
