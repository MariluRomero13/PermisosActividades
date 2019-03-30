package com.example.permisosactividades;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyS {
    private static  VolleyS VS=null;
    private RequestQueue rq;

    private VolleyS(Context c) {
        rq= Volley.newRequestQueue(c);
    }

    public static VolleyS getInstance(Context c){
            if(VS ==null){

                VS=new VolleyS(c);
            }
        return   VS;

    }
    public  RequestQueue getRq(){
        return  rq;
    }



}
