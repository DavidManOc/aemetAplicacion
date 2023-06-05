package com.example.aemetaplicacion.vistas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.aemetaplicacion.R;
import com.example.aemetaplicacion.clases.Clase_Dia;
import com.example.aemetaplicacion.clases.Datos_Prediccion;
import com.example.aemetaplicacion.clases.Datos_Principales;
import com.example.aemetaplicacion.clases.Estacion;
import com.example.aemetaplicacion.clases_prediccion.Prediccion_CotaNieve;
import com.example.aemetaplicacion.clases_prediccion.Prediccion_EstadoCielo;
import com.example.aemetaplicacion.clases_prediccion.Prediccion_Fecha;
import com.example.aemetaplicacion.clases_prediccion.Prediccion_HumedadRelativa;
import com.example.aemetaplicacion.clases_prediccion.Prediccion_Precipitacion;
import com.example.aemetaplicacion.clases_prediccion.Prediccion_SensacionTermica;
import com.example.aemetaplicacion.clases_prediccion.Prediccion_Temperatura;
import com.example.aemetaplicacion.clases_prediccion.Prediccion_Viento;
import com.example.aemetaplicacion.clases.Clase_Origen;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class mostrar_Datos_Activity extends AppCompatActivity {

    String tipo_codigo = "";
    public static String URL_PETICION = "";
    //----------------------------------------------------
    TextView txt_mostrar_datos_municipio = null;
    TextView txt_temp_maxima = null;
    TextView txt_temp_minima = null;
    TextView txt_precipitacion = null;
    TextView txt_cielo = null;
    TextView txt_viento = null;
    TextView txt_humedad = null;
    TextView txt_sens_termica = null;
    TextView txt_nieve = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        txt_mostrar_datos_municipio =   (TextView) findViewById(R.id.txt_mostrar_datos_municipio);
        txt_temp_maxima =               (TextView) findViewById(R.id.txt_temp_maxima);
        txt_temp_minima =               (TextView) findViewById(R.id.txt_temp_minima);
        txt_precipitacion =             (TextView) findViewById(R.id.txt_precipitacion);
        txt_cielo =                     (TextView) findViewById(R.id.txt_cielo);
        txt_viento =                    (TextView) findViewById(R.id.txt_viento);
        txt_humedad =                   (TextView) findViewById(R.id.txt_humedad);
        txt_sens_termica =              (TextView) findViewById(R.id.txt_sens_termica);
        txt_nieve =                     (TextView) findViewById(R.id.txt_nieve);
        //---------------------------------------------------------------------------
        Intent intent = getIntent();
        if(intent != null){
            tipo_codigo = intent.getStringExtra(elegirDatosActivity.EXTRA_CODIGO);
            URL_PETICION = "https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/"+tipo_codigo+"/?api_key=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkLm1hbnphLm9AZ21haWwuY29tIiwianRpIjoiNDM3Yzg4ZDgtZmM5OS00ZDI1LWI3MmUtNDU4YTEzYzA3ODc0IiwiaXNzIjoiQUVNRVQiLCJpYXQiOjE2ODU5NDcwMjksInVzZXJJZCI6IjQzN2M4OGQ4LWZjOTktNGQyNS1iNzJlLTQ1OGExM2MwNzg3NCIsInJvbGUiOiIifQ.SdDttPN4ZNscOAutjCHegyeWfmqXjEd-v2XqBOHMtVo";
        }
        //---------------------------------------------------------------------------
        try {
            hacer_llamada_al_aemet(URL_PETICION);

        } catch (IOException e) { e.printStackTrace(); }
    }
    //----------------------------------------------------
    private void hacer_llamada_al_aemet(String urlPeticion) throws IOException{
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(URL_PETICION)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                final String myResponse = response.body().string();
                //----------------------
                String descripcion = "";
                String estado = "";
                String datos =  "";
                String metadatos =  "";

                try {
                    JSONObject json_respuesta = new JSONObject(myResponse); //jsonObject -> cuando tengas mas de una linea en la respuesta
                    //----------------------
                    descripcion = json_respuesta.getString("descripcion");
                    estado = json_respuesta.getString("estado");
                    metadatos =  json_respuesta.getString("datos");
                    datos =  json_respuesta.getString("datos");
                    //----------------------
                    obtener_datos_aemet(datos); // le pasas la url que esta en datos

                } catch (JSONException e) { throw new RuntimeException(e); }
            }
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) { call.cancel(); }
        });
    }
    //-----------------------------------------------------------------------------
    void obtener_datos_aemet(String URL_PETICION) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(URL_PETICION)
                .build();

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                Gson gson = new Gson();

                final String myResponse2 = response.body().string();

                ArrayList<Datos_Principales> principales = new ArrayList<Datos_Principales>();

                Datos_Principales dp1 = new Datos_Principales();

                try{
                    //---------------------------------
                    JSONArray jsonArray = new JSONArray(myResponse2);
                    JSONObject myresponse3 = new JSONObject(jsonArray.get(0).toString());

                    String json_respuesta_origen = myresponse3.getString("origen");

                    dp1.setOrigen(gson.fromJson(json_respuesta_origen, Clase_Origen.class));
                    //-------------------------------------------------------
                    //-------------------------------------------------------
                    String json_respuesta_nombre = myresponse3.getString("nombre").replace(" ", "_");
                    dp1.setNombre(gson.fromJson(json_respuesta_nombre, String.class).replace("_", " "));
                    principales.add(dp1);
                    //--------------------------------------------------------------------
                    //--------------------------------------------------------------------
                    String json_respuesta_prediccion = myresponse3.getString("prediccion");
                    Datos_Prediccion prediccion1 = gson.fromJson(json_respuesta_prediccion, Datos_Prediccion.class);
                    Optional<Clase_Dia> dia1 =  prediccion1.getDia().stream().findFirst();
                    //--------------------------------------------------------------------
                    ArrayList<Prediccion_Precipitacion> preci = new ArrayList<>();
                    Optional<Prediccion_Precipitacion> precipitacion = dia1.get().getProbPrecipitacion().stream().findFirst();
                    preci.add(precipitacion.get());
                    //--------------------------------------------------------------------
                    ArrayList<Prediccion_CotaNieve> nieve = new ArrayList<>();
                    Optional<Prediccion_CotaNieve> cota_nieve = dia1.get().getCotaNieveProv().stream().findFirst();
                    nieve.add(cota_nieve.get());
                    //--------------------------------------------------------------------
                    ArrayList<Prediccion_EstadoCielo> cielo = new ArrayList<>();
                    Optional<Prediccion_EstadoCielo> estado_cielo = dia1.get().getEstadoCielo().stream().findFirst();
                    cielo.add(estado_cielo.get());
                    //--------------------------------------------------------------------
                    ArrayList<Prediccion_Viento> viento = new ArrayList<>();
                    Optional<Prediccion_Viento> estado_viento = dia1.get().getViento().stream().findFirst();
                    viento.add(estado_viento.get());
                    //--------------------------------------------------------------------
                    Prediccion_Temperatura temperatura = new Prediccion_Temperatura(dia1.get().getTemperatura().getMaxima(), dia1.get().getTemperatura().getMinima());
                    //--------------------------------------------------------------------
                    Prediccion_SensacionTermica termica = new Prediccion_SensacionTermica();
                    termica.setMaxima(dia1.get().getSensTermica().getMaxima());
                    //--------------------------------------------------------------------
                    Prediccion_HumedadRelativa humedad = new Prediccion_HumedadRelativa();
                    humedad.setMaxima(dia1.get().getHumedadRelativa().getMaxima());
                    //--------------------------------------------------------------------
                    Clase_Dia dia = new Clase_Dia();
                    dia.setProbPrecipitacion(preci);
                    dia.setEstadoCielo(cielo);
                    dia.setCotaNieveProv(nieve);
                    dia.setViento(viento);
                    dia.setTemperatura(temperatura);
                    dia.setSensTermica(termica);
                    dia.setHumedadRelativa(humedad);

                    Datos_Prediccion prediccion = new Datos_Prediccion();
                    ArrayList<Clase_Dia> dias = new ArrayList<>();
                    dias.add(dia);
                    prediccion.setDia(dias);
                    dp1.setPrediccion(prediccion);
                    //--------------------------------------------------------------------
                    //--------------------------------------------------------------------
                }catch (JSONException e){ throw new RuntimeException(e); }

                mostrar_Datos_Activity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Clase_Dia base = dp1.getPrediccion().getDia().stream().findFirst().get();

                        String tmax =           base.getTemperatura().getMaxima();
                        String tmin =           base.getTemperatura().getMinima();
                        String precipitacion =  base.getProbPrecipitacion().stream().findFirst().get().getValue();
                        String cielo =          base.getEstadoCielo().stream().findFirst().get().getValue();
                        String viento =         base.getViento().stream().findFirst().get().getVelocidad();
                        String humedad =        base.getHumedadRelativa().getMaxima();
                        String termica =        base.getSensTermica().getMaxima();
                        String nieve =          base.getCotaNieveProv().stream().findFirst().get().getValue();

                        txt_mostrar_datos_municipio.setText(dp1.getNombre());
                        txt_nieve.setText(nieve + "% de nieve");
                        txt_cielo.setText(cielo + "% nubosidad");
                        txt_humedad.setText(humedad + "% humedad");
                        txt_precipitacion.setText(precipitacion + "% probabilidad");
                        txt_temp_maxima.setText(tmax + "Cº");
                        txt_temp_minima.setText(tmin + "Cº");
                        txt_sens_termica.setText(termica + "Cº");
                        txt_viento.setText(viento + "Km/h");
                    }
                });
            }
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) { call.cancel(); }
        });
    }
}