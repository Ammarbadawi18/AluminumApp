package com.example.aluminum;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Order extends AppCompatActivity {
    EditText enterCID ;
    ListView ls;
    Button btenter;
    String url= "https://aluminumapp.000webhostapp.com/mobile/order.php";
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        enterCID = findViewById(R.id.enterid2);
        btenter = findViewById(R.id.enterbt2);
        ArrayList orders = new ArrayList();
        ListView ls = findViewById(R.id.ls2);
        ArrayAdapter<Orders> adapter = new ArrayAdapter<Orders>(this, android.R.layout.simple_list_item_1, orders);
        ls.setAdapter(adapter);

        requestQueue = Volley.newRequestQueue(this);

        btenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = orderurl.U + "?CID=" + enterCID.getText().toString();
                JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject row = response.getJSONObject(i);
                                int CID = row.getInt("CID");
                                int OID = row.getInt("OID");
                                String Date = row.getString("Date");
                                int Price = row.getInt("Price");
                                String Type = row.getString("Type");
                                String Design = row.getString("Design");
                                String Color = row.getString("Color");

                                orders.add(new Orders(CID, OID, Date, Price,Type,Design,Color));
                            } catch (Exception ex) {
                                Toast.makeText(Order.this, "Error" + ex.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Order.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                requestQueue.add(request);

            }
        });
    }
}
