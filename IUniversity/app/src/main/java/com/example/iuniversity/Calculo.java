package com.example.iuniversity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iuniversity.R;

import org.w3c.dom.Text;

public class Calculo extends AppCompatActivity {

    EditText not1;
    EditText por1;
    EditText not2;
    EditText por2;
    EditText not3;
    EditText por3;
    EditText not4;
    EditText por4;
    EditText not5;
    EditText por5;
    EditText not6;
    EditText por6;
    Button calcu;
    TextView resp;

    double no1;
    double po1;
    double no2;
    double po2;
    double no3;
    double po3;
    double no4;
    double po4;
    double no5;
    double po5;
    double no6;
    double po6;

    String n1;
    String p1;
    String n2;
    String p2;
    String n3;
    String p3;
    String n4;
    String p4;
    String n5;
    String p5;
    String n6;
    String p6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        not1 = (EditText) findViewById(R.id.nota1);
        not2 = (EditText) findViewById(R.id.nota2);
        not3 = (EditText) findViewById(R.id.nota3);
        not4 = (EditText) findViewById(R.id.nota4);
        not5 = (EditText) findViewById(R.id.nota5);
        not6 = (EditText) findViewById(R.id.nota6);
        por1 = (EditText) findViewById(R.id.por1);
        por2 = (EditText) findViewById(R.id.por2);
        por3 = (EditText) findViewById(R.id.por3);
        por4 = (EditText) findViewById(R.id.por4);
        por5 = (EditText) findViewById(R.id.por5);
        por6 = (EditText) findViewById(R.id.por6);
        calcu = (Button) findViewById(R.id.calcular);
        resp = (TextView) findViewById(R.id.respuesta);

        calcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cadenas p1 = new Cadenas("");
            if(not1.getText().equals("") && not2.getText().equals("")&& not3.getText().equals("")
                    && not4.getText().equals("") && not5.getText().equals("") && not6.getText().equals("")
                    && por1.getText().equals("") && por2.getText().equals("")&& por3.getText().equals("")
                    && por4.getText().equals("")&& por5.getText().equals("")&& por6.getText().equals("")){
                Toast.makeText(getApplicationContext(),"Ingrese todos los valores requeridos por favor",Toast.LENGTH_LONG).show();


            }else{
                double retorno = Calcular();



                    if(retorno > 5.0){

                        resp.setText("nota:"+retorno);
                        resp.setText("Nooo mijo, ni pidiéndole a lord Uribe que le ayude con las esferas del dragon");
                    }else if(retorno == 5.0){
                        resp.setText("nota:"+retorno);
                        resp.setText(p1.getCadena1());

                    }else if((retorno < 5.0)&&(retorno <= 4.5)){
                        resp.setText("nota:"+retorno);
                        resp.setText("Jmm pana, la cosa está grave pero aún se puede");
                    }else if((retorno < 4.5)&&(retorno >= 4.0 )){
                        resp.setText("nota:"+retorno);
                        resp.setText("Está difícil, pero aún se puede");
                    }else if((retorno < 4.5)&&(retorno >= 4.0 )){
                        resp.setText("nota:"+retorno);
                        resp.setText("Está difícil, pero aún se puede");
                    }else if((retorno < 4.0)&&(retorno >= 3.0 )){
                        resp.setText("nota:"+retorno);
                        resp.setText("¡Lúchela, no cancele!");
                    }else if((retorno < 3.0)&&(retorno >= 2.0 )){
                        resp.setText("nota:"+retorno);
                        resp.setText("Uff no quiero decir que está fácil, pero tienes bastantes opciones de lograrlo");
                    }else if((retorno < 2.0)&&(retorno >= 1.0 )){
                        resp.setText("nota:"+retorno);
                        resp.setText("Vas muy bien, sigue así");
                    }else if((retorno < 1.0)&&(retorno > 0.0 )){
                        resp.setText("nota:"+retorno);
                        resp.setText("Ah eso está prácticamente hecho, pero no se confíe");
                    }else if(retorno <= 0.0){
                        if(retorno == 0.0){
                            resp.setText("nota:"+retorno);

                        }
                        resp.setText("¡Ya coronaste!");
                    }else{
                        resp.setText("nota:"+retorno);
                        resp.setText("NADITA");
                    }

                }


            }


        });





    }

    public double Calcular ()
    {


        try{


            n1 = not1.getText().toString();
            no1 = Double.parseDouble(n1);
            n2 = not2.getText().toString();
            no2 = Double.parseDouble(n2);
            n3 = not3.getText().toString();
            no3 = Double.parseDouble(n3);
            n4 = not4.getText().toString();
            no4 = Double.parseDouble(n4);
            n5 = not5.getText().toString();
            no5 = Double.parseDouble(n5);
            n6 = not6.getText().toString();
            no6 = Double.parseDouble(n6);
            p1 = por1.getText().toString();
            po1 = Double.parseDouble(p1);
            p2 = por2.getText().toString();
            po2 = Double.parseDouble(p2);
            p3 = por3.getText().toString();
            po3 = Double.parseDouble(p3);
            p4 = por4.getText().toString();
            po4 = Double.parseDouble(p4);
            p5 = por5.getText().toString();
            po5 = Double.parseDouble(p5);
            p6 = por6.getText().toString();
            po6 = Double.parseDouble(p6);



        }catch(NumberFormatException e){
            Toast.makeText(getApplicationContext(),"Error en el numero ingresado",Toast.LENGTH_SHORT).show();
        }


            double notanecesaria;
            double notamin = 3.0;
            notanecesaria = (notamin - no1*po1 - no2*po2 - no3*po3 - no4*po4 -no5*po5  )/(1-(po1 + po2 + po3 + po4 + po5));
            return  notanecesaria;



    }

}





