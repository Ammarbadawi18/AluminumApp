package com.example.aluminum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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

public class viewStock extends AppCompatActivity {
    EditText st ;
    ListView ls;
    Button view;
    String url= "https://aluminumapp.000webhostapp.com/mobile/viewStock.php";
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stock);

        st = findViewById(R.id.etStock);
        view = findViewById(R.id.enterst);
        ArrayList views = new ArrayList();
        ListView ls = findViewById(R.id.ls1);
        ArrayAdapter<Edit> adapter = new ArrayAdapter<Edit>(this, android.R.layout.simple_list_item_1, views);
        ls.setAdapter(adapter);

        requestQueue = Volley.newRequestQueue(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = viewurl.URL + "?Type=" + st.getText().toString();
                JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject row = response.getJSONObject(i);
                                String Name= row.getString("Name");
                                int Quantity = row.getInt("Quantity");
                                views.add(new Edit(Name,Quantity));
                            } catch (Exception ex) {
                                Toast.makeText(viewStock.this, "Error" + ex.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(viewStock.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                requestQueue.add(request);

            }
        });
    }
}
