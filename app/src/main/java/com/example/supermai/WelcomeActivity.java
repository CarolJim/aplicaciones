package com.example.supermai;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {

    List<Categorias> lstCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        lstCategorias = new ArrayList<>();
        lstCategorias.add(new Categorias("HOGAR", "Descripcion opciones", R.drawable.ic_smart_home));
        lstCategorias.add(new Categorias("MASCOTAS", "Descripcion opciones", R.drawable.ic_perro));
        lstCategorias.add(new Categorias("HIGIENE", "Descripcion opciones", R.drawable.ic_respeto));
        lstCategorias.add(new Categorias("EVENTOS", "Descripcion opciones", R.drawable.ic_chico));
        lstCategorias.add(new Categorias("RESCATE", "Descripcion opciones", R.drawable.ic_suelo));
        lstCategorias.add(new Categorias("FAST FOOD", "Descripcion opciones", R.drawable.ic_cafe));

        RecyclerView myrv = findViewById(R.id.rv);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, lstCategorias);
        myrv.setLayoutManager(new GridLayoutManager(this, 2));
        myrv.setAdapter(myAdapter);


    }
}
