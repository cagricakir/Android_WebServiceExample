package com.example.cagric.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
String responseText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button getInfo = (Button)findViewById(R.id.button);
        final TextView _response = (TextView)findViewById(R.id.textView);
        _response.setMovementMethod(new ScrollingMovementMethod());
        String url = "http://httpbin.org/html";

// Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        responseText=response;
                        //_response.setText(response.substring(0,100));
                        //System.out.println(response.substring(0,100));

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // Error handling
                System.out.println("Something went wrong!");
                error.printStackTrace();

            }
        });


        Volley.newRequestQueue(this).add(stringRequest);
        getInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               _response.setText(responseText.toString());
            }
        });
    }


}
