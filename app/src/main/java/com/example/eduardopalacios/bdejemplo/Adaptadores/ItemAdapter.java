package com.example.eduardopalacios.bdejemplo.Adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.eduardopalacios.bdejemplo.Clases.Item;
import com.example.eduardopalacios.bdejemplo.Holders.HolderItem;
import com.example.eduardopalacios.bdejemplo.R;

import java.util.List;

/**
 * Created by eduardopalacios on 19/04/18.
 */

public class ItemAdapter extends ArrayAdapter<Item> {

    Context context;
    int resource;
    List<Item> items;


    public ItemAdapter( Context context, int resource, List<Item> items) {

        super(context, resource, items);
        this.context=context;
        this.resource=resource;
        this.items=items;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        View view=convertView;
        HolderItem holder;

        if (view==null)
        {
            LayoutInflater inflater=LayoutInflater.from(context);
            view=inflater.inflate(resource,null,false);
            holder=new HolderItem();

            holder.placa=view.findViewById(R.id.DL_placa);
            holder.marca=view.findViewById(R.id.DL_marca);
            holder.modelo=view.findViewById(R.id.DL_modelo);
            holder.anio=view.findViewById(R.id.DL_anio);
            view.setTag(holder);

        }
        else {
            holder=(HolderItem)view.getTag();
        }

        holder.placa.setText("Placa: "+items.get(position).getPlaca());
        holder.marca.setText(items.get(position).getMarca());
        holder.modelo.setText(items.get(position).getModelo());
        holder.anio.setText("Año: "+String.valueOf(items.get(position).getAnio()));

        return view;
    }
}
