package com.example.hellosjtu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = findViewById(R.id.b1);
        final TextView tv1 = findViewById((R.id.tv1));

        b1.setOnClickListener(v -> {
            tv1.setText("SJTU is wonderful!");
            Log.d("MainActivity", "world");
        });

        Log.d("MainActivity", "hello");
    }
}