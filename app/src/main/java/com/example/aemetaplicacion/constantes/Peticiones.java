package com.example.aemetaplicacion.constantes;

import java.io.Serializable;

public class Peticiones implements Serializable {

    //construccion -> BASE_URL + url especifica + KEY_ANTES + KEY
    //--------------------
    public final static String KEY = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkLm1hbnphLm9AZ21haWwuY29tIiwianRpIjoiMzI5NTQzZDQtOWZlOC00ZWI3LTlmNGYtNWY2NDBhOGQ4MDMxIiwiaXNzIjoiQUVNRVQiLCJpYXQiOjE2Nzk5OTQwMDUsInVzZXJJZCI6IjMyOTU0M2Q0LTlmZTgtNGViNy05ZjRmLTVmNjQwYThkODAzMSIsInJvbGUiOiIifQ.iS-pyI2rDx8luybpjTqXn5p2T-ICFNxX184BxRGN9tM";

    public final static String KEY_ANTES = "/?api_key=";

    public final static String BASE_URL = "https://opendata.aemet.es/opendata/api";
    //-------------MUNICIPIOS---------------
    public final static String MUNICIPIOS_API_URL = BASE_URL + "/maestro/municipios/" +KEY_ANTES + KEY;

    //-------------PREDICCION---------------
    public final static String PREDICCION_API_URL = BASE_URL + "/prediccion/especifica/municipio/diaria/{municipio}" +KEY_ANTES + KEY;
    //--------------------
    public final static String ESTACIONES_URL = BASE_URL + "/valores/climatologicos/inventarioestaciones/todasestaciones/?api_key=";
    //public final static String ESTACIONES_URL = "https://opendata.aemet.es/opendata/api/valores/climatologicos/inventarioestaciones/todasestaciones/?api_key=";



    public final static String PREDICCION_URL = "/prediccion/especifica/municipio/diaria/{municipio}";


    //todos los municipios de españa -> https://opendata.aemet.es/opendata/api/maestro/municipios/?api_key=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkLm1hbnphLm9AZ21haWwuY29tIiwianRpIjoiMzI5NTQzZDQtOWZlOC00ZWI3LTlmNGYtNWY2NDBhOGQ4MDMxIiwiaXNzIjoiQUVNRVQiLCJpYXQiOjE2Nzk5OTQwMDUsInVzZXJJZCI6IjMyOTU0M2Q0LTlmZTgtNGViNy05ZjRmLTVmNjQwYThkODAzMSIsInJvbGUiOiIifQ.iS-pyI2rDx8luybpjTqXn5p2T-ICFNxX184BxRGN9tM

    //prediccion por municipios diaria -> https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/45098/?api_key=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkLm1hbnphLm9AZ21haWwuY29tIiwianRpIjoiMzI5NTQzZDQtOWZlOC00ZWI3LTlmNGYtNWY2NDBhOGQ4MDMxIiwiaXNzIjoiQUVNRVQiLCJpYXQiOjE2Nzk5OTQwMDUsInVzZXJJZCI6IjMyOTU0M2Q0LTlmZTgtNGViNy05ZjRmLTVmNjQwYThkODAzMSIsInJvbGUiOiIifQ.iS-pyI2rDx8luybpjTqXn5p2T-ICFNxX184BxRGN9tM

    //BASE_URL + url especifica ({municipio} = 5 numeros del id) + KEY_ANTES + KEY

}
