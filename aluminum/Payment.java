package com.example.aluminum;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Payment extends AppCompatActivity {
    Spinner spname;
    ListView ls;
    Button btenter;
    String url= "http://192.148.150.112/php/payment.php";
    String cname= "http://192.148.150.112/php/getName.php";
    private int index;
    RequestQueue requestQueue;
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        btenter = findViewById(R.id.enterbt1);

        ArrayList pays = new ArrayList();
        ListView ls = findViewById(R.id.ls1);
        ArrayAdapter<Pay> adapter = new ArrayAdapter<Pay>(this, android.R.layout.simple_list_item_1, pays);
        ls.setAdapter(adapter);

        spname = findViewById(R.id.spname);
        ArrayList names = new ArrayList<>();
        ArrayAdapter<Customer> adapter1 = new ArrayAdapter<Customer>(Payment.this, R.layout.support_simple_spinner_dropdown_item, names);
        spname.setAdapter(adapter1);
        spname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                index = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Payment.this, "Please select a name ", Toast.LENGTH_SHORT).show();
            }
        });


        btenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = paymenturl.URL + "?spname=" + spname.toString();
                JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject row = response.getJSONObject(i);
                                String spname = row.getString("Name");
                                int TID = row.getInt("TID");
                                String Paymentmethod = row.getString("Paymentmethod");
                                String Date = row.getString("Date");
                                pays.add(new Pay(spname, TID, Paymentmethod, Date));
                            } catch (Exception ex) {
                                Toast.makeText(Payment.this, "Error" + ex.toString(), Toast.LENGTH_SHORT).show();
                            }

                        }
                        if (pays.size() == 0) {
                            Toast.makeText(Payment.this, "No value in db", Toast.LENGTH_SHORT).show();

                        }


                        adapter.notifyDataSetChanged();
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Payment.this, "Not found", Toast.LENGTH_SHORT).show();
                    }
                });
                requestQueue.add(request);

            }
        });
     spname.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             JsonArrayRequest request = new JsonArrayRequest(cname, new Response.Listener<JSONArray>() {
                 @Override
                 public void onResponse(JSONArray response)
                 {
                     try {
                         for (int i = 0;i < response.length();i++)
                         {
                             JSONObject row = response.getJSONObject(i);
                             String Name = row.getString("Name");
                             names.add(new Customer(Name));
                         }
                         adapter1.notifyDataSetChanged();

                     } catch (Exception ex)
                     {

                         Toast.makeText(Payment.this, "No records found", Toast.LENGTH_SHORT).show();
                     }
                 }
             }, new Response.ErrorListener()
             {
                 @Override
                 public void onErrorResponse(VolleyError error)
                 {
                     Toast.makeText(Payment.this, error.toString(), Toast.LENGTH_SHORT).show();
                 }
             });

             queue.add(request);
         }
     });

        }
    }


