package com.example.aemetaplicacion.vistas;

import static com.example.aemetaplicacion.constantes.Peticiones.MUNICIPIOS_API_URL;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.aemetaplicacion.R;
import com.example.aemetaplicacion.clases.Comunidad;
import com.example.aemetaplicacion.clases.Provincia;
import com.example.aemetaplicacion.clases.Municipio;
import com.google.gson.Gson;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class elegirDatosActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    public static final String EXTRA_CODIGO = "dhfvjhbejkvhjwehvl";
    private Spinner sp_comunidad = null;
    private Spinner sp_provincia = null;
    private Spinner sp_municipio = null;
    //-------------------
    private Comunidad comunidadSeleccionada;
    private Provincia provinciaSeleccionada;
    private Municipio municipioSeleccionado;
    //--------------------
    private ArrayList<Comunidad> comunidades;
    private ArrayList<Provincia> provincias;
    private ArrayList<Municipio> municipios;
    //--------------------
    String URL_PETICION1 = MUNICIPIOS_API_URL;
    //------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_datos);
        //----------------------------------------------------------------
        comunidades = leerComunidadesDesdeCSV();
        provincias = leerProvinciasDesdeCSV();
        municipios = leerPueblosDesdeCSV();
        //---------------------------------------------------
        sp_comunidad = (Spinner) findViewById(R.id.sp_comunidad);
        sp_provincia = (Spinner) findViewById(R.id.sp_provincia);
        sp_municipio = (Spinner) findViewById(R.id.sp_municipio);
        //-------------------MUESTRAS LAS COMUNIDADES--------------------------------
        sp_comunidad.setOnItemSelectedListener(this);
        ArrayAdapter<Comunidad> adaptador_comunidad = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, comunidades);
        adaptador_comunidad.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp_comunidad.setAdapter(adaptador_comunidad);
        //---------------------------------------------------
        sp_provincia.setOnItemSelectedListener(this);
        sp_municipio.setOnItemSelectedListener(this);
    }
    //------------------------------------------------------------------------------
    //------------------------------------------------------------------------------
    private ArrayList<Municipio> leerPueblosDesdeCSV() {
        //InputStream + BufferedReader para leer el fichero--------------------
        InputStream is = getResources().openRawResource(R.raw.pueblos_por_provincias);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8")));
        //String line es para la lectura de los datos--------------------------
        String line = "";
        ArrayList<Municipio> losmunicipios = new ArrayList<Municipio>();

        try {
            //mientras queden lineas por leer..
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(","); //cuando encuentre una coma, separa el texto
                String codigo_provincia = datos[0];
                String codigo_pueblo = datos[1];
                String nombre_pueblo = datos[2];
                //al municipio que le has dado memoria antes, le guardas el que ha leido
                Municipio p = new Municipio(codigo_provincia, codigo_pueblo, nombre_pueblo);
                losmunicipios.add(p);
            }
        } catch (IOException e1) {
            System.out.println("no pude abrir el fichero de los pueblos");
            Log.i("csv", "no pude abrir el fichero de los pueblos");
        }
        return losmunicipios;
    }
    //------------------------------------------------------------------------------
    //------------------------------------------------------------------------------
    private ArrayList<Provincia> leerProvinciasDesdeCSV() {
        //InputStream + BufferedReader para leer el fichero--------------------
        InputStream is = getResources().openRawResource(R.raw.provincias_por_comunidad);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8")));
        //String line es para la lectura de los datos--------------------------
        String line = "";
        ArrayList<Provincia> lasprovincias = new ArrayList<Provincia>();

        try {
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");

                String nombre_comunidad = datos[0];
                String codigo_comunidad = datos[1];
                String nombre1_provincia = datos[2];
                String nombre2_provincia = datos[3];
                String codigo_provincia = datos[4];

                Provincia p = new Provincia(nombre_comunidad,codigo_comunidad,nombre1_provincia,nombre2_provincia,codigo_provincia);
                lasprovincias.add(p);
            }
        } catch (IOException e1) {
            System.out.println("no pude abrir el fichero de provincias");
            Log.i("csv", "no pude abrir el fichero de provincias");
        }
        return lasprovincias;
    }
    //------------------------------------------------------------------------------
    //------------------------------------------------------------------------------
    private ArrayList<Comunidad> leerComunidadesDesdeCSV() {
        InputStream is = getResources().openRawResource(R.raw.comunidades);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8")));

        String line = "";
        ArrayList<Comunidad> lascomunidades = new ArrayList<Comunidad>();

        try {
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");

                String nombre_comunidad = datos[0];
                String codigo_comunidad = datos[1];

                Comunidad c = new Comunidad(nombre_comunidad,codigo_comunidad);
                lascomunidades.add(c);
            }
        } catch (IOException e1) {
            System.out.println("no pude abrir el fichero de provincias");
            Log.i("csv", "no pude abrir el fichero de provincias");
        }
        return lascomunidades;
    }
    //------------------------------------------------------------------------------
    //------------------------------------------------------------------------------
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch(adapterView.getId()) {
            case R.id.sp_comunidad:
                if(comunidadSeleccionada == null)//control de nulos
                {
                    comunidadSeleccionada = new Comunidad("Castilla - La Mancha","08");
                    sp_comunidad.setSelection(7);//poner la comunidad por defecto
                }
                //almacenamos la comunidad seleccionada
                comunidadSeleccionada  = (Comunidad)sp_comunidad.getSelectedItem();
                //recojo el codigo de la comunidad.csv en un string
                String codigo_comunidad = comunidadSeleccionada.getCodigo_Comunidad();
                // cargo las provincias
                ArrayList<Provincia> lasProvinciasComunidad = ObtenerProvinciasDeComunidad(comunidadSeleccionada);
                ArrayAdapter<Provincia> adaptador_provincia = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lasProvinciasComunidad);
                adaptador_provincia.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                sp_provincia.setAdapter(adaptador_provincia);
                break;

            case R.id.sp_provincia:
                if(provinciaSeleccionada == null)
                {
                    provinciaSeleccionada = new Provincia("Castilla - La Mancha","08","Toledo","Toledo","45");
                    sp_provincia.setSelection(1);
                }
                provinciaSeleccionada  = (Provincia) sp_provincia.getSelectedItem();
                String codigo_provincia = provinciaSeleccionada.getCodigo_provincia();
                // cargo las provincias
                ArrayList<Municipio> losPueblosProvincias = ObtenerPueblosDeProvincia(provinciaSeleccionada);
                ArrayAdapter<Municipio> adaptador_pueblo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, losPueblosProvincias);
                adaptador_pueblo.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                sp_municipio.setAdapter(adaptador_pueblo);

                break;

            case R.id.sp_municipio:
                if(municipioSeleccionado == null)
                {
                    municipioSeleccionado = new Municipio("45","161","Seseña");
                    sp_municipio.setSelection(160);

                }
                municipioSeleccionado  = (Municipio) sp_municipio.getSelectedItem();
                break;
        }
    }
    //------------------------------------------------------------------------------
    //------------------------------------------------------------------------------
    private ArrayList<Provincia> ObtenerProvinciasDeComunidad(Comunidad comunidadSeleccionada) {
        ArrayList<Provincia> provinciasComunidad = new ArrayList<Provincia>();
        String codigoComunidad = comunidadSeleccionada.getCodigo_Comunidad();
        for (Provincia p: provincias )
        {
            if(p.getCodigo_comunidad().equalsIgnoreCase(codigoComunidad))
            {
                provinciasComunidad.add(p);
            }
        }
        return provinciasComunidad;
    }

    //------------------------------------------------------------------------------
    //------------------------------------------------------------------------------
    private ArrayList<Municipio> ObtenerPueblosDeProvincia(Provincia provinciaSeleccionada) {
        ArrayList<Municipio> pueblosProvincia = new ArrayList<Municipio>();//creo una lista de municipios
        String codigoProvincia = provinciaSeleccionada.getCodigo_provincia();//almaceno el codigo de la provincia
        for (Municipio p: municipios ){
            //si el codigo que obtengo del municipio coincide con el que le paso por parámetro...
            if(p.getCodigo_provincia().equalsIgnoreCase(codigoProvincia))
            {
                pueblosProvincia.add(p);
            }
        }
        return pueblosProvincia;
    }
    //------------------------------------------------------------------------------
    //------------------------------------------------------------------------------
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        comunidadSeleccionada = new Comunidad("Castilla - La Mancha","08");
        provinciaSeleccionada = new Provincia("Castilla - La Mancha","08","Toledo","Toledo","45");
        municipioSeleccionado = new Municipio("45","161","Seseña");
    }
    //------------------------------------------------------------------------------
    //------------------------------------------------------------------------------
    public void buscar_datos(View view) {

        String codigo = municipioSeleccionado.getCodigo_provincia() + municipioSeleccionado.getCodigo_pueblo();

        Intent intent = new Intent(this, mostrar_Datos_Activity.class);
        intent.putExtra(EXTRA_CODIGO, codigo);
        startActivity(intent);
    }
}