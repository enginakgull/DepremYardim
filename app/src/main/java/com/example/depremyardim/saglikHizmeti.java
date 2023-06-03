package com.example.depremyardim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
                String snc = il + " Şehir Hastanesi ";
                sonuc.setText(snc);
            }
        });

    }
}