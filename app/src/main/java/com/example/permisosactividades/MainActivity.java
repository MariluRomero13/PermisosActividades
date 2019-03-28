package com.example.permisosactividades;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        String[] permisos = new String[] {Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO, Manifest.permission.ACCESS_FINE_LOCATION};
        ArrayList<String> permisosDenegados = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            metodoPermisos();
        }

        public void permisos()
        {

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            {
                permisosDenegados.clear();
                for (int i = 0; i < permisos.length; i++)
                {
                    if(ActivityCompat.checkSelfPermission(MainActivity.this, permisos[i]) != PackageManager.PERMISSION_GRANTED)
                    {
                        permisosDenegados.add(permisos[i]);
                    }
                }
            }
        }

        public void metodoPermisos()
        {
            permisos();
            if(permisosDenegados.size() >= 1)
            {

                Intent actividad2 = new Intent(MainActivity.this, AmarilloActivity.class);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("permisosDenegados", permisosDenegados);
                actividad2.putExtras(bundle);
                startActivity(actividad2);
            }
        }

}
