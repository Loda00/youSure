package com.example.yousure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAlert;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnAlert = (Button) findViewById(R.id.alert);
        this.result = (TextView) findViewById(R.id.result);
    }

    @Override
    public void onClick(View v) {
        if (v ==  this.btnAlert) {
            this.request();
        }
    }

    private void request (){
        RequestQueue queue = Volley.newRequestQueue(this);

        String api = "http://localhost:3001/api/help";
        StringRequest req = new StringRequest(Request.Method.GET, api, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                result.setText("Response " + response.substring(0, 500));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                result.setText("Response "+ error);
                System.out.println(error);
            }
        }
        );
        queue.add(req);
    }

}
