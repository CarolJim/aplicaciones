package com.example.supermai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoriasActivity extends AppCompatActivity {

    private TextView tvnombre, tvdescripcion;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        tvnombre = findViewById(R.id.tv_categoria);
        tvdescripcion = findViewById(R.id.tv_descripcion);
        img = findViewById(R.id.categothum);


        //Recieve data
        Intent intent = getIntent();
        String Nombre = ((Intent) intent).getExtras().getString("Nombre");
        String Descripcion = intent.getExtras().getString("Descripcion");
        int image = intent.getExtras().getInt("Thumbnail");

        //Setting values
        tvnombre.setText(Nombre);
        tvdescripcion.setText(Descripcion);
        img.setImageResource(image);


    }
}
