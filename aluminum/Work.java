package com.example.aluminum;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Work extends AppCompatActivity {

    private MyImage myimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        Button open = findViewById(R.id.btcam);
        Button send = findViewById(R.id.btsend);
        ImageView iv = findViewById(R.id.im1);
        EditText etCID = findViewById(R.id.idcs);
        myimage = new MyImage(this, iv);

        RequestQueue queue = Volley.newRequestQueue(this);

        // get image from file system

        open.setOnClickListener(view -> {
            mGetContent.launch("image/*");
        });


        // upload image
        send.setOnClickListener(view -> {
            StringRequest request = myimage.uplaodImage(etCID.getText().toString());
            queue.add(request);
        });
    }

    // get selected image and update ImageView
    ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {
                    myimage.getIv().setImageURI(uri);
                }
            });
}