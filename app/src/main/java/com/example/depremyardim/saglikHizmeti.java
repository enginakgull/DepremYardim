package com.example.depremyardim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class saglikHizmeti extends AppCompatActivity {

    private Button goster;
    private EditText sehir;
    private TextView sonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saglik_hizmeti);



        sehir = findViewById(R.id.sehirEditText);
        goster = findViewById(R.id.goruntule);
        sonuc = findViewById(R.id.sehirler);

        goster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String il = sehir.getText().toString();
                String location = "https://www.google.com/maps/search/?api=1&query="+ il;
                Uri gmmIntentUri = Uri.parse(location);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);

                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    // Harita uygulaması bulunamadığı için bir hata mesajı gösterebilirsiniz
                    Toast.makeText(saglikHizmeti.this, "Harita uygulaması bulunamadı. Tarayıcıda açılıyor...", Toast.LENGTH_SHORT).show();
                    Intent webIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    startActivity(webIntent);
                }
            }
        });

    }
}