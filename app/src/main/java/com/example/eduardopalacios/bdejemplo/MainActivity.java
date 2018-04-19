package com.example.eduardopalacios.bdejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    Button btnInsertar,btnActualizar,btnEliminar,btnMostrartodo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsertar=findViewById(R.id.insertar);
        btnInsertar.setOnClickListener(this);

        btnActualizar=findViewById(R.id.actualizar);
        btnActualizar.setOnClickListener(this);

        btnEliminar=findViewById(R.id.eliminar);
        btnEliminar.setOnClickListener(this);

        btnMostrartodo=findViewById(R.id.mostrar_Todo);
        btnMostrartodo.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.insertar:

                break;

            case R.id.actualizar:

                break;


            case R.id.eliminar:

                break;

            case R.id.mostrar_Todo:

                break;
                default:
                    break;
        }
    }
}
