package com.example.depremyardim;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CadirVeKonteynirActivity extends AppCompatActivity {

    private Button goster;
    private EditText sehir;
    private TextView sonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadir_ve_konteynir);


        sehir = findViewById(R.id.sehirEditText);
        goster = findViewById(R.id.goruntule);
        sonuc = findViewById(R.id.sehirler);

        goster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String il = sehir.getText().toString();
                String snc = il + "'ın Çankaya ilçesinde çadır dağıtılmaktadır.";
                sonuc.setText(snc);
            }
        });

    }

}