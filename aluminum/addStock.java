package com.example.aluminum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class addStock extends AppCompatActivity {
    EditText Name, Location, Type, Quantity;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stock);
        Name = findViewById(R.id.etName);
        Location = findViewById(R.id.etAddress);
        Type = findViewById(R.id.etType);
        Quantity = findViewById(R.id.etQuantity);
        btnAdd = findViewById(R.id.btnAdd);
        final RequestQueue queue = Volley.newRequestQueue(this);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://aluminumapp.000webhostapp.com/mobile/addStock.php";
                btnAdd.setEnabled(false);
                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(addStock.this, response, Toast.LENGTH_SHORT).show();
                        btnAdd.setEnabled(true);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(addStock.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
                        btnAdd.setEnabled(true);
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("Name", Name.getText().toString());
                        params.put("Location", Location.getText().toString());
                        params.put("Type", Type.getText().toString());
                        params.put("Quantity", Quantity.getText().toString());
                        return params;
                    }
                };

                queue.add(request);
            }


        });
    }
    }
