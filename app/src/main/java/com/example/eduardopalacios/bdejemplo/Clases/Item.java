package com.example.eduardopalacios.bdejemplo.Clases;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by eduardopalacios on 19/04/18.
 */

public class Item implements Parcelable{

    String placa,marca,modelo;
    int anio;

    public Item(String placa,String marca,String modelo,int anio)
    {
        this.placa=placa;
        this.marca=marca;
        this.modelo=modelo;
        this.anio=anio;
    }

    protected Item(Parcel in) {
        placa = in.readString();
        marca = in.readString();
        modelo = in.readString();
        anio = in.readInt();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(placa);
        parcel.writeString(marca);
        parcel.writeString(modelo);
        parcel.writeInt(anio);
    }
}
