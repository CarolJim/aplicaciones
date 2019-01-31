package com.example.supermai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DataDLender extends AppCompatActivity {

    Button cancelar, continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_dlender);

        cancelar = findViewById(R.id.btn_cancelar);
        continuar = findViewById(R.id.btn_continuar);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (DataDLender.this, PerfilActivity.class);
                startActivity(intent);
            }
        });

        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataDLender.this, DataWLender.class);
                startActivity(intent);
            }
        });
    }
}
