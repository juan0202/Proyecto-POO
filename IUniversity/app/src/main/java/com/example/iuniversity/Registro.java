package com.example.iuniversity;

import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.iuniversity.OpenHelperlLogin.SQLite_OpenHelper;
import com.example.iuniversity.OpenHelperlLogin.SQliteConnectionHelper;
import com.example.iuniversity.utilidades.Utilidades;


public class Registro extends AppCompatActivity {

    Button registrate;
    EditText txtNom,txtCorreo,txtPass,txtUsu;

    SQLite_OpenHelper helper = new SQLite_OpenHelper(this, "BD1",null, 1);
    // conexion a la bd
    SQliteConnectionHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        registrate = findViewById(R.id.registrate);
        txtNom = findViewById(R.id.nombre);
        txtCorreo = findViewById(R.id.correo);
        txtPass = findViewById(R.id.contrasena);
        txtUsu = findViewById(R.id.usuario);


        registrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* helper.abrir();
                helper.insertarReg(String.valueOf(txtNom.getText()),
                        String.valueOf(txtCorreo.getText()),
                        String.valueOf(txtPass.getText()),
                        String.valueOf(txtUsu.getText()));
                helper.cerrar();*/
                //Toast.makeText(getApplicationContext(), "Registro almacenado con exito",Toast.LENGTH_LONG).show();
               // PasarMain();

                if(txtUsu.length()>0 && txtCorreo.length()>0 && txtPass.length()>0){

                    addDataToDataBase();
                } else {

                    Toast.makeText(getApplicationContext(), "Error, por favor llene todos los campos solicitados", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }

    public void PasarMain(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    // insert a la bd creada en el utilities
    private void addDataToDataBase (){
        // Guardamos la informacion ingresada por el usuario

            String ident = txtUsu.getText().toString();
            String nombre = txtPass.getText().toString();
            String apellido = txtCorreo.getText().toString();

            // Crea conexion con la base de datos
            conn=new SQliteConnectionHelper(getApplicationContext(),"DBClientes",null,1);
            SQLiteDatabase db=conn.getWritableDatabase();

            // Se agregan los datos a la base de datos local
            String insert = "INSERT INTO " + Utilidades.CLIENT_TABLE
                    + " ("
                    + Utilidades.ID_FIELD + "," + Utilidades.NAME_FIELD + "," + Utilidades.LASTNAME_FIELD + ")" +
                    " VALUES (" + ident + ",'" + nombre + "','" + apellido + "')";

            db.execSQL(insert);

            db.close();
            Toast.makeText(this, "Usuario añadido exitosamente a la bd local", Toast.LENGTH_SHORT).show();
            txtUsu.setText("");
            txtCorreo.setText("");
            txtPass.setText("");








    }


}
