package com.example.pc05.AplikasiPermarkahanPelajar;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {



//Accessing SQlite Database
    static final String Database_Name = "Pelajar.db";
    public static final String Table_Name = "MarkahPelajar";
    public static final String COL1 = "No_Matrik";
    public static final String COL2 = "Name";
    public static final String COL3 = "Kohort";
    public static final String COL4 = "SEM";

    //MarkahPelajarSector

    public static final String Table = "Markah";
    public static final String S1 = "Id_Markah";
    public static final String S2 = "No_Matrik";
    public static final String S3 = "Markah";
    public static final String S4 = "Subjek";


    String CREATE_TABLE = "CREATE TABLE " + Table_Name + "(" + COL1 + " TEXT PRIMARY KEY NOT NULL, " + COL2 + " TEXT, " + COL3 +
            " INTEGER, " + COL4 +  " INTEGER " + ")";


    String BINA_TABLE = "CREATE TABLE " + Table + "(" + S1 + " INTERGER PRIMARY KEY AUTOINCREMENT, " + S2 + " TEXT, " + S3 +
            " INTEGER, " + S4 +  " TEXT, " + " FOREIGN KEY (" + S2 + ") REFERENCES " + Table_Name + "(" + COL1 + ")); ";

    public DatabaseHelper(Context context) {
        super(context,Database_Name,null,2);

    }

    //create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        db.execSQL(BINA_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        db.execSQL("DROP TABLE IF EXISTS " + Table);
        //if table does not exists, create table
        onCreate(db);
    }




    //Insert Data Pelajar
    public boolean insertData(String No_Matrik, String Name, String Kohort, String SEM) {
        //write data dalam table dalam database
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, No_Matrik);
        contentValues.put(COL2, Name);
        contentValues.put(COL3, Kohort);
        contentValues.put(COL4, SEM);

        long result = db.insert(Table_Name,null,contentValues);

        if(result == -1)
            return false;
            else
                return true;
    }

    //insert data markah
    public boolean masukdata(String No_Matrik, String Markah, String Subjek) {
        //write data dalam table dalam database
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(S2, No_Matrik);
        contentValues.put(S3, Markah);
        contentValues.put(S4, Subjek);

        long result = db.insert(Table,null,contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }

    //Get data pelajar
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM  " + Table_Name ,null);
        return result;
    }

    //Get data Markah
    public Cursor dapatsemuadata() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM  " + Table_Name, null);
        return result;
    }
    //Update Data Pelajar
    public boolean updatedata(String No_Matrik, String Name, String Kohort, String SEM){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, No_Matrik);
        contentValues.put(COL2, Name);
        contentValues.put(COL3, Kohort);
        contentValues.put(COL4, SEM);
        db.update(Table_Name,contentValues,"No_Matrik = ?", new String[]{No_Matrik});
        return true;
    }

    //Update data markah
    public boolean kemasdata(String Id_Markah, String No_Matrik, String Markah, String Subjek){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(S1, Id_Markah);
        contentValues.put(S2, No_Matrik);
        contentValues.put(S3, Markah);
        contentValues.put(S4, Subjek);
        db.update(Table,contentValues,"Id_Markah = ?", new String[]{Id_Markah});
        return true;
    }

    //delete data pelajar
    public int deletedata(String No_Matrik){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Table_Name, "No_Matrik = ?", new String[]{No_Matrik});
    }

    //delete data markah
    public int padamdata(String Id_Markah){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Table_Name, "Id_Markah = ?", new String[]{Id_Markah});
    }

}
