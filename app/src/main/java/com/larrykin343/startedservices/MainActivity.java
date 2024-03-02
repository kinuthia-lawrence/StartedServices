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
        Intent intent = new Intent(this, ExampleServices2.class);// this issue below is solved by exampleServices2.java
        intent.putExtra("number", 5);
        startService(intent);
        startService(intent);// this does not create simulteonusly two instances of the service,but  it waits for  the others to
        // complete because ot uses the intent.
     
        stopService(intent);
        // STOPSHIP: 03/02/2024  
    }
}