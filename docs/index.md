# Documentacion

Contruccion de la version 1.0.2 de la libreria *En proceso....*

## Conociendo DateUtils

**DateUtils** es una libreria creada con el objetivo de poder convertir objetos pertenecientes a la API de Java 
que estan relacionados con las fechas y las horas. La libreria se encarga de agrupar un conjunto de funcionalidades 
que permiten la conversion de estos objetos de una manera facil y eficiente.

Se incluyen metodos de conversion de cadenas de caracteres a objetos de fechas y horas y viceversa, es muy comun 
necesitar este tipo de funcionalidades, por ejemplo cuando necesitamos mostrar la fecha y la hora visualmente como 
una cadena con un formato determinado.

## ¿Que no incluye DateUtils?

No se inclyen metodos de conversion destructivos (aquellos en los que se pierda informacion vital, como conversion 
de objetos de tipo java.time.Localdate hacia java.time LocalDateTime).
No se incluyen metodos de conversion que puedan ser obtenidos de manera directa, 
por ejemplo:
- conversion de java.util.Calendar hacia java.util.Date (el objeto de tipo Calendar posee el metodo *getTime()*, el cual 
devuelve el objeto correspondiente de tipo Date).
- conversion de java.time.LocalDateTime hacia java.time.LocalDate y java.time.LocalTime (el objeto de tipo LocalDateTime
posee los metodos que permiten devolver los objetos correspondientes de tipo LocalDate y LocalTime a partir de los metodos
*getLocalDate()* y *getLocalTime()*).
- conversion de java.time.LocalDate y java.time.LocalTime hacia java.time.LocalDateTime (Este tipo de conversiones no 
existiran dado que los objetos de tipo LocalDateTime requieren de mas informacion y seria necesario establecer balores 
por defecto).
- No se incluira hasta versiones posteriores la aplicacion de pruebas sobre la libreria Demo.

# Metodos publicos de la clase DateUtils:

## Metodos de conversion de objetos de fechas-horas hacia objetos similares

 - convertFromLocalDateTimeToCalendar(java.time.LocalDateTime):java.util.Calendar (convierte de un objeto 
 java.time.LocalDateTime a un objeto java.util.Calendar).
 - convertFromCalendarToLocalDateTime(java.util.Calendar):java.time.LocalDateTime (convierte de un objeto 
 java.util.Calendar a un objeto java.time.LocalDateTime).
 - convertFromLocalDateTimeToDate(java.time.LocalDateTime):java.util.Date (convierte de un objeto 
 java.time.LocalDateTime a un objeto java.util.Date).
 - convertFromDateToLocalDateTime(java.util.Date):java.time.LocalDateTime (convierte de un objeto 
 java.util.Date a un objeto java.time.LocalDateTime).
 - convertFromDateToCalendar(java.util.Date):java.util.Calendar (convierte un objeto de tipo 
 java.util.Date en un objeto de tipo java.util.Calendar).
 
 ## Metodos de conversion de objetos de fechas-horas en cadenas de caracteres
 
 - format(java.time.LocalDateTime, java.lang.String):java.lang.String convierte un objeto de tipo 
 java.time.LocalDateTime en una cadena de caracteres a partir de un patron de formato.
 - format(java.time.LocalDateTime):java.lang.String convierte un objeto de tipo java.time.LocalDateTime 
 en una cadena de caracteres utilizando el patron por defecto.
 - format(java.util.Calendar, java.lang.String):java.lang.String convierte un objeto de tipo 
 java.util.Calendar en una cadena de caracteres a partir de un patron de formato.
 - format( java.util.Calendar):java.lang.String convierte un objeto de tipo  java.util.Calendar 
 en una cadena de caracteres utilizando el patron por defecto.
 - format(java.util.Date, java.lang.String):java.lang.String convierte un objeto de tipo java.util.Date 
 en una cadena de caracteres a partir de un patron de formato.
 - format(java.util.Date):java.lang.String convierte un objeto de tipo java.util.Date en una cadena de 
 caracteres utilizando el patron por defecto.
 - format(java.time.LocalDate, java.lang.String):java.lang.String convierte un objeto de tipo 
 java.time.LocalDate en una cadena de caracteres a partir de un patron de formato.
 - format(java.time.LocalDate):java.lang.String convierte un objeto de tipo java.time.LocalDate en una 
 cadena de caracteres utilizando el patron por defecto.
 - format(java.time.LocalTime, java.lang.String):java.lang.String convierte un objeto de tipo 
 java.time.LocalTime en una cadena de caracteres a partir de un patron de formato.
 - format(java.time.LocalTime):java.lang.String convierte un objeto de tipo java.time.LocalTime en una 
 cadena de caracteres utilizando el patron por defecto.

