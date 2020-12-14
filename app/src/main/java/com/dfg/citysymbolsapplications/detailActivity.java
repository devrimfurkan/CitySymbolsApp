package com.dfg.citysymbolsapplications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detailActivity extends AppCompatActivity {
    TextView landmarkName;
    ImageView imageView;
    TextView discription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        landmarkName=findViewById(R.id.landmarkName);
        discription=findViewById(R.id.discription);
        imageView=findViewById(R.id.imageView);

        Intent intent=getIntent();
        String landmark=intent.getStringExtra("name");
        String country=intent.getStringExtra("country");
        discription.setText(country);
        landmarkName.setText(landmark);

        Singleton singleton=Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosenImage());
    }
}