package com.example.supermai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DataGLender extends AppCompatActivity {

    Button continuar, cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_glender);

        continuar = findViewById(R.id.btn_continuar);
        cancelar = findViewById(R.id.btn_cancelar);


        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataGLender.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataGLender.this, DataDLender.class);
                startActivity(intent);
            }
        });
    }
}