## Metodos de conversion de cadenas de caracteres en objetos de fechas-horas.

 - parseToLocalDateTime(java.lang.String, java.lang.String):java.time.LocalDateTime (convierte una cadena 
 de caracteres valida en un objeto de tipo java.time.LocalDateTime a partir de un patron de formato).
 - parseToLocalDateTime(java.lang.String):java.time.LocalDateTime (convierte una cadena de caracteres 
 valida en un objeto de tipo java.time.LocalDateTime utilizando el patron de formato predeterminado).
 - parseToCalendar(java.lang.String, java.lang.String):java.util.Calendar (convierte una cadena de 
 caracteres valida en un objeto de tipo java.util.Calendar a partir de un patron de formato).
 - parseToCalendar(java.lang.String):java.util.Calendar (convierte una cadena de caracteres valida en un 
 objeto de tipo java.util.Calendar utilizando  el patron de formato predeterminado).
 - parseToDate(java.lang.String, java.lang.String):java.util.Date (convierte una cadena de caracteres 
 valida en un objeto de tipo java.util.Date a partir de un patron de formato).
 - parseToDate(java.lang.String):java.util.Date (convierte una cadena de caracteres valida en un objeto 
 de tipo java.util.Date utilizando el patron de formato predeterminado).
 - parseToLocalDate(java.lang.String, java.lang.String):java.time.LocalDate (convierte una cadena de 
 caracteres valida en un objeto de tipo java.time.LocalDate a partir de un patron de formato).
 - parseToLocalDate(java.lang.String):java.time.LocalDate (convierte una cadena de caracteres valida en 
 un objeto de tipo java.time.LocalDate utilizando el patron de formato predeterminado).
 - parseToLocalTime(java.lang.String, java.lang.String):java.time.LocalTime (convierte una cadena de 
 caracteres valida en un objeto de tipo java.time.LocalTime a partir de un patron de formato).
 - parseToLocalTime(java.lang.String):java.time.LocalTime (convierte una cadena de caracteres valida en 
 un objeto de tipo java.time.LocalTime utilizando el patron de formato predeterminado).
 
 ## Metodos de utilidad
 
 - setDefaultDatePattern(java.lang.String):void establece el nuevo patron de formato de fecha por defecto.
 - setDefaultTimePattern(java.lang.String):void establece el nuevo patron de formato de hora por defecto.
 - setDefaultDateTimePattern(java.lang.String):void establece el nuevo patron de formato de fecha-hora 
 por defecto.
 - getDateTimeFormatter():java.time.DateTimeFormatter devuelve un objeto java.time.DatetimeFormatter a 
 partir del patron por defecto.
 - validDate(java.lang.String, java.lang.String):boolean establece si una cadena de caracteres es una 
 fecha-hora valida a partir de un patron de formato.
 - validDate(java.lang.String):boolean establece si una cadena de caracteres es una fecha-hora valida 
 utilizando el patron de formato predeterminado.
 
 ## Metodologia de uso de la libreria
 
 - Para poder hacer uso de la libreria, es necesario que se establezcan las dependencias necesarias sobre esta.
 - Hacer uso de la clase DateUtils y no crear objetos de esta, hasta la version, la clase solo posee metodos 
 estaticos, por lo cual no es necesario la creacion de objetos a partir de esta clase.
 - Deerminar que tipo de conversion desea realizar, conversion de unos objetos hacia otros (metodos *convert*) o 
 conversion de cadenas de caracteres en objetos (metodos *parse*) o conversion de objetos en cadenas de 
 caracteres (metodos *format*).
 - Correcta utilizacion y manipulacion de los patrones de formato de fecha y hora. Las cadenas de caracteres que 
 representan un patron de formato deben estar bien formadas, para mas informacion sobre creacion de patrones de 
 formato dirijase hacia la documentacion de las clases java.time.DateTimeFormatter de la API de Java.
 - Correcta utilizacion de las cadenas de caracteres que representan una fecha-hora.
 