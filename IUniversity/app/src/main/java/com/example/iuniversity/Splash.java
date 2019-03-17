package com.example.iuniversity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {
    private final int DURACION = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               Intent pasar1 = new Intent(Splash.this, MainActivity.class);
                startActivity(pasar1);
                finish();

            }

            ;
        }, DURACION);
    }
}
