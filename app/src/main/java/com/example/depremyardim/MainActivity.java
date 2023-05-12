package com.example.depremyardim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button yardimEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yardimEt = (Button) findViewById(R.id.YardimEt);
        yardimEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yardimEtMenu();
            }
        });
    }

    public void yardimEtMenu() {
        Intent intent = new Intent(this, YardimEt.class);
        startActivity(intent);
    }
}