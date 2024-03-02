package com.larrykin343.startedservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;

public class ExampleServices2 extends Service {
    private int serviceId = -1;
    private static final String TAG = "ExampleServices2";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        serviceId = startId;
        try{
            final int number = intent.getIntExtra("number", -1);
            if (number != -1){
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < number; i++){
                            Log.d(TAG, "onHandleIntent: number" + i);
                            SystemClock.sleep(1000);
                        }
                    }
                });
                thread.start();
            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopSelf(serviceId);
    }
}
