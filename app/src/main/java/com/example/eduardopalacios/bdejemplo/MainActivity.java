package com.example.eduardopalacios.bdejemplo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eduardopalacios.bdejemplo.Clases.Item;
import com.example.eduardopalacios.bdejemplo.Helper.DBHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    Button btnInsertar,btnMostrar;

    EditText ETPlaca,ETMarca,ETModelo,ETAnio;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsertar=findViewById(R.id.insertar);
        btnInsertar.setOnClickListener(this);

        btnMostrar=findViewById(R.id.mostrar);
        btnMostrar.setOnClickListener(this);






        ETPlaca=findViewById(R.id.placa);
        ETMarca=findViewById(R.id.marca);
        ETModelo=findViewById(R.id.modelo);
        ETAnio=findViewById(R.id.anio);


        dbHelper=new DBHelper(this,"DBAutomoviles",null,1);






    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.insertar:
                insertarValores(ETPlaca.getText().toString(),ETMarca.getText().toString(),ETModelo.getText().toString(),Integer.parseInt(ETAnio.getText().toString()));

                break;





            case R.id.mostrar:
                obtenerValores();

                break;
                default:
                    break;
        }
    }

    public void insertarValores(String placa,String marca,String modelo,int  anio)
    {
        String sentencia="INSERT INTO Vehiculos(placa,marca,modelo,anio)"+"VALUES('"+placa+"' , '"+marca+"' , '"+modelo+"' , '"+anio+"')";
        SQLiteDatabase sqLiteDatabaseWritable=dbHelper.getWritableDatabase();


        sqLiteDatabaseWritable.execSQL(sentencia);

        sqLiteDatabaseWritable.close();

        Toast.makeText(getApplicationContext(),"Valores insertados",Toast.LENGTH_SHORT).show();
    }

    public void  obtenerValores()
    {
        String[]columnas={"codigo,placa","marca","modelo","anio"};
        List<Item>items=new ArrayList<>();

        SQLiteDatabase sqLiteDatabaseRedeable=dbHelper.getReadableDatabase();

        // "marca=?", new String[]{"Nissan"},
        Cursor cursor=sqLiteDatabaseRedeable.query("Vehiculos",columnas,"",null,null,null,"marca DESC");

        while (cursor.moveToNext())
        {
            items.add(new Item(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getInt(4)));

        }

        pasarValores(items);




    }

    public void pasarValores(List<Item> items)
    {
        Bundle bundle=new Bundle();

        bundle.putParcelableArrayList("PAR", (ArrayList<? extends Parcelable>) items);
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
