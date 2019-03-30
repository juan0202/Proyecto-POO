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

import java.util.ArrayList;
import java.util.List;

import com.example.iuniversity.BDNotas.AdaptadorDB;
import com.example.iuniversity.BDNotas.VerNota;

public class Agenda extends AppCompatActivity {

    ListView lista;
    Button bot1;
    AdaptadorDB DB;
    EditText edit1,edit2;
    String getTitle;
    List<String> item = null;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);



        lista = (ListView)findViewById(R.id.listica);
        bot1 = (Button)findViewById(R.id.botonadd);
        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        texto = (TextView)findViewById(R.id.textolista);

        showNotes();


      lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              getTitle = (String) lista.getItemAtPosition(position);
              verNota();

          }
      });

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
                    msj = "Datos agregados";
                    Toast.makeText(this, msj , Toast.LENGTH_SHORT).show();
                    //actividad(title,content);
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
        DB = new AdaptadorDB(this);
        Cursor c = DB.getNotes();
        item = new ArrayList<String>();
        String title = "";
        //Nos aseguramos de que existe al menos un registro
        if(c.moveToFirst() == false){
            texto.setText("No hay notas");
        }else{
            do{
                title = c.getString(1);
                item.add(title);

            }while(c.moveToNext());
        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,item);
        lista.setAdapter(adaptador);

    }

    public String getNote(){
        String type = "";
        String content = "";

        DB = new AdaptadorDB(this);
        Cursor c = DB.getNote(getTitle);
        if(c.moveToFirst() == true){

            do{
                content = c.getString(2);
                item.add(content);

            }while(c.moveToNext());
        }
        return content;
    }


    public void actividad(String title,String content){
        Intent intent = new Intent(Agenda.this, VerNota.class);
        intent.putExtra("title",title);
        intent.putExtra("content",content);
        startActivity(intent);
    }


    public void verNota(){

      String content;
      String type;


      content = getNote();

      type = getTitle;
      //Toast.makeText(this ,content,Toast.LENGTH_LONG).show();
      actividad(type,content);





    }


}
