package com.example.depremyardim;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpRequest;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.HttpClient;

import org.json.JSONObject;

import java.net.URI;

public class Depremler extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depremler);

        TextView depremler = (TextView) findViewById(R.id.depremler);

        String URL_24_HOURS = "https://api.hknsoft.com/earthquake/v1/last24hours";
        String URL_24_HOURS_LIMITED = "https://api.hknsoft.com/earthquake/v1/last24hours?limit=100";
        String URL_WITH_MAG = "https://api.hknsoft.com/earthquake/v1/last24hours?mag=3.7";
        String URL_WITH_CITY = "https://api.hknsoft.com/earthquake/v1/last24hours?city=izmir";

        JsonObjectRequest lastTwentyFourHours = new JsonObjectRequest(URL_24_HOURS, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                depremler.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                depremler.setText("Deprem verilerine erişim mümkün değil, lütfen internet bağlantınızı kontrol ediniz...");
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(lastTwentyFourHours);
    }
}