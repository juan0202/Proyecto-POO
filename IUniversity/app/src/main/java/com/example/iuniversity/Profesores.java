package com.example.iuniversity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iuniversity.BDNotas.AdaptadorDB;
import com.example.iuniversity.BDNotas.AdaptadorP;
import com.example.iuniversity.BDNotas.VerNota;

import java.util.ArrayList;
import java.util.List;

public class Profesores extends AppCompatActivity {

    ListView listap;
    EditText edit1,edit2,edit3;
    String getTitle;
    List<String> item = null;
    AdaptadorP DB2;
    Button bot2;
    TextView textico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesores);
        listap = (ListView)findViewById(R.id.listap);
        edit1 = (EditText)findViewById(R.id.campo1);
        edit2 = (EditText)findViewById(R.id.campo2);
        edit3 = (EditText)findViewById(R.id.campo3);
        bot2 =(Button)findViewById(R.id.agregar);
        textico =(TextView)findViewById(R.id.textico);

        showNotes();


        listap.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getTitle = (String) listap.getItemAtPosition(position);
                verNota();

            }
        });

        bot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addUpdateNotes();
                showNotes();
            }
        });

    }

    private void addUpdateNotes(){
        DB2 = new AdaptadorP(this);
        String nombre, telefono,materia,msj;
        nombre = edit1.getText().toString();
         materia= edit2.getText().toString();
        telefono= edit3.getText().toString();
        if(nombre.equals("")){
            msj = "Ingrese el nombre";
            edit1.requestFocus();
            Mensaje(msj);
        }else{
            if(materia.equals("")){
                msj = "Ingrese la materia";
                edit2.requestFocus();
                Mensaje(msj);

            }else{
                if(telefono.equals("")){
                    msj = "Ingrese el telefono";
                    edit2.requestFocus();
                    Mensaje(msj);

                }else{




                    Cursor c = DB2.getProfe(nombre);
                    getTitle = "";
                    //Se asegura de que existe al menos una condición
                    if(c.moveToFirst()){
                        //Se recorre el cursor hasta que no hayan registros
                        do{
                            getTitle = c.getString(1); //Las columnas cuentan desde 0
                        }while (c.moveToNext());
                    }
                    if(getTitle.equals(nombre)){
                        edit1.requestFocus();
                        msj = "El profesor ya existe";
                    }else{
                        DB2.addProfe(nombre,materia,telefono);
                        msj = "Datos agregados";
                        Toast.makeText(this, msj , Toast.LENGTH_SHORT).show();
                        //actividad(title,content);
                    }

                }

            }
        }

    }

    public void Mensaje(String msj){
        Toast toast = Toast.makeText(this, msj,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.show();
    }

    public void showNotes(){
        DB2 = new AdaptadorP(this);
        Cursor c = DB2.getProfes();
        item = new ArrayList<String>();
        String nombre = "";
        String tel = "";
        //Nos aseguramos de que existe al menos un registro
        if(c.moveToFirst() == false){
            textico.setText("No hay profes añadidos");
        }else{
            do{
                nombre = c.getString(1);
                item.add(nombre);


            }while(c.moveToNext());
        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,item);

        listap.setAdapter(adaptador);

    }

    public String getNote(){
        String type = "";
        String materia = "";

        DB2 = new AdaptadorP(this);
        Cursor c = DB2.getProfe(getTitle);
        if(c.moveToFirst() == true){

            do{
                materia = c.getString(2);
                item.add(materia);

            }while(c.moveToNext());
        }
        return materia;
    }


    public String getNote2(){
        String type = "";
        String telefono = "";

        DB2 = new AdaptadorP(this);
        Cursor c = DB2.getProfe(getTitle);
        if(c.moveToFirst() == true){

            do{
                telefono = c.getString(3);
                item.add(telefono);

            }while(c.moveToNext());
        }
        return telefono;
    }


    public void actividad(String nombre,String materia,String telefono){
        Intent intent = new Intent(Profesores.this, VerProfesores.class);
        intent.putExtra("nombre",nombre);
        intent.putExtra("materia",materia);
        intent.putExtra("telefono",telefono);
        startActivity(intent);
    }


    public void verNota(){

        String nombre,materia,telefono;



        materia = getNote();
        telefono = getNote2();
        nombre = getTitle;
        //Toast.makeText(this ,telefono,Toast.LENGTH_LONG).show();
        actividad(nombre,materia,telefono);





    }
}
