package com.example.iuniversity.BDNotas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.iuniversity.OpenHelperlLogin.SQLite_OpenHelper;

public class AdaptadorDB extends SQLite_OpenHelper {

    //Campos
    public static final String TABLE_ID = "idNote";
    public static final String TITLE = "title";
    private static final String CONTENT = "content";
    //Info DB
    private static final String DATABASE = "Notas";
    private static  final String TABLE = "notes";

    public AdaptadorDB(Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE +" (" +
                TABLE_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                TITLE +" TEXT,"+ CONTENT +" TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }

    public void addNotes(String title, String content){
        ContentValues valores = new ContentValues();
        valores.put(TITLE,title);
        valores.put(CONTENT,content);
        this.getWritableDatabase().insert(TABLE,null,valores);

    }

    public Cursor getNote(String condition){
        String[] columnas = {TABLE_ID,TITLE,CONTENT};
        String[] args = new String[] {condition};
        Cursor c = this.getReadableDatabase().query(TABLE, columnas,TITLE+"=?", args,null,null,null);
        return c;
    }

    public Cursor getNotes(){
        String columnas[]={TABLE_ID,TITLE,CONTENT};
        Cursor c = this.getReadableDatabase().query(TABLE, columnas,null,null,null,null,null);
        return c;
    }

}
