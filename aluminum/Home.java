package com.example.aluminum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void click1( View v){
        Intent i = new Intent(this, Payment.class);
        startActivity(i);
    }
    public void click2( View v){
        Intent i = new Intent(this, Order.class);
        startActivity(i);
    }
    public void click3( View v){
        Intent i = new Intent(this, Stock.class);
        startActivity(i);
    }
    public void click4( View v){
        Intent i = new Intent(this, Measurement.class);
        startActivity(i);
    }
    public void click5( View v){
        Intent i = new Intent(this, Work.class);
        startActivity(i);
    }
}