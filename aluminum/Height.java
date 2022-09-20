package com.example.aluminum;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Height extends AppCompatActivity {

    EditText height;
    TextView result1;
    TextView result2;
    TextView result3;
    TextView result4;
    TextView result5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height);
    }
    public void click9 (View v){
        height = findViewById(R.id.enter1);
        double value = Double.parseDouble(height.getText().toString());
        double side = value+5;
        double sideD= Math.round(side*100.0)/100.0;
        result1 = findViewById(R.id.text1);
        result1.setText(Double.toString(sideD));
        double grip= value-5.8;
        double gripD= Math.round(grip*100.0)/100.0;
        result2=findViewById(R.id.text22);
        result2.setText(Double.toString(gripD));
        double sieve= value-4;
        double sieveD= Math.round(sieve*100.0)/100.0;
        result3=findViewById(R.id.text33);
        result3.setText(Double.toString(sieveD));
        double glass= grip-8.3;
        double glassD= Math.round(glass*100.0)/100.0;
        result4=findViewById(R.id.text44);
        result4.setText(Double.toString(glassD));
        double u = value-3.1;
        double uD= Math.round(u*100.0)/100.0;
        result5=findViewById(R.id.text99);
        result5.setText(Double.toString(uD));
    }
    Intent i = getIntent();
}