package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Foto extends AppCompatActivity {

    private ImageView foto;
    private ArrayList<Bitmap> fotos = new ArrayList<>();
    private int fotoActual = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);
        foto = findViewById(R.id.imgFoto);
    }

    public void tomarFoto(View view){
        abrirCamara();
    }

    public void abrirCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent,1);
        }
    }

    public void mostrarSiguienteFoto(View view) {
        if (fotoActual < fotos.size() - 1) {
            fotoActual++;
            mostrarFotoActual();
        }
    }

    public void mostrarAnteriorFoto(View view) {
        if (fotoActual > 0) {
            fotoActual--;
            mostrarFotoActual();
        }
    }

    private void mostrarFotoActual() {
        if (fotoActual >= 0 && fotoActual < fotos.size()) {
            foto.setImageBitmap(fotos.get(fotoActual));
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "Tomar Foto", Toast.LENGTH_SHORT).show();
        if (requestCode == 1 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap bitmap = (Bitmap) extras.get("data");
            foto.setImageBitmap(bitmap);

            fotos.add(bitmap);
            fotoActual = fotos.size() -1 ;
        }
    }
}