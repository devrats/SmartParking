package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity8 extends AppCompatActivity {

    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        Intent intent = getIntent();
        textView = findViewById(R.id.textView25);
        textView2 = findViewById(R.id.textView28);
        textView3 = findViewById(R.id.textView30);
        textView.setText(intent.getStringExtra("name"));
        textView2.setText(String.valueOf( intent.getIntExtra("2Wheeler",0)));
        textView3.setText(String.valueOf( intent.getIntExtra("4Wheeler",0)));
    }
}