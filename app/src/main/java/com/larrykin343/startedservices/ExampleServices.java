package com.larrykin343.startedservices;

import android.app.IntentService;
import android.content.Intent;
import android.content.IntentSender;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;

public class ExampleServices extends IntentService {
    private static final String TAG = "ExampleServices";//logt
    public ExampleServices() {
        super("DownloadThread");
    }
    @Override
    protected void onHandleIntent (@Nullable Intent intent) {
        try {
            int number = intent.getIntExtra("number", -1);
            if (number != -1) {
                for (int i = 0; i < number; i++) {
                    Log.d(TAG, "onHandleIntent: number:  " + i);
                    SystemClock.sleep(1000);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
