package com.example.aluminum;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private EditText etEmail, etPassword;
    Spinner spinner;
    private Button btnlogin,reg;

    private String Email, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = Password ="";

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        reg = (Button) findViewById(R.id.reg);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://192.148.150.112/php/login.php";
                Email= etEmail.getText().toString().trim();
                Password= etPassword.getText().toString().trim();
                if (!Email.equals("") && !Password.equals("")) {
                    StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("res", response);
                            if (response.equals("true")) {
                                Intent intent = new Intent(MainActivity.this, Home.class);
                                startActivity(intent);
                                finish();
                            } else if (response.equals("false")) {
                                Toast.makeText(MainActivity.this, "Invalid Login Email/Password", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                            btnlogin.setEnabled(true);
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            params.put("Email", Email);
                            params.put("Password", Password);
                            return params;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(request);
                }else{
                    Toast.makeText(MainActivity.this, "Fill the fields", Toast.LENGTH_SHORT).show();

                }
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Signup.class);
                startActivity(intent);
            }
        });
    }
}
