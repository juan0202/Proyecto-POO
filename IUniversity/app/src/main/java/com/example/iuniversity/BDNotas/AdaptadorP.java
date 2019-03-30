package com.example.iuniversity.BDNotas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.iuniversity.OpenHelperlLogin.SQLite_OpenHelper;

import javax.security.auth.Destroyable;

public class AdaptadorP extends SQLite_OpenHelper {

    public static final String NOMBRE = "nombre";
   public static final String TABLE_ID = "idProfe";
   public static final String TELEFONO = "telefono";
   public static final String MATERIA = "materia";

   private static final String DATABASE = "profesores";
    private static final String TABLE = "info";


    public AdaptadorP(Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE +" (" +
                TABLE_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                NOMBRE +" TEXT,"+ TELEFONO +" TEXT,"+MATERIA+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE);
        onCreate(db);

    }

    public void addProfe(String nombre, String materia, String telefono){
        ContentValues valores = new ContentValues();
        valores.put(NOMBRE,nombre);
        valores.put(MATERIA,materia);
        valores.put(TELEFONO,telefono);
        this.getWritableDatabase().insert(TABLE,null,valores);

    }

    public Cursor getProfe(String condition){
        String[] columnas = {TABLE_ID,NOMBRE,MATERIA,TELEFONO};
        String[] args = new String[] {condition};
        Cursor c = this.getReadableDatabase().query(TABLE, columnas,NOMBRE+"=?", args,null,null,null);
        return c;
    }

    public Cursor getProfes(){
        String columnas[]={TABLE_ID,NOMBRE,MATERIA,TELEFONO};
        Cursor c = this.getReadableDatabase().query(TABLE, columnas,null,null,null,null,null);
        return c;
    }


}
