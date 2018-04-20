package com.example.eduardopalacios.bdejemplo.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by eduardopalacios on 18/04/18.
 */

public class DBHelper extends SQLiteOpenHelper {

    String sqlTablaVehiculo= "CREATE TABLE Vehiculos(codigo INTEGER PRIMARY KEY AUTOINCREMENT, placa TEXT, marca TEXT, modelo TEXT, anio INT)";


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

       // Si no existe la base de datos la crea y ejecuta los siguientes comandos


        sqLiteDatabase.execSQL(sqlTablaVehiculo);

        ContentValues contentValues=new ContentValues();

        contentValues.put("placa","AAA111");
        contentValues.put("marca","Seat");
        contentValues.put("modelo","Ibiza");
        contentValues.put("anio","2016");

        sqLiteDatabase.insert("Vehiculos",null,contentValues);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //sqLiteDatabase.execSQL("DROP TABLE Vehiculos");

    }
}
