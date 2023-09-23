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

        // Recuperar el ArrayList de la actividad anterior
        Intent intent = getIntent();
        ArrayList<RegistroCodigo> registros = (ArrayList<RegistroCodigo>) intent.getSerializableExtra("registros");

        // Obtener el TextView del layout
        TextView textViewCodigos = findViewById(R.id.textViewCodigos);

        // Crear una cadena para mostrar los registros en el TextView
        StringBuilder stringBuilder = new StringBuilder();

        for (RegistroCodigo registro : registros) {
            stringBuilder.append("Código: ").append(registro.getCodigo()).append("\n");
            stringBuilder.append("Descripcion: ").append(registro.getDescripcion()).append("\n");
            stringBuilder.append("Costo: ").append(registro.getCosto()).append("\n");
            stringBuilder.append("\n");
        }

        // Establecer el texto en el TextView
        textViewCodigos.setText(stringBuilder.toString());
    }
}