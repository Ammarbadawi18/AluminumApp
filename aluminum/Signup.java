package com.example.aluminum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class Signup extends AppCompatActivity {
    EditText Name, Address, Email, Password, Gender, Dateofbirth, Phonenumber;
    Spinner spinner ;
    Spinner sp;
    Button btregister, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Name = findViewById(R.id.etName);
        Address = findViewById(R.id.etAddress);
        Email = findViewById(R.id.etEmail);
        Password = findViewById(R.id.etPassword);
        sp = findViewById(R.id.sp);
        ArrayAdapter<CharSequence> ad = ArrayAdapter.createFromResource(this,
                R.array.gender, android.R.layout.simple_spinner_item);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(ad);
        Dateofbirth = findViewById(R.id.etDate);
        Phonenumber = findViewById(R.id.etPhonenumber);
        spinner=findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        btregister = findViewById(R.id.btnRegister);
        login = findViewById(R.id.login);
        final RequestQueue queue = Volley.newRequestQueue(this);
        btregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Spin = spinner.getSelectedItem().toString();
                final String gender = sp.getSelectedItem().toString();
                String url = "https://aluminumapp.000webhostapp.com/mobile/signup.php";
                btregister.setEnabled(false);
                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Signup.this, response, Toast.LENGTH_SHORT).show();
                        btregister.setEnabled(true);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Signup.this, "", Toast.LENGTH_SHORT).show();
                        btregister.setEnabled(true);
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("Name", Name.getText().toString());
                        params.put("Address", Address.getText().toString());
                        params.put("Email", Email.getText().toString());
                        params.put("Password", Password.getText().toString());
                        params.put("Gender", gender);
                        params.put("Dateofbirth", Dateofbirth.getText().toString());
                        params.put("Phonenumber", Phonenumber.getText().toString());
                        params.put("Spin",Spin);
                        return params;
                    }
                };

                queue.add(request);
            }


        });
    }
    public void click2(View v){
        Intent i = new Intent(Signup.this, MainActivity.class);
        startActivity(i);
    }
}
