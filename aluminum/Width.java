package com.example.aluminum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Width extends AppCompatActivity {

    EditText length;
    TextView result5;
    TextView result6;
    TextView result7;
    TextView result8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_width);
    }
    public void click10(View v){

        length = findViewById(R.id.enter2);
        double value= Double.parseDouble(length.getText().toString());
        double rail = value-3;
        double railD= Math.round(rail*100.0)/100.0;
        result5 = findViewById(R.id.txt55);
        result5.setText(Double.toString(railD));
        double heel= (value-2.2)/2;
        double heelD= Math.round(heel*100.0)/100.0;
        result6=findViewById(R.id.txt66);
        result6.setText(Double.toString(heelD));
        double sieve= (value/2);
        double sieveD= Math.round(sieve*100.0)/100.0;
        result7=findViewById(R.id.txt77);
        result7.setText(Double.toString(sieveD));
        double glass= heel-7;
        double glassD= Math.round(glass*100.0)/100.0;
        result8=findViewById(R.id.txt88);
        result8.setText(Double.toString(glassD));
    }
    Intent i = getIntent();
}