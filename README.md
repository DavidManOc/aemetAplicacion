# aemetAplicacion
David´s final project for the course

//-------------------------------------------------------------------------------------

Introducción:

El objetivo principal de este proyecto es crear una herramienta útil y práctica 
que brinde información confiable y actualizada sobre el clima en una ciudad específica de España.

Hay muchos posibles usos para una aplicación que consulte la información meteorológica de una ciudad de España. 
Algunos de ellos incluyen:

  1.	Planificación de actividades al aire libre. 
  2.	Planificación de viajes.
  3.	Agricultura y jardinería.
  4.	Seguridad vial. 
  5.	Deportes.

//-------------------------------------------------------------------------------------

Idea del proyecto: Surgió un día revisando los ejercicios de Acceso a Datos, ya que en clase hicimos un ejercicio de obtener los datos meteorológicos (de la AEMET) del día siguiente de una ciudad concreta.

//-------------------------------------------------------------------------------------

Desarrollo del proyecto:

   Requisitos funcionales: 
   
   *Registro / logeo usuario.
   
   *Función de obtención de los datos. 
   
   *Guardar los datos. 
   
   *Revisar Historial de comparaciones.

   Requisito no funcional: 
      *Proyecto adaptable a diversos dispositivos, de forma horizontal y vertical

   Modelo Entidad-Relación: 
      *Usuario: Atributos -> (ID, Nombre, Email, PassWord) 
      *Búsqueda: Atributos -> (Temperatura máxima y mínima, humedad, viento, precipitación, nieve, sensación térmica y el estado del cielo)
        
//-------------------------------------------------------------------------------------

   Previo a mostrar los datos, hay que especificar el municipio sobre el que quieres realizar la búsqueda.

   Se han almacenado en archivos .csv las Comunidades Autónomas, Provincias y Municipios de España.

   Filtrado de municipios: 
   
   *Se usan spinners para cada apartado (Comunidades Autónomas, Provincias y Municipios)
   
   *En el spinner de las comunidades, se muestran todas las comunidades y ciudades autonómicas de España.
   
   *En el spinner de las provincias, se muestran las provicias que pertenecen a su Comunidad Autónoma.
   
   *En el spinner de los municipios, se muestran todos los municipios de la provincia. 

//-------------------------------------------------------------------------------------

   Todos los datos de los usuarios están alamcenados en una base de datos de FireBase



