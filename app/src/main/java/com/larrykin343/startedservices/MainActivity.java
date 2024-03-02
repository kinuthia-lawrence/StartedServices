package com.larrykin343.startedservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        services bound & unbound --they are used to handle task on background
        Intent intent = new Intent(this, ExampleServices.class);
        intent.putExtra("number", 5);
        startService(intent);
    }
}