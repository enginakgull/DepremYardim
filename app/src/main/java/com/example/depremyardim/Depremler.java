package com.example.depremyardim;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        Button yeniDepremler = (Button) findViewById(R.id.en_yeni_depremler);

        yeniDepremler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enYeniDepremler();
            }
        });


    }

    public void enYeniDepremler() {
        Intent intent = new Intent(this, YeniDepremler.class);
        startActivity(intent);
    }
}