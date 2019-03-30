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
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.permisosactividades.Modelos.User;
import com.google.gson.Gson;


import org.json.JSONException;
import org.json.JSONObject;

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

    public void iniciarSesion(View view) {
        EditText ed=findViewById(R.id.txt_email);
        EditText pas=findViewById(R.id.txt_contra);

        JSONObject dd = new JSONObject();

        try {
            dd.put("email",ed.getText().toString());
            dd.put("password",pas.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jor=new JsonObjectRequest(Request.Method.POST, Datos.URL+"/login",dd, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                Gson gson = new Gson();

               User us= gson.fromJson(response.getJSONObject("datos").getJSONObject("user").toString(), User.class);
                Log.d("contestar",response.toString());


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });




        VolleyS.getInstance(this).getRq().add(jor);

    }
}
