package com.example.supermai;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class DataGLender extends AppCompatActivity {

    Button continuar, cancelar;
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;


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

        //-------------SLIDE DE IMAGENES ----------------------//
        viewPager = findViewById(R.id.viewPager);
        sliderDotspanel = findViewById(R.id.SliderDots);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getApplicationContext());
        viewPager.setAdapter(viewPagerAdapter);
        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {
            dots[i] = new ImageView(getApplicationContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.non_active_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            sliderDotspanel.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.non_active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot)); }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }
}
