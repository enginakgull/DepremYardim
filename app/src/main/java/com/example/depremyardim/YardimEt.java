package com.example.depremyardim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class YardimEt extends AppCompatActivity {
    private Button ilerle;

    public static String bagisYapilacakSehir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yardim_et);

        ilerle = (Button) findViewById(R.id.bagisButton);
        EditText ilEditText = (EditText) findViewById(R.id.ilEditText);


        ilerle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bagisYapilacakSehir = ilEditText.getText().toString();
                bagisEkrani();
            }
        });
    }

    private void bagisEkrani() {
        Intent intent = new Intent(this, BagisEkrani.class);
        startActivity(intent);
    }
}