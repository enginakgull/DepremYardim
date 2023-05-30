package com.example.depremyardim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

public class YeniDepremler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeni_depremler);

        TextView depremler = (TextView) findViewById(R.id.depremler);

        /*String URL = "https://api.hknsoft.com/earthquake/v1/last24hours";

        JsonObjectRequest lastTwentyFourHours = new JsonObjectRequest(URL, null, new Response.Listener<JSONObject>() {
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
        requestQueue.add(lastTwentyFourHours);*/

        String URL = "https://api.hknsoft.com/earthquake/v1/last24hours?limit=10";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("earthquakes");
                    for(int i = 0; i < jsonArray.length(); i++) {
                        JSONObject earthquake = jsonArray.getJSONObject(i);
                        String tarih = earthquake.getString("date");
                        String saat = earthquake.getString("time");
                        String sehir = earthquake.getString("city");
                        String siddet = earthquake.getString("mag");
                        depremler.append("Şehir: " + sehir + " Tarih: " + tarih + " Saat: " + saat + " Şiddet: " + siddet + "\n\n");
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);

    }


}