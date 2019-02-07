package com.example.supermai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button ingresar, registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ingresar = findViewById(R.id.btn_ingresar);
        registrar = findViewById(R.id.btn_registrar);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ingresa = new Intent(HomeActivity.this, WelcomeActivity.class);
                startActivity(ingresa);
            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registra= new Intent(HomeActivity.this, RegisterActivity.class);
                startActivity(registra);
            }
        });


    }

    Intent avanza= new Intent(HomeActivity.this, RegisterActivity.class);

}
