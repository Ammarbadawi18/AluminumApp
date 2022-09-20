package com.example.aluminum;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class MyImage {
    private Context context;
    private ImageView iv;
    private final static String UPLAODURL = "https://aluminumapp.000webhostapp.com/PHP/upload.php";

    public MyImage(Context context, ImageView iv) {
        this.context = context;
        this.iv = iv;

    }

    public ImageView getIv() {
        return iv;
    }


    public StringRequest uplaodImage(String id) {

        StringRequest request = new StringRequest(1, UPLAODURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                BitmapDrawable drawable = (BitmapDrawable) iv.getDrawable();
                Bitmap bmap = drawable.getBitmap();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                bmap.compress(Bitmap.CompressFormat.JPEG,50,bos);
                byte[] bb = bos.toByteArray();
                String images = Base64.encodeToString(bb, Base64.DEFAULT);

                Map<String, String> params = new HashMap<>();
                params.put("name", id);
                params.put("file", images);
                return params;
            }
        };

        return request;
    }
}