package com.example.eduardopalacios.bdejemplo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.eduardopalacios.bdejemplo.Adaptadores.ItemAdapter;
import com.example.eduardopalacios.bdejemplo.Clases.Item;
import com.example.eduardopalacios.bdejemplo.Helper.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    Toolbar toolbar;
    DBHelper helper;
    ListView listView;
    SearchView searchView;
    ItemAdapter adapter;
    List<Item> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle bundle=getIntent().getExtras();
        items=bundle.getParcelableArrayList("PAR");

        listView=findViewById(R.id.lista);

        adapter=new ItemAdapter(this,R.layout.disenio_listview,items);


        listView.setAdapter(adapter);


        helper=new DBHelper(this,"DBAutomoviles",null,1);

        onClickLista(listView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem searchItem=menu.findItem(R.id.action_search);

        searchView=(SearchView)searchItem.getActionView();
        searchView.setQueryHint("text");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {



                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                buscar_Elemento_Operador_Like(newText);
                return false;
            }
        });
        return true;
    }

   // public void buscar_Elemento(String texto)
    //{

//        String consulta="SELECT placa, marca, modelo, anio FROM vehiculos WHERE marca ="+"'"+texto+"'";
  //      SQLiteDatabase sqLiteDatabase=helper.getReadableDatabase();

        //rawQuery("SELECT id, name FROM people WHERE name = ? AND id = ?", new String[] {"David", "2"});
//        Cursor cursor=sqLiteDatabase.rawQuery(consulta,null);

  //      List<Item>items1=new ArrayList<>();
    //    while (cursor.moveToNext())
      //  {
        //    items1.add(new Item(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3)));

//        }

//       AgregarValoresAdapter(items1);


  //  }

    public void buscar_Elemento_Operador_Like(String texto)
    {

        String consulta="SELECT placa, marca, modelo, anio FROM vehiculos WHERE marca like '"+texto+"%'";

        SQLiteDatabase sqLiteDatabaseRedeable=helper.getReadableDatabase();

        List<Item>items2=new ArrayList<>();


        Cursor cursor=sqLiteDatabaseRedeable.rawQuery(consulta,null);

        while (cursor.moveToNext())
        {
            items2.add(new Item(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3)));

        }

        AgregarValoresAdapter(items2);


    }

    public void eliminarRegistro(int position)
    {
        String id[]={String.valueOf(position)};
       // String consulta="DELETE FROM vehiculos where codigo='"+position+"'";

        SQLiteDatabase sqLiteDatabaseRedeableDelete=helper.getReadableDatabase();
        sqLiteDatabaseRedeableDelete.delete("vehiculos","codigo =?",id);

       // sqLiteDatabaseRedeableDelete.execSQL(consulta);

        Toast.makeText(getApplicationContext(),"registro eliminado",Toast.LENGTH_SHORT)
                .show();
    }

    public void AgregarValoresAdapter(List<Item>items)
    {
        adapter.clear();
        adapter.addAll(items);
        listView.setAdapter(adapter);
    }

    public void onClickLista(ListView lista)
    {
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                eliminarRegistro(i+1);
               // Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
                //startActivity(intent);

            }
        });
    }
}
