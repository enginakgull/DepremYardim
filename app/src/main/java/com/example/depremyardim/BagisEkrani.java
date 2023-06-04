package com.example.depremyardim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BagisEkrani extends AppCompatActivity {
    SharedPreferences bagis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bagis_ekrani);

        Button cadir = (Button) findViewById(R.id.cadir);
        Button cocukKiyafet = (Button) findViewById(R.id.cocukKiyafet);
        Button yetiskinKiyafet = (Button) findViewById(R.id.yetiskinKiyafet);

        String cadirString = YardimEt.bagisYapilacakSehir + "cadir";
        String bebekKiyafetString = YardimEt.bagisYapilacakSehir + "bebek";
        String yetiskinKiyafetString = YardimEt.bagisYapilacakSehir + "yetiskin";

        bagis = getSharedPreferences("BagisBilgileri", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = bagis.edit();
        cadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cadirSayisi = bagis.getInt(cadirString, Context.MODE_PRIVATE);

                if(cadirSayisi > 0) {
                    cadirSayisi++;
                    editor.putInt(cadirString, cadirSayisi);
                    editor.commit();
                    Toast.makeText(BagisEkrani.this, "Çadır Bağışı Başarıyla Yapıldı", Toast.LENGTH_SHORT).show();
                    Log.d("Cadir", String.valueOf(bagis.getInt(cadirString, Context.MODE_PRIVATE)));
                } else {
                    cadirSayisi = 1;
                    editor.putInt(cadirString, cadirSayisi);
                    editor.commit();
                    Toast.makeText(BagisEkrani.this, "Çadır Bağışı Başarıyla Yapıldı", Toast.LENGTH_SHORT).show();
                    Log.d("Cadir", String.valueOf(bagis.getInt(cadirString, Context.MODE_PRIVATE)));
                }
            }
        });

        cocukKiyafet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int bebekKiyafetSayisi = bagis.getInt(bebekKiyafetString, Context.MODE_PRIVATE);

                if(bebekKiyafetSayisi > 0) {
                    bebekKiyafetSayisi++;
                    editor.putInt(bebekKiyafetString, bebekKiyafetSayisi);
                    editor.commit();
                    Toast.makeText(BagisEkrani.this, "Çocuk-Bebek Kıyafeti Bağışı Başarıyla Yapıldı", Toast.LENGTH_SHORT).show();
                    Log.d("Bebek", String.valueOf(bagis.getInt(bebekKiyafetString, Context.MODE_PRIVATE)));
                } else {
                    bebekKiyafetSayisi = 1;
                    editor.putInt(bebekKiyafetString, bebekKiyafetSayisi);
                    editor.commit();
                    Toast.makeText(BagisEkrani.this, "Çocuk-Bebek Kıyafeti Bağışı Başarıyla Yapıldı", Toast.LENGTH_SHORT).show();
                    Log.d("Bebek", String.valueOf(bagis.getInt(bebekKiyafetString, Context.MODE_PRIVATE)));
                }
            }
        });

        yetiskinKiyafet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int yetiskinKiyafetSayisi = bagis.getInt(yetiskinKiyafetString, Context.MODE_PRIVATE);

                if(yetiskinKiyafetSayisi > 0) {
                    yetiskinKiyafetSayisi++;
                    editor.putInt(yetiskinKiyafetString, yetiskinKiyafetSayisi);
                    editor.commit();
                    Toast.makeText(BagisEkrani.this, "Yetişkin Kıyafeti Bağışı Başarıyla Yapıldı", Toast.LENGTH_SHORT).show();
                    Log.d("Yetiskin", String.valueOf(bagis.getInt(yetiskinKiyafetString, Context.MODE_PRIVATE)));
                } else {
                    yetiskinKiyafetSayisi = 1;
                    editor.putInt(yetiskinKiyafetString, yetiskinKiyafetSayisi);
                    editor.commit();
                    Toast.makeText(BagisEkrani.this, "Yetişkin Kıyafeti Bağışı Başarıyla Yapıldı", Toast.LENGTH_SHORT).show();
                    Log.d("Yetiskin", String.valueOf(bagis.getInt(yetiskinKiyafetString, Context.MODE_PRIVATE)));
                }
            }
        });
    }
}