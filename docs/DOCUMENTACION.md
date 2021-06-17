# Documentacion

## Conociendo DateUtils

**DateUtils** es una libreria creada con el objetivo de poder convertir objetos pertenecientes a la API de Java 
que estan relacionados con las fechas y las horas. La libreria se encarga de agrupar un conjunto de funcionalidades 
publicas y existentes, que establecen la conversion de una menra facil y eficiente.

Tambien se incluyen metodos de conversion de cadenas de caracteres a objetos de fechas y viceversa, es muy comun 
necesitar este tipo de funcionalidades, por ejemplo cuando necesitamos mostrar la fecha y la hora visualmente como 
una cadena con un formato determinado.

## ¿Que no incluye DateUtils?

En su version inicial no incluira ninguno de los objetos de la API de Java que tienen alguna relacion con las horas, 
minutos, segundos y milisegundos, solo estaran aquellos objetos que estan relacionados con los años, meses, semanas, 
dias o aquellos objetos que estan relacionados con la fecha de manera generica.

## Clase DateUtils

La libreria esta compuesta principlamente por una unica clase, la cual posee un conjunto de metodos estaticos 
encargados de realizar estas funcionalidades, la clase tambien posee un campo que se encarga de almacenar 
el formato de conversion de cadenas de caractere a objetos de fecha y viceversa.

## ¿Cuando no es posible utilizar DateUtils?

La libreria esta pensada para realizar conversiones de la manera mas facil y mas probable hasta el momento.
En la gran mayoria de los casos la zona horaria se establece automaticamente a partir de la zona horaria
del sistema, si las conversiones a realizar tienen qu ver con una zona horaria especificada diferente de la del sistema,
entonces estas conversiones no le serviran, dado que la libreria realiza las conversiones basado en la zona horaria 
en la ue se encuentre el sistema.

# Metodos publicos de la clase DateUtils:

 - convertFromLocalDateToCalendar: convierte de un objeto LocalDate a un objeto Calendar.
 - convertFromCalendarToLocalDate: convierte de un objeto Calendar a un objeto LocalDate.
 - convertFromLocalDateToDate: convierte de un objeto LocalDate a un objeto Date.
 - convertFromDateToLocalDate: convierte de un objeto Date a un objeto LocalDate.
 - parse: convierte un objeto Calendar o un objeto LocalDate a una cadena de caracteres. 
 - format: convierte un cadena de carcateres valida.
 - setDefaultPattern: establece el nuevo patron de formato de fehca por defecto.
 - getDateTimeFormatter: devuelve un objeto DatetimeFormatter a partir del patron por defecto.
 - validDate: establece si una cadena de caracteres es una fecha valida.
 
# Documentacion de las Clases

[javadoc DateUtils](javadoc/index.html)


