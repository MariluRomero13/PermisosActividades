package com.example.permisosactividades;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AmarilloActivity extends AppCompatActivity {

    Switch camara, audio, ubicacion;
    LinearLayout contenedor;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amarillo);



        Bundle objetoEnviado = getIntent().getExtras();
        //camara = findViewById(R.id.camaraSwitch);
        //audio = findViewById(R.id.audioSwitch);
        //ubicacion = findViewById(R.id.ubicacionSwitch);


        contenedor = findViewById(R.id.contenedor);
        /*LinearLayout lp = new LinearLayout(this);
        lp.setOrientation(LinearLayout.HORIZONTAL);
        lp.setBackgroundColor(Color.rgb(255,0,0));

        LinearLayout.LayoutParams renglon = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,150);
        lp.setLayoutParams(renglon);

        TextView texto = new TextView(this);
        Switch sw = new Switch(this);

        texto.setText("Hola");
        texto.setTextColor(Color.rgb(255,255,255));
        texto.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 120,1));
        sw.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 120,1));

        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AmarilloActivity.this, "Ya funcionó :D", Toast.LENGTH_SHORT).show();
            }
        });

        contenedor.addView(lp);
        lp.addView(texto);
        lp.addView(sw);*/

        if(objetoEnviado != null)
        {
            ArrayList<String> permisosDenegados = objetoEnviado.getStringArrayList("permisosDenegados");
            for(int i = 0; i < permisosDenegados.size(); i++)
            {

                LinearLayout lp = new LinearLayout(this);
                lp.setOrientation(LinearLayout.HORIZONTAL);
                lp.setBackgroundColor(Color.rgb(255,0,0));

                LinearLayout.LayoutParams renglon = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,150);
                lp.setLayoutParams(renglon);

                TextView texto = new TextView(this);
                Switch sw = new Switch(this);
                sw.setTag(i,"id");

                texto.setText(permisosDenegados.get(i));
                texto.setTextColor(Color.rgb(255,255,255));
                texto.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 120,1));
                sw.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 120,1));


                sw.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(AmarilloActivity.this, v.getId(), Toast.LENGTH_SHORT).show();
                    }
                });

                contenedor.addView(lp);
                lp.addView(texto);
                lp.addView(sw);



                /*if(permisosDenegados.get(i).equals(Manifest.permission.CAMERA))
                {
                    //RelativeLayout r1 = findViewById(R.id.r1);
                    //r1.setVisibility(View.VISIBLE);
                }
                if(permisosDenegados.get(i).equals(Manifest.permission.RECORD_AUDIO))
                {
                    //RelativeLayout r2 = findViewById(R.id.r2);
                    //r2.setVisibility(View.VISIBLE);
                }
                if(permisosDenegados.get(i).equals(Manifest.permission.ACCESS_FINE_LOCATION))
                {
                    //RelativeLayout r3 = findViewById(R.id.r3);
                    //r3.setVisibility(View.VISIBLE);
                }*/
            }
        }

        /*View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    /*case R.id.camaraSwitch:
                        permisos(Manifest.permission.CAMERA,1,camara);
                        break;
                    case R.id.audioSwitch:
                        permisos(Manifest.permission.RECORD_AUDIO,2,audio);
                        break;
                    case R.id.ubicacionSwitch:
                        permisos(Manifest.permission.ACCESS_FINE_LOCATION,3,ubicacion);
                        break;
                }
            }
        };
        camara.setOnClickListener(click);
        audio.setOnClickListener(click);
        ubicacion.setOnClickListener(click);*/

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            /*case 1:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    camara.setChecked(true);
                    camara.setEnabled(false);
                }
                break;
            case 2:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    audio.setEnabled(false);
                    audio.setChecked(true);
                }
                break;
            case 3:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    ubicacion.setEnabled(false);
                    ubicacion.setChecked(true);
                }
                break;*/
        }
    }

    public void permisos(String permiso, int codigo, Switch sw)
    {
        /*if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
                if(ActivityCompat.shouldShowRequestPermissionRationale(AmarilloActivity.this, permiso))
                {
                    String[] lp = new String[] {permiso};
                    ActivityCompat.requestPermissions(AmarilloActivity.this,lp,codigo);
                    sw.setChecked(false);
                }
        }*/
    }
}


