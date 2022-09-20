package com.example.aluminum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Side extends AppCompatActivity {
    EditText side;
    TextView result11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side);
    }

    public void click12(View v) {
        side = findViewById(R.id.enter4);
        double val = Double.parseDouble(side.getText().toString());
        double s = (val * 2) / 650;
        double sD = Math.round(s * 100.0) / 100.0;
        result11 = findViewById(R.id.san);
        result11.setText(Double.toString(sD));
    }
    Intent i = getIntent();
}