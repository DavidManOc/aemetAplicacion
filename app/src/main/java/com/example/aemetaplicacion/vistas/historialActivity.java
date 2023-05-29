package com.example.aemetaplicacion.vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aemetaplicacion.R;
import com.example.aemetaplicacion.utilidades.ListaHistorialAdapter;

import android.os.Bundle;

public class historialActivity extends AppCompatActivity {

    RecyclerView rv_historial;

    private ListaHistorialAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
    }
}