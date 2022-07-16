
 # Conociendo DateUtils

 **DateUtils** es una librería creada con el objetivo de poder convertir objetos pertenecientes a la API de Java,
 relacionados con las fechas y las horas. La librería se encarga de agrupar un conjunto de funcionalidades que 
 permiten la conversión de estos objetos de una manera fácil, rápida y sin perder eficiencia. La librería incluye
 métodos de conversion de objetos de fechas y horas en otros similares, así como la conversión de objetos de fechas
 y horas en cadenas de caracteres a partir de un formato específico y conversión de cadenas de caracteres en objetos
 de fechas y horas.
 
 En el modelo de conversión de hacen uso de los siguentes tipos de datos de fechas y horas:
 
 - java.util.Date
 - java.sql.Date
 - java.util.Calendar
 - java.time.LocalDate
 - java.time.LocalTime
 - java.time.LocalDateTime

 # ¿Que no incluye DateUtils?

 No se incluyen métodos de conversión que puedan ser obtenidos de manera directa, a partir de la propia API de java, 
 o a partir de las propiedades de la programacion orientada a objetos, por ejemplo:
 
 - De *java.util.Calendar* hacia *java.util.Date*.
 - De *java.sql.Date* hacia *java.util.Date*.
 - De *java.time.LocalDateTime* hacia *java.time.LocalDate*.
 - De *java.time.LocalDateTime* hacia *java.time.LocalTime*.

 # Metodos de conversión de objetos de fechas y horas hacia objetos similares
 
 Estos métodos poseen la siguiente nomenclatura: convertFrom*Tipo de dato origen*To*Tipo de datos destino*. Los
 métodos estan organizados por el tipo de dato origen.

 - **java.util.Date**
  - convertFromDateToCalendar(*java.util.Date*):*java.util.Calendar*.
  - convertFromDateToLocalDate(*java.util.Date*):*java.time.LocalDate*
  - convertFromDateToLocalTime(*java.util.Date*):*java.time.LocalTime*
  - convertFromDateToLocalDateTime(*java.util.Date*):*java.time.LocalDateTime*.
  - convertFromDateToSQLDate(*java.util.Date*):*java.sql.Date*
 -**java.util.Calendar**
  - convertFromCalendarToDate(*java.util.Calendar*):*java.util.Date* -> Se obtiene de forma directa.
  - convertFromCalendarToLocalDate(*java.util.Calendar*):*java.time.LocalDate*
  - convertFromCalendarToLocalTime(*java.util.Calendar*):*java.time.LocalTime*
  - convertFromCalendarToLocalDateTime(*java.util.Calendar*):*java.time.LocalDateTime*.
 -**java.time.LocalDate**
  - convertFromLocalDateToDate(*java.time.LocalDate*):*java.util.Date*.
  - convertFromLocalDateToCalendar(*java.time.LocalDate*):*java.util.Calendar*.
  - convertFromLocalDateToLocalDateTime(*java.time.LocalDate*):*java.time.LocalDateTime*.
 -**java.time.LocalTime**
  - convertFromLocalTimeToDate(*java.time.LocalTime*):*java.util.Date*.
  - convertFromLocalTimeToCalendar(*java.time.LocalTime*):*java.util.Calendar*.
  - convertFromLocalTimeToLocalDateTime(*java.time.LocalTime*):*java.time.LocalDateTime*.
 -**java.time.LocalDateTime**
  - convertFromLocalDateTimeToDate(*java.time.LocalDateTime*):*java.util.Date*.
  - convertFromLocalDateTimeToCalendar(*java.time.LocalDateTime*):*java.util.Calendar*.
  - convertFromLocalDateTimeToLocalDate(*java.time.LocalDateTime*):*java.time.LocalDate* -> Se obtiene de forma directa.
  - convertFromLocalDateTimeToLocalTime(*java.time.LocalDateTime*):*java.time.LocalTime* -> Se obtiene de forma directa.
 
 # Métodos de conversión de objetos de fechas y horas en cadenas de caracteres
 
 Los métodos poseen la siguiente nomenclatura: format*Tipo de dato a convertir a cadena, formato de conversión* y
 format*Tipo de datos a convertir a cadena a partir del formato predeterminado*.
 El formato de conversión es una cadena de caracteres que establece los nomencladores conocidos de un formato de 
 fecha y hora, por ejemplo: dd/MM/yyyy-HH:mm:ss establece un formato de fecha larga.
 
 - format(*java.util.Date*, *java.lang.String*):*java.lang.String*.
 - format(*java.util.Date*):*java.lang.String*.
 - format(*java.util.Calendar*, *java.lang.String*):*java.lang.String*.
 - format(*java.util.Calendar*):*java.lang.String*.
 - format(*java.time.LocalDate*, *java.lang.String*):*java.lang.String*.
 - format(*java.time.LocalDate*):*java.lang.String*.
 - format(*java.time.LocalTime*, *java.lang.String*):*java.lang.String*.
 - format(*java.time.LocalTime*):*java.lang.String*.
 - format(*java.time.LocalDateTime*, *java.lang.String*):*java.lang.String*.
 - format(*java.time.LocalDateTime*):*java.lang.String*. 

 # Metodos de conversión de cadenas de caracteres en objetos de fechas y horas.
 
 Los métodos posee la siguiente nomenclatura: parseTo*cadena a convertir, cadena del formato de conversión*. y
 parseTo*cadena a convertir a partir del formato de conversión predeterminado*.
 El formato de conversión es una cadena de caracteres que establece los nomencladores conocidos de un formato de 
 fecha y hora, por ejemplo: dd/MM/yyyy-HH:mm:ss establece un formato de fecha larga.

 - parseToDate(*java.lang.String*, *java.lang.String*):*java.util.Date*.
 - parseToDate(*java.lang.String*):*java.util.Date*.
 - parseToCalendar(*java.lang.String*, *java.lang.String*):*java.util.Calendar*.
 - parseToCalendar(*java.lang.String*):*java.util.Calendar*.
 - parseToLocalDate(*java.lang.String*, *java.lang.String*):*java.time.LocalDate*.
 - parseToLocalDate(*java.lang.String*):*java.time.LocalDate*.
 - parseToLocalTime(*java.lang.String*, *java.lang.String*):*java.time.LocalTime*.
 - parseToLocalTime(*java.lang.String*):*java.time.LocalTime*.
 - parseToLocalDateTime(*java.lang.String*, *java.lang.String*):*java.time.LocalDateTime*.
 - parseToLocalDateTime(*java.lang.String*):*java.time.LocalDateTime*.
 
 # Metodos de utilidad
 
 Los métodos de utilidad permiten establecer valores predeterminados para el formato de conversión de fechas y horas,
 de esta forma no es necesario tener que establecerlo cada vez que se necesite realizar una conversión. Incluye además 
 métodos de validación de cadenas de caracteres.
 - setDefaultDatePattern(*java.lang.String*):void -> Establece el nuevo patrón de formato de fecha por defecto.
 - getDefaultDateattern():*java.lang.String* -> Devuelve el patrón de fecha por defecto.
 - setDefaultTimePattern(*java.lang.String*):void -> Establece el nuevo patrón de formato de hora por defecto.
 - getDefaultTimePattern():*java.lang.String* -> Devuelve el patrón de hora por defecto.
 - setDefaultDateTimePattern(*java.lang.String*):void -> Establece el nuevo patrón de formato de fecha y hora 
 por defecto.
 - getDefaultDateTimePattern():*java.lang.String* -> Devuelve el patrón de fecha y hora por defecto.
 - getDateTimeFormatter():*java.time.DateTimeFormatter* -> Devuelve un objeto de tipo java.time.DateTimeFormatter 
 a partir del patrón por defecto.
 - validDate(*java.lang.String*, *java.lang.String*):boolean -> Establece si una cadena de caracteres es una 
 fecha y hora válida a partir de un patrón de formato.
 - validDate(*java.lang.String*):boolean -> Establece si una cadena de caracteres es una fecha y hora válida 
 utilizando el patrón de formato predeterminado.
 - setDefaultTimeZone(*java.time.ZoneId*):void -> Establece la nueva zona horaria por defecto.
 - getDefaultTimeZone():*java.time.ZoneId* -> Devuelve la zona horaria por defecto.
 
 # Metodología de uso de la librería

 - Hacer uso de la clase **DateConverters** para la conversión de objetos de fechas y horas en otros similares.
 - Hacer uso de las clases **DateFormatters** y **DateParsers** para la conversión de objetos de fechas y horas
 en cadenas de caracteres y viceversa.
 - Hacer uso de la clase **DatePatterns** para el establecimiento y obtención de los valores predeterminados de 
 formatos de fecha y hora.