package com.example.iuniversity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.iuniversity.OpenHelperlLogin.SQLite_OpenHelper;

public class MainActivity extends AppCompatActivity {

   Button registro;
   Button inicio;
   EditText txtusu,txtpass;

   SQLite_OpenHelper helper = new SQLite_OpenHelper(this,"BD1", null, 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registro = (Button) findViewById(R.id.registro);
        inicio = (Button)findViewById(R.id.inicio);
        txtusu = (EditText)findViewById(R.id.usu);
        txtpass = (EditText)findViewById(R.id.pass);

        inicio.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{


                    Cursor cursor = helper.ConsultarUsuPas
                            (txtusu.getText().toString(),txtpass.getText().toString());


                    if(cursor.getCount() > 0){
                        PasarActivityPrin();


                    }else{
                        Toast.makeText(getApplicationContext(),"Usuario y/o pass incorrectos",Toast.LENGTH_LONG).show();
                    }
                    txtusu.setText("");
                    txtpass.setText("");
                    txtusu.findFocus();


                }catch (SQLException e){
                    e.printStackTrace();
                }




            }
        });



        registro.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PasarActivity();
            }
        });

    }

    public void PasarActivityPrin(){
        Intent intent = new Intent(this,Menu.class);
        startActivity(intent);
    }


    public void PasarActivity(){
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }
}

