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

    private Button showBtn;
    private EditText city;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saglik_hizmeti);



        city = findViewById(R.id.sehirEditText);
        showBtn = findViewById(R.id.goruntule);
        result = findViewById(R.id.sehirler);

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String il = city.getText().toString();
                String snc = "En yakın hastane "+il + "'ın Erzin ilçesindedir.";
                result.setText(snc);
            }
        });
    }
}