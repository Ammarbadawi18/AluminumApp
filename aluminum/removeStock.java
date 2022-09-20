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

public class removeStock extends AppCompatActivity {

    EditText  Type, Quantity;
    Button btnRemove;
    String url = "https://aluminumapp.000webhostapp.com/mobile/removeStock.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_stock);
        Type = findViewById(R.id.etName);
        Quantity = findViewById(R.id.etQuantity);
        btnRemove = findViewById(R.id.btnRemove);
        final RequestQueue queue = Volley.newRequestQueue(this);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = removeurl.U + "?Type=" + Type.getText().toString() +"?Quantity=" +Quantity.getText().toString();
                btnRemove.setEnabled(false);
                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(removeStock.this, response, Toast.LENGTH_SHORT).show();
                        btnRemove.setEnabled(true);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(removeStock.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
                    btnRemove.setEnabled(true);
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
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
