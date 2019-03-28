package com.example.permisosactividades;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AmarilloActivity extends AppCompatActivity {

    Switch sh;
    LinearLayout contenedor;
    ArrayList<String> permisosDenegados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amarillo);
        Bundle objetoEnviado = getIntent().getExtras();

        contenedor = findViewById(R.id.contenedor);
        if (objetoEnviado != null) {
            permisosDenegados = objetoEnviado.getStringArrayList("permisosDenegados");
            for (int i = 0; i < permisosDenegados.size(); i++) {
                LinearLayout lp = new LinearLayout(this);
                lp.setOrientation(LinearLayout.HORIZONTAL);
                lp.setBackgroundColor(Color.rgb(15, 15, 15));
                LinearLayout.LayoutParams renglon = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 150);


                lp.setLayoutParams(renglon);

                TextView texto = new TextView(this);
                Switch sw = new Switch(this);
                sw.setId(i);
                texto.setText(permisosDenegados.get(i));
                texto.setTextColor(Color.rgb(255, 255, 255));
                texto.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 120, 1));
                sw.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 120, 1));
                sw.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sh = (Switch) view;
                        permisos(permisosDenegados.get(view.getId()), 1, sh);
                    }
                });



                lp.addView(texto);
                lp.addView(sw);
                contenedor.addView(lp);


            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            sh.setChecked(true);
        } else {
            sh.setChecked(false);
        }
    }

    public void permisos(String permiso, int codigo, Switch sw) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] lp = new String[]{permiso};
            ActivityCompat.requestPermissions(AmarilloActivity.this, lp, codigo);

        }
    }

    public void regresar(View view) {

        Intent i = new Intent(AmarilloActivity.this, MainActivity.class);

        startActivity(i);
    }
}


