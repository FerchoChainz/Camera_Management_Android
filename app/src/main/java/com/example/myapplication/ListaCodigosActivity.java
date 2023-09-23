package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ListaCodigosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_codigos);
        Intent intent = getIntent();
        ArrayList<RegistroCodigo> registros = (ArrayList<RegistroCodigo>) intent.getSerializableExtra("registros");

        TextView textViewCodigos = findViewById(R.id.textViewCodigos);
        
        StringBuilder stringBuilder = new StringBuilder();
        for (RegistroCodigo registro : registros) {
            stringBuilder.append("Código: ").append(registro.getCodigo()).append("\n");
            stringBuilder.append("Descripcion: ").append(registro.getDescripcion()).append("\n");
            stringBuilder.append("Costo: ").append(registro.getCosto()).append("\n");
            stringBuilder.append("\n");
        }
        textViewCodigos.setText(stringBuilder.toString());
    }
}
