package com.example.supermai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class DataDLender extends AppCompatActivity {

    List<Estados> lstestados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_dlender);

        lstestados = new ArrayList<>();
        lstestados.add(new Estados("Aguascalientes"));
        lstestados.add(new Estados("Baja California"));
        lstestados.add(new Estados("Baja California Sur"));
        lstestados.add(new Estados("Campeche"));
        lstestados.add(new Estados("Chiapas"));
        lstestados.add(new Estados("Chihuahua"));
        lstestados.add(new Estados("Ciudad de México"));
        lstestados.add(new Estados("Coahuila de Zaragoza"));
        lstestados.add(new Estados("Colima"));
        lstestados.add(new Estados("Durango"));
        lstestados.add(new Estados("Estado de México"));
        lstestados.add(new Estados("Guanajuato"));
        lstestados.add(new Estados("Guerrero"));
        lstestados.add(new Estados("Hidalgo"));
        lstestados.add(new Estados("Jalisco"));
        lstestados.add(new Estados("Michoacán de Ocampo"));
        lstestados.add(new Estados("Morelos"));
        lstestados.add(new Estados("Nayarit"));
        lstestados.add(new Estados("Nuevo León"));
        lstestados.add(new Estados("Oaxaca"));
        lstestados.add(new Estados("Puebla"));
        lstestados.add(new Estados("Querétaro"));
        lstestados.add(new Estados("Quintana Roo"));
        lstestados.add(new Estados("San Luis Potosí"));
        lstestados.add(new Estados("Sinaloa"));
        lstestados.add(new Estados("Sonora"));
        lstestados.add(new Estados("Tabasco"));
        lstestados.add(new Estados("Tamaulipas"));
        lstestados.add(new Estados("Tlaxcala"));
        lstestados.add(new Estados("Veracruz de Ignacio de la Llave"));
        lstestados.add(new Estados("Yucatán"));
        lstestados.add(new Estados("Zacatecas"));

        RecyclerView myrv = findViewById(R.id.rv_estados);
        RecyclerViewAdapter2 myAdapter = new RecyclerViewAdapter2(this,lstestados);
        myrv.setLayoutManager(new GridLayoutManager(this,1));
        myrv.setAdapter(myAdapter);







    }
}
