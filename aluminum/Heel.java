package com.example.aluminum;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Heel extends AppCompatActivity {
    EditText heel;
    TextView result10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heel);
    }
    public void click11(View v){
        heel = findViewById(R.id.enter3);
        double val = Double.parseDouble(heel.getText().toString());
        double h = (val*2)/650;
        double hD= Math.round(h*100.0)/100.0;
        result10 = findViewById(R.id.han);
        result10.setText(Double.toString(hD));
    }
    Intent i = getIntent();
}