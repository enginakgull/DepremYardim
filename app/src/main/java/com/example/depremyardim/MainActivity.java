package com.example.depremyardim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button yardimEt;
    private Button yardimAl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yardimEt = (Button) findViewById(R.id.button_yardim_et);
        yardimAl = (Button) findViewById(R.id.button_yardim_al);

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
    }

    public void yardimAlMenu(){
        Intent intent = new Intent(this,yardimAl.class);
        startActivity(intent);
    }

    public void yardimEtMenu() {
        Intent intent = new Intent(this, YardimEt.class);
        startActivity(intent);
    }

}