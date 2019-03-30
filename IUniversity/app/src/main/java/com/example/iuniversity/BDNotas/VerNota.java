package com.example.iuniversity.BDNotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.iuniversity.R;

import org.w3c.dom.Text;

public class VerNota extends AppCompatActivity {
    String title,content;
    TextView TITLE,CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vernota);

        Bundle bundle = this.getIntent().getExtras();

        title = bundle.getString("title");
        content = bundle.getString("content");

        TITLE = (TextView) findViewById(R.id.titulo);
        CONTENT = (TextView)findViewById(R.id.descripcion);
        TITLE.setText(title);
        CONTENT.setText(content);



    }
}
