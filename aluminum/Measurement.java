package com.example.aluminum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Measurement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement);
    }
    public void click5( View v){
        Intent i = new Intent(this, Height.class);
        startActivity(i);
    }
    public void click6( View v){
        Intent i = new Intent(this, Width.class);
        startActivity(i);
    }
    public void click7( View v){
        Intent i = new Intent(this, Heel.class);
        startActivity(i);
    }
    public void click8( View v){
        Intent i = new Intent(this, Side.class);
        startActivity(i);
    }
    Intent i = getIntent();
}