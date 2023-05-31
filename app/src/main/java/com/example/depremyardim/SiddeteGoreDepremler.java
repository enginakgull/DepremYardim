package com.example.depremyardim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SiddeteGoreDepremler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siddete_gore_depremler);

        Button siddetButton = (Button) findViewById(R.id.siddetButton);

        siddetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText siddetEditText = (EditText) findViewById(R.id.siddetEditText);
                TextView depremler = (TextView) findViewById(R.id.siddetDepremTextViev);
                String URL = "https://api.hknsoft.com/earthquake/v1/last24hours?mag=" + siddetEditText.getText().toString();
                depremler.setText("");

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
                            if(jsonArray.length() <= 0) {
                                depremler.setText("Son 24 saat içerisinde bu değerden büyük deprem olmamıştır.");
                            }
                        } catch (JSONException e) {
                            depremler.setText("yok");
                            throw new RuntimeException(e);

                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                RequestQueue requestQueue = Volley.newRequestQueue(SiddeteGoreDepremler.this);
                requestQueue.add(jsonObjectRequest);
            }
        });
    }
}