# Documentacion

## Conociendo DateUtils

**DateUtils** es una libreria creada con el objetivo de poder convertir objetos pertenecientes a la API de Java 
que estan relacionados con las fechas y las horas. La libreria se encarga de agrupar un conjunto de funcionalidades 
que permiten la conversion de estos de una manera facil y eficiente.

Se incluyen metodos de conversion de cadenas de caracteres a objetos de fechas y horas y viceversa, es muy comun 
necesitar este tipo de funcionalidades, por ejemplo cuando necesitamos mostrar la fecha y la hora visualmente como 
una cadena con un formato determinado.

## ¿Que no incluye DateUtils?

La segunda version oficial de la libreria no incluira metodos de conversion con especto a zonas horarias.
No se inclyen metodos de conversion destructivos (aquellos en los que se pierda informacion vital).
No se incluyen metodos de conversion que puedan ser obtenidos de manera directa, 
por ejemplo:
- conversion de java.util.Calendar hacia java.util.Date (el objeto de tipo Calendar posee el metodo *getTime()*, el cual 
devuelve el objeto correspondiente de tipo Date).
- conversion de java.time.LocalDateTime hacia java.time.LocalDate y java.time.LocalTime (el objeto de tipo LocalDateTime
posee los metodos que permiten devolver los objetos correspondientes de tipo LocalDate y LocalTime a partir de los metodos
*getLocalDate()* y *getLocalTime()*).
- conversion de java.time.LocalDate y java.time.LocalTime hacia java.time.LocalDateTime (Este tipo de conversiones no 
existiran dado que los objetod de tipo LocalDateTime requieren de mas informacion).
- No se incluira hasta versiones posteriores la aplicacion de pruebas sobre la libreria Demo.


# Metodos publicos de la clase DateUtils:

## Metodos de conversio de objetos de fechas-horas hacia objetos similares

 - convertFromLocalDateTimeToCalendar(LocalDateTime):Calendar (convierte de un objeto LocalDateTime a un objeto Calendar).
 - convertFromCalendarToLocalDateTime(Calenda):LocalDateTime (convierte de un objeto Calendar a un objeto LocalDateTime).
 - convertFromLocalDateTimeToDate(LocalDateTime):Date (convierte de un objeto LocalDateTime a un objeto Date).
 - convertFromDateToLocalDateTime(Date):LocalDateTime (convierte de un objeto Date a un objeto LocalDateTime).
 - convertFromDateToCalendar(Date):Calendar (convierte un objeto de tipo Date en un objeto de tipo Calendar).
 
 ## Metodos de conversion de objetos de fechas-horas en cadenas de caracteres
 
 - format(LocalDateTime, String):String convierte un objeto de tipo LocalDateTime en una cadena de caracteres a partir 
 de un patron de formato.
 - format(LocalDateTime):String convierte un objeto de tipo LocalDateTime en una cadena de caracteres utilizando 
 el patron por defecto.
 - format(Calendar, String):String convierte un objeto de tipo Calendar en una cadena de caracteres a partir de un 
 patron de formato.
 - format(Calendar):String convierte un objeto de tipo Calendar en una cadena de caracteres utilizando 
 el patron por defecto.
 - format(Date, String):String convierte un objeto de tipo Date en una cadena de caracteres a partir de un 
 patron de formato.
 - format(Date):String convierte un objeto de tipo Date en una cadena de caracteres utilizando 
 el patron por defecto.
 - format(LocalDate, String):String convierte un objeto de tipo LocalDate en una cadena de caracteres a partir de un 
 patron de formato.
 - format(LocalDate):String convierte un objeto de tipo LocalDate en una cadena de caracteres utilizando 
 el patron por defecto.
 - format(LocalTime, String):String convierte un objeto de tipo LocalTime en una cadena de caracteres a partir de un 
 patron de formato.
 - format(LocalTime):String convierte un objeto de tipo LocalTime en una cadena de caracteres utilizando 
 el patron por defecto.

## Metodos de conversion de cadenas de caracteres en objetos de fechas-horas.

 - parseToLocalDateTime(String, String):LocalDateTime (convierte una cadena de caracteres valida en un objeto de tipo 
 LocalDateTime a partir de un patron de formato).
 - parseToLocalDateTime(String):LocalDateTime (convierte una cadena de caracteres valida en un objeto de tipo 
 LocalDateTime utilizando el patron de formato predeterminado).
 - parseToCalendar(String, String):Calendar (convierte una cadena de caracteres valida en un objeto de tipo 
 Calendar a partir de un patron de formato).
 - parseToCalendar(String):Calendar (convierte una cadena de caracteres valida en un objeto de tipo Calendar utilizando 
 el patron de formato predeterminado).
 - parseToDate(String, String):Date (convierte una cadena de caracteres valida en un objeto de tipo Date a partir de un 
 patron de formato).
 - parseToDate(String):Date (convierte una cadena de caracteres valida en un objeto de tipo Date utilizando el patron 
 de formato predeterminado).
 - parseToLocalDate(String, String):LocalDate (convierte una cadena de caracteres valida en un objeto de tipo LocalDate 
 a partir de un patron de formato).
 - parseToLocalDate(String):LocalDate (convierte una cadena de caracteres valida en un objeto de tipo LocalDate 
 utilizando el patron de formato predeterminado).
 - parseToLocalTime(String, String):LocalTime (convierte una cadena de caracteres valida en un objeto de tipo LocalTime 
 a partir de un patron de formato).
 - parseToLocalTime(String):LocalTime (convierte una cadena de caracteres valida en un objeto de tipo LocalTime 
 utilizando el patron de formato predeterminado).
 
 ## Metodos de utilidad
 
 - setDefaultDatePattern(String):void establece el nuevo patron de formato de fecha por defecto.
 - setDefaultTimePattern(String):void establece el nuevo patron de formato de hora por defecto.
 - setDefaultDateTimePattern(String):void establece el nuevo patron de formato de fecha-hora por defecto.
 - getDateTimeFormatter():DateTimeFormatter devuelve un objeto DatetimeFormatter a partir del patron por defecto.
 - validDate(String, String):boolean establece si una cadena de caracteres es una fecha-hora valida a partir de un 
 patron de formato.
 - validDate(String):boolean establece si una cadena de caracteres es una fecha-hora valida utilizando el patron 
 de formato predeterminado.
 
 ## Metodologia de uso de la libreria
 
 - Para poder hacer uso de la libreria, es necesario que se establezcan las dependencias necesarias sobre esta.
 - Hacer uso de la clase DateUtils y no crear objetos de esta, hasta la version, la clase solo posee metodos 
 estaticos de utilidad, por lo cual no es aconsejable la creacion de objetos a partir de esta clase.
 - Deerminar que tipode conversion desea realizar, conversion de unos objetos hacia otros (metodos *convert*) o 
 conversion de cadenas de caracteres en objetos (metodos *parse*) o conversion de objetos en cadenas de 
 caracteres (metodos *format*).
 - Correcta utilizacion y manipulacion de los patrones de formato de fecha y hora. Las cadenas de caracteres que 
 representan un patron de formato deben estar bien formadas, para mas informacion sobre creacion de patrones de 
 formato dirijase hacia la documentacion de las clases java.time.DateTimeFormatter de la API de Java.
 - Correct utilizacion de las cadenas de caracteres que representan una fecha-hora.
 