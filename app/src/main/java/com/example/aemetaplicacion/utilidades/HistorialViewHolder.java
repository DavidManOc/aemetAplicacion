package com.example.aemetaplicacion.utilidades;

import android.view.View;
import android.widget.TextView;
import com.example.aemetaplicacion.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HistorialViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView txt_rv_municipio_tiempo;
    public TextView txt_rv_temperatura_tiempo;
    public TextView txt_rv_precipitacion_tiempo;
    public TextView txt_rv_viento_tiempo;
    public TextView txt_rv_nublado_tiempo;

    ListaHistorialAdapter lcAdapter;
    //----------------------------------------------------------
    public HistorialViewHolder(@NonNull View itemView) {

        super(itemView);
        txt_rv_municipio_tiempo = (TextView) itemView.findViewById(R.id.txt_rv_municipio_tiempo);
        txt_rv_temperatura_tiempo = (TextView) itemView.findViewById(R.id.txt_rv_temperatura_tiempo);
        txt_rv_precipitacion_tiempo = (TextView) itemView.findViewById(R.id.txt_rv_precipitacion_tiempo);
        txt_rv_viento_tiempo = (TextView) itemView.findViewById(R.id.txt_rv_viento_tiempo);
        txt_rv_nublado_tiempo = (TextView) itemView.findViewById(R.id.txt_rv_nublado_tiempo);

        this.lcAdapter = lcAdapter;
        itemView.setOnClickListener(this);
    }
    //----------------------------------------------------------
    @Override
    public void onClick(View view) {

    }
}
