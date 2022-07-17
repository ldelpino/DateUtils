/*
 * Copyright 2022 ldelpino.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.ldelpino.libs.dateutils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * La clase se encarga de la conversion de cadenas de caracteres en objetos de
 * la API de Java relacionados con las fechas y horas.
 * <p>
 * La clase está compuesta por un conjunto de métodos estáticos que se encargan
 * de la conversión de cadenas de caracteres en objetos de la API de Java
 * relacionados con fechas y horas a partir de un patrón de formato específico,
 * por ejemplo: dd/MM/yyyy-HH:mm:ss. Para la realización de la conversión la
 * clase utiliza el patrón de formato de fecha y hora por defecto de la clase
 * {@link io.github.ldelpino.libs.dateutils.DatePatterns}. Para la conversión de
 * objetos de fechas y horas en cadenas de caracteres se utiliza la clase
 * {@link io.github.ldelpino.libs.dateutils.DateFormatters}. La clase está
 * establecida como
 * <strong>final</strong> para no permitir crear clases que hereden de ella y el
 * constructor está establecido como <strong>private</strong> para no pemitir
 * nuevas instancias de la clase.</p>
 * En el modelo de conversión se hacen uso de los siguentes tipos de datos de
 * fechas y horas:
 * <ul>
 * <li>java.util.Date</li>
 * <li>java.util.Calendar</li>
 * <li>java.time.LocalDate</li>
 * <li>java.time.LocalTime</li>
 * <li>java.time.LocalDateTime</li>
 * </ul>
 *
 * @author Lázaro César del Pino Olivera
 * @since jdk-16.0.1
 * @version 1.0
 * @see io.github.ldelpino.libs.dateutils.DatePatterns
 * @see io.github.ldelpino.libs.dateutils.DateFormatters
 */
public final class DateParsers {

    private DateParsers() {

    }

    /**
     * Convierte una cadena de caracteres en un objeto de fecha y hora de tipo
     * {@link java.util.Date} a partir de un patrón de formato establecido.
     * <p>
     * El patrón de formato de establecido se obtiene a través del método
     * {@link io.github.ldelpino.libs.dateutils.DatePatterns#getDateTimePattern()}
     * </p>
     *
     * @param date la cadena de caracteres a convertir.
     * @return el objeto de fecha y hora convertido.
     */
    public static Date parseToDate(String date) {
        return parseToDate(date, DatePatterns.getDateTimePattern());
    }

    /**
     * Convierte una cadena de caracteres en un objeto de fecha y hora de tipo
     * {@link java.util.Calendar} a partir de un patrón de formato establecido.
     * <p>
     * El patrón de formato de establecido se obtiene a través del método
     * {@link io.github.ldelpino.libs.dateutils.DatePatterns#getDateTimePattern()}
     * </p>
     *
     * @param calendar la cadena de caracteres a convertir.
     * @return el objeto de fecha y hora convertido.
     */
    public static Calendar parseToCalendar(String calendar) {
        return parseToCalendar(calendar, DatePatterns.getDateTimePattern());
    }

    /**
     * Convierte una cadena de caracteres en un objeto de fecha de tipo
     * {@link java.time.LocalDate} a partir de un patrón de formato establecido.
     * <p>
     * El patrón de formato de establecido se obtiene a través del método
     * {@link io.github.ldelpino.libs.dateutils.DatePatterns#getDatePattern()}
     * </p>
     *
     * @param localDate la cadena de caracteres a convertir.
     * @return el objeto de fecha convertido.
     */
    public static LocalDate parseToLocalDate(String localDate) {
        return parseToLocalDate(localDate, DatePatterns.getDatePattern());
    }

    /**
     * Convierte una cadena de caracteres en un objeto de hora de tipo
     * {@link java.time.LocalTime} a partir de un patrón de formato establecido.
     * <p>
     * El patrón de formato de establecido se obtiene a través del método
     * {@link io.github.ldelpino.libs.dateutils.DatePatterns#getTimePattern()}
     * </p>
     *
     * @param timePattern la cadena de caracteres a convertir.
     * @return el objeto de hora convertido.
     */
    public static LocalTime parseToLocalTime(String timePattern) {
        return parseToLocalTime(timePattern, DatePatterns.getTimePattern());
    }

    /**
     * Convierte una cadena de caracteres en un objeto de fecha y hora de tipo
     * {@link java.time.LocalDateTime} a partir de un patrón de formato
     * establecido.
     * <p>
     * El patrón de formato de establecido se obtiene a través del método
     * {@link io.github.ldelpino.libs.dateutils.DatePatterns#getDateTimePattern()}
     * </p>
     *
     * @param localDateTime la cadena de caracteres a convertir.
     * @return el objeto de fecha y hora convertido.
     */
    public static LocalDateTime parseToLocalDateTime(String localDateTime) {
        return parseToLocalDateTime(localDateTime, DatePatterns.getDateTimePattern());
    }

    /**
     * Convierte una cadena de caracteres en un objeto de fecha y hora de tipo
     * {@link java.util.Date} a partir de un patrón de formato especificado.
     *
     * @param date la cadena de caracteres a convertir.
     * @param dateTimePattern el patrón de formato de fecha y hora.
     * @return el objeto de fecha y hora convertido.
     */
    public static Date parseToDate(String date, String dateTimePattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimePattern);
        Instant instant = formatter.parse(date, Instant::from);
        return Date.from(instant);
    }

    /**
     * Convierte una cadena de caracteres en un objeto de fecha y hora de tipo
     * {@link java.util.Calendar} a partir de un patrón de formato especificado.
     *
     * @param calendar la cadena de caracteres a convertir.
     * @param dateTimePattern el patrón de formato de fecha y hora.
     * @return el objeto de fecha y hora convertido.
     */
    public static Calendar parseToCalendar(String calendar, String dateTimePattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimePattern);
        Instant instant = formatter.parse(calendar, Instant::from);
        return GregorianCalendar.from(instant.atZone(DateConverters.getTimeZone()));
    }

    /**
     * Convierte una cadena de caracteres en un objeto de fecha y hora de tipo
     * {@link java.time.LocalDate} a partir de un patrón de formato
     * especificado.
     *
     * @param localDate la cadena de caracteres a convertir.
     * @param datePattern el patrón de formato de fecha.
     * @return el objeto de fecha convertido.
     */
    public static LocalDate parseToLocalDate(String localDate, String datePattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
        return formatter.parse(localDate, LocalDate::from);
    }

    /**
     * Convierte una cadena de caracteres en un objeto de fecha y hora de tipo
     * {@link java.time.LocalTime} a partir de un patrón de formato
     * especificado.
     *
     * @param localTime la cadena de caracteres a convertir.
     * @param timePattern el patrón de formato de hora.
     * @return el objeto de hora convertido.
     */
    public static LocalTime parseToLocalTime(String localTime, String timePattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timePattern);
        return formatter.parse(localTime, LocalTime::from);
    }

    /**
     * Convierte una cadena de caracteres en un objeto de fecha y hora de tipo
     * {@link java.time.LocalDateTime} a partir de un patrón de formato
     * especificado.
     *
     * @param localDateTime la cadena de caracteres a convertir.
     * @param dateTimePattern el patrón de formato de fecha y hora.
     * @return el objeto de fecha y hora convertido.
     */
    public static LocalDateTime parseToLocalDateTime(String localDateTime, String dateTimePattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimePattern);
        return formatter.parse(localDateTime, LocalDateTime::from);
    }
}
