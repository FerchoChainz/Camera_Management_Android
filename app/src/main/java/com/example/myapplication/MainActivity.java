package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lector(View view){
        Intent intent = new Intent(getApplicationContext(),
                Lector.class);
        startActivity(intent);
    }//Lector

    public void camara(View view){
        Intent intent = new Intent(getApplicationContext(),
                Foto.class);
        startActivity(intent);

    }
}