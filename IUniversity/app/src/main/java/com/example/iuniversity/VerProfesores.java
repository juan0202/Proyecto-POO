package com.example.iuniversity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class VerProfesores extends AppCompatActivity {
    String nom,mat,tel;
    TextView nombre,materia,telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_profesores);

        nombre = (TextView)findViewById(R.id.nom);
        materia = (TextView)findViewById(R.id.mat);
        telefono = (TextView)findViewById(R.id.tel);

        Bundle bundle = this.getIntent().getExtras();

        nom = bundle.getString("nombre");
        mat = bundle.getString("materia");
        tel = bundle.getString("telefono");

        nombre.setText("Nombre: "+nom);
        materia.setText("Materia: "+mat);
        telefono.setText("Telefono: " +tel);



    }
}
