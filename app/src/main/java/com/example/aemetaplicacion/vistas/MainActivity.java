package com.example.aemetaplicacion.vistas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.aemetaplicacion.clases.Estacion;
import com.example.aemetaplicacion.constantes.Peticiones;
import com.example.aemetaplicacion.R;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public final static String KEY ="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkLm1hbnphLm9AZ21haWwuY29tIiwianRpIjoiMzI5NTQzZDQtOWZlOC00ZWI3LTlmNGYtNWY2NDBhOGQ4MDMxIiwiaXNzIjoiQUVNRVQiLCJpYXQiOjE2Nzk5OTQwMDUsInVzZXJJZCI6IjMyOTU0M2Q0LTlmZTgtNGViNy05ZjRmLTVmNjQwYThkODAzMSIsInJvbGUiOiIifQ.iS-pyI2rDx8luybpjTqXn5p2T-ICFNxX184BxRGN9tM";

    public final static String URL_PETICION1 = "https://opendata.aemet.es/opendata/api/valores/climatologicos/inventarioestaciones/todasestaciones/?api_key=" + KEY;

    public final static String PETICION = Peticiones.BASE_URL + Peticiones.MUNICIPIOS_API_URL + Peticiones.KEY_ANTES + Peticiones.KEY;

    private TextView txt_respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_respuesta = (TextView) findViewById(R.id.txt_respuesta);

        try {
            //hacer_llamada_al_aemet(URL_PETICION1);
            hacer_llamada_al_aemet(URL_PETICION1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void hacer_llamada_al_aemet(String URL_PETICION) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(URL_PETICION)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override //metodo para sacar los datos
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                final String myResponse = response.body().string(); //obtiene los datos que te devuelve el response
                String descripcion = "";
                String estado = "";
                String datos =  "";
                String metadatos =  "";
                try {
                    JSONObject json_respuesta = new JSONObject(myResponse);//vuelva el string que te devuelve en un json
                    descripcion = json_respuesta.getString("descripcion");
                    JSONObject probPrecipitacion = json_respuesta.getJSONObject("prediccion");
                    estado = json_respuesta.getString("estado");
                    metadatos =  json_respuesta.getString("datos");
                    datos =  json_respuesta.getString("datos");
                    obtener_datos_aemet(datos);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                call.cancel();
            }
        });
    }
    //----------------------------------------------------------------------------------------------------------------
    void obtener_datos_aemet(String URL_PETICION) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(URL_PETICION)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                // transformo los datos json obtenidos a un arrayList<Estacion> estaciones
                // mas información aquí: https://www.javatpoint.com/how-to-convert-json-array-to-arraylist-in-java
                String myResponse = "";
                ArrayList<Estacion> estaciones = new ArrayList<Estacion>();
                try {
                    myResponse = response.body().string();
                    JSONArray jsonArray = new JSONArray(myResponse);
                    if (jsonArray != null) {
                        for (int i=0;i<jsonArray.length();i++){
                            //jsonArray.get(i);
                            Gson gson= new Gson();
                            Estacion e1 = gson.fromJson(jsonArray.get(i).toString(),Estacion.class);//IMP
                            Log.i("json", "estacion " + i + " : "+ e1.toString());
                            System.out.println("estacion " + i + " i: " + e1.toString());
                            estaciones.add(e1);
                        }
                    }
                    // aquí tendrías que llamar al adaptador del recyclerview como en firebase, añadiendo los datos asíncronos recibidos
                    // adaptador_recyclerview.setListaEstaciones(estaciones);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                String finalMyResponse = myResponse;
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String texto = "";
                        for (Estacion es: estaciones )
                        {
                            texto = texto + es.getNombre() + "\n\n";
                        }
                        txt_respuesta.setText(texto);
                        // txt_respuesta.setText(finalMyResponse);
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                call.cancel();
            }
        });
    }
}