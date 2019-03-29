package com.example.iuniversity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import com.example.iuniversity.BDNotas.AdaptadorDB;

public class Agenda extends AppCompatActivity {

    ListView lista;
    Button bot1;
    AdaptadorDB DB;
    EditText edit1,edit2;
    String getTitle;
    List<String> item = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        lista = (ListView)findViewById(R.id.listica);
        bot1 = (Button)findViewById(R.id.botonadd);
        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);

        bot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUpdateNotes();
            }
        });

    }

    private void addUpdateNotes(){
        DB = new AdaptadorDB(this);
        String title, content,msj;
        title = edit1.getText().toString();
        content = edit2.getText().toString();
        if(title.equals("")){
            msj = "Ingrese un titulo";
            edit1.requestFocus();
            Mensaje(msj);
        }else{
            if(content.equals("")){
                msj = "Ingrese la nota";
                edit2.requestFocus();
                Mensaje(msj);
            }else{
                Cursor c = DB.getNote(title);
                getTitle = "";
                //Se asegura de que existe al menos una condición
                if(c.moveToFirst()){
                    //Se recorre el cursor hasta que no hayan registros
                    do{
                        getTitle = c.getString(1); //Las columnas cuentan desde 0
                    }while (c.moveToNext());
                }
                if(getTitle.equals(title)){
                    edit1.requestFocus();
                    msj = "El titulo de la nota ya existe";
                }else{
                    DB.addNotes(title,content);
                    actividad(title,content);
                }
            }
        }

    }

    public void Mensaje(String msj){
        Toast toast = Toast.makeText(this, msj,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.show();
    }


    public void actividad(String title,String content){
        Intent intent = new Intent(Agenda.this, VerNota.class);
        intent.putExtra("title",title);
        intent.putExtra("content",content);
        startActivity(intent);
    }





}
