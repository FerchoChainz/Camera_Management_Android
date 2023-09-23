package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;

public class Lector extends AppCompatActivity {

    private EditText resultado,descripcion, costo,code;
    private ArrayList<RegistroCodigo> registros = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lector);
        resultado = findViewById(R.id.txtCodigos);
        descripcion = findViewById(R.id.txtDescripcion);
        costo = findViewById(R.id.txtCosto);
    }

    public void escanearCodigo(View view){
        IntentIntegrator intentIntegrator = new IntentIntegrator
                (Lector.this);
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        intentIntegrator.setPrompt("Lector - CDP");
        intentIntegrator.setCameraId(0);
        intentIntegrator.setBeepEnabled(true);
        intentIntegrator.setBarcodeImageEnabled(true);
        intentIntegrator.initiateScan();
    }//escanear codigo

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        IntentResult intentResult =
                IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
//Validar que si recibe información
        if(intentResult != null ){
            if(intentResult.getContents() == null){
                Toast.makeText(this, "Lectura cancelada",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Datos Leidos",
                        Toast.LENGTH_SHORT).show();
                resultado.setText(intentResult.getContents());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }//onActivityResult

    public void guardarDatos(View view){
        Toast.makeText(this, "Datos Guardados", Toast.LENGTH_SHORT).show();        String desc = descripcion.getText().toString();
        String cost = costo.getText().toString();
        double costoR = Double.parseDouble(cost);

        RegistroCodigo registroCodigo = new RegistroCodigo(resultado.getText().toString(),desc,costoR);
        registros.add(registroCodigo);
        descripcion.setText("");
        costo.setText("");
    }

    public void mostrarLista(View view) {
        Intent intent = new Intent(this, ListaCodigosActivity.class);
        intent.putExtra("registros", registros);
        startActivity(intent);
    }
}
