package com.example.iuniversity.OpenHelperlLogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLite_OpenHelper extends SQLiteOpenHelper {

    public SQLite_OpenHelper(Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table  usuarios(_ID integer primary key autoincrement, "
                + "Nombre text, Correo text, Contrasena text, Usuario text);"; //Query para hacer invocaciones SQL
         db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Método para abrir base de datos
    public void abrir(){
        this.getWritableDatabase();
    }


    //Método para cerrar base de datos
    public void cerrar(){
        this.close();
    }

    //Metodo que permite insertar registros en la tabla
    public void insertarReg(String nom, String correo, String contrasena,String usuario){

        ContentValues valores = new ContentValues();
        valores.put("Nombre",nom);
        valores.put("Correo",correo);
        valores.put("Contrasena", contrasena);
        valores.put("Usuario",usuario);
        this.getWritableDatabase().insert("usuarios",null,valores);
    }

    public Cursor ConsultarUsuPas(String usu, String pass) throws SQLException {
        Cursor mcursor = null;
        mcursor = this.getReadableDatabase().query("usuarios",new String[]{"_ID",
                "Nombre","Correo","Contrasena","Usuario"},
                "Correo like '"+usu+"' " +
                        "and Contrasena like '"+pass+"'",null,null,null,null);
        Log.d("cursor",""+mcursor.getCount());
        return mcursor;

    }
}
