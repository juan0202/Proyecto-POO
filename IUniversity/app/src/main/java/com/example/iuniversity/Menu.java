package com.example.iuniversity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    Button b1;
    Button b2;
    Button b3;
    Button b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        b1 = (Button) findViewById(R.id.profesores);
        b2 = (Button) findViewById(R.id.asignaturas);
        b3 = (Button) findViewById(R.id.calculo);
        b4 = (Button) findViewById(R.id.agenda);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarProfesores();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarCalculo();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarAgenda();
            }
        });

    }

    public  void pasarProfesores(){

        Intent intent = new Intent(this,Profesores.class);
        startActivity(intent);

    }

    public  void pasarCalculo(){

        Intent intent = new Intent(this,Calculo.class);
        startActivity(intent);

    }

    public void pasarAgenda(){
         Intent intent = new Intent(this,Agenda.class);
        startActivity(intent);

    }




}