package com.example.depremyardim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button yardimEt;
    private Button yardimAl;

    private Button depremler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yardimEt = (Button) findViewById(R.id.button_yardim_et);
        yardimAl = (Button) findViewById(R.id.button_yardim_al);
        depremler = (Button) findViewById(R.id.button_yeni_depremler);

        yardimAl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yardimAlMenu();
            }
        });


        yardimEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yardimEtMenu();
            }

        });

        depremler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                depremlerMenu();
            }
        });
    }

    public void yardimAlMenu(){
        Intent intent = new Intent(this,yardimAl.class);
        startActivity(intent);
    }

    public void yardimEtMenu() {
        Intent intent = new Intent(this, YardimEt.class);
        startActivity(intent);
    }

    public void depremlerMenu() {
        Intent intent = new Intent(this, Depremler.class);
        startActivity(intent);
    }

}