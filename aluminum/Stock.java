package com.example.aluminum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Stock extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
    }
    public void a(View v) {
        Intent intent = new Intent(Stock.this, addStock.class);
        startActivity(intent);
    }
    public void b(View v) {
        Intent intent = new Intent(Stock.this, removeStock.class);
        startActivity(intent);
    }
    public void c(View v) {
        Intent intent = new Intent(Stock.this, viewStock.class);
        startActivity(intent);
    }
    public void d(View v) {
        Intent intent = new Intent(Stock.this, updateStock.class);
        startActivity(intent);
    }
}