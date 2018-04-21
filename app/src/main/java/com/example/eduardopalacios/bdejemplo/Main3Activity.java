package com.example.eduardopalacios.bdejemplo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.eduardopalacios.bdejemplo.Helper.DBHelper;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    EditText ETplaca2,ETmarca2,ETmodelo2,ETanio2;
    Button btnCancelar,btnActualizar;
    DBHelper helper;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ETplaca2=findViewById(R.id.placa2);
        ETmarca2=findViewById(R.id.marca2);
        ETmodelo2=findViewById(R.id.modelo2);
        ETanio2=findViewById(R.id.anio2);

        btnCancelar=findViewById(R.id.cancelar);
        btnCancelar.setOnClickListener(this);

        btnActualizar=findViewById(R.id.actualizar);
        btnActualizar.setOnClickListener(this);

        bundle=getIntent().getExtras();

        ETplaca2.setText(bundle.getString("placa"));
        ETmarca2.setText(bundle.getString("marca"));
        ETmodelo2.setText(bundle.getString("modelo"));
        ETanio2.setText(String.valueOf(bundle.getInt("anio")));


        helper=new DBHelper(this,"DBAutomoviles",null,1);







    }

    @Override
    public void onClick(View view) {
         if (view.getId()==R.id.cancelar)
         {

         }

         if (view.getId()==R.id.actualizar)
         {
           actualizarRegistro2(ETplaca2.getText().toString(),ETmarca2.getText().toString(),ETmodelo2.getText().toString(),
                              Integer.parseInt(ETanio2.getText().toString()));
         }
    }

    public void actualizarRegistro(String placa,String marca,String modelo,int anio)
    {
        int id=bundle.getInt("codigo");

        SQLiteDatabase sqLiteDatabase=helper.getWritableDatabase();

        ContentValues contentValues=new ContentValues();

        contentValues.put("placa",placa);
        contentValues.put("marca",marca);
        contentValues.put("modelo",modelo);
        contentValues.put("anio",anio);

        sqLiteDatabase.update("vehiculos",contentValues,"codigo=?", new String[] {String.valueOf(id)});
        sqLiteDatabase.close();

    }

    public void actualizarRegistro2(String placa,String marca,String modelo,int anio)
    {
        int id=bundle.getInt("codigo");
        String sentencia="UPDATE vehiculos SET placa= '"+placa+"' , marca= '"+marca+"', modelo= '"+modelo+"', anio= '"+anio+"' WHERE codigo="+id+";";

        SQLiteDatabase sqLiteDatabase=helper.getWritableDatabase();


        sqLiteDatabase.execSQL(sentencia);
        sqLiteDatabase.close();

    }


}
