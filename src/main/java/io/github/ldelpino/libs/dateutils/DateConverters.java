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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Permite la conversión de objetos representados como fechas y horas en objetos
 * similares.
 * <p>
 * La clase está compuesta por un conjunto de métodos estáticos que se encargan
 * de la conversión de objetos de la API de Java relacionados con fechas y horas
 * en objetos similares. La clase funciona como una clase de utilidad para
 * realizar conversiones, permitiendo que sea más fácil el uso de objetos
 * relacionados con fechas y horas. La clase está establecida como
 * <strong>final</strong> para no permitir crear clases que hereden de ella y el
 * constructor está establecido como <strong>private</strong> para no pemitir
 * nuevas instancias de la clase.
 * </p>
 * En el modelo de conversión se hacen uso de los siguentes tipos de datos de
 * fechas y horas:
 * <ul>
 * <li>java.util.Date</li>
 * <li>java.sql.Date</li>
 * <li>java.util.Calendar</li>
 * <li>java.time.LocalDate</li>
 * <li>java.time.LocalTime</li>
 * <li>java.time.LocalDateTime</li>
 * </ul>
 *
 * @author Lázaro César del Pino Olivera
 * @since jdk-16.0.1
 * @version 1.0
 */
public final class DateConverters {

    /**
     * El identificador de la zona horaria por defecto.
     */
    public static final ZoneId DEFAULT_ZONE_ID = ZoneId.systemDefault();

    /**
     * La zona horaria a utilizar por defecto.
     */
    public static ZoneId zone_id = DEFAULT_ZONE_ID;

    /**
     * El constructor se establece como privado para no permitir instancias de
     * esta clase.
     */
    private DateConverters() {

    }

    /**
     * Convierte un objeto de tipo java.util.Date en un objeto de tipo Calendar
     *
     * @param date el objeto de tipo java.util.Date a convertir
     * @return el objeto de tipo Calendar convertido.
     */
    public static Calendar convertFromDateToCalendar(Date date) {
        return GregorianCalendar.from(date.toInstant().atZone(zone_id));
    }

    /**
     * Convierte un objeto de tipo java.util.Date en un objeto de tipo
     * LocalDate.
     *
     * @param date el objeto de tipo java.util.Date a convertir
     * @return el objeto de tipo LocalDate convertido.
     */
    public static LocalDate convertFromDateToLocalDate(Date date) {
        return LocalDate.ofInstant(date.toInstant(), zone_id);
    }

    /**
     * Convierte un objeto de tipo java.util.Date en un objeto de tipo
     * LocalTime.
     *
     * @param date el objeto de tipo java.util.Date a convertir
     * @return el objeto de tipo LocalTime convertido.
     */
    public static LocalTime convertFromDateToLocalTime(Date date) {
        return LocalTime.ofInstant(date.toInstant(), zone_id);
    }

    /**
     * Convierte un objeto de tipo java.util.Date en un objeto de tipo
     * LocalDateTime.
     *
     * @param date el objeto de tipo java.util.Date a convertir
     * @return el objeto de tipo LocalDateTime convertido.
     */
    public static LocalDateTime convertFromDateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), zone_id);
    }

    /**
     * Convierte un objeto de tipo java.util.Date en un objeto de tipo
     * java.sql.Date.
     *
     * @param date el objeto de tipo java.util.Date a convertir
     * @return el objeto de tipo java.sql.Date convertido.
     */
    public static java.sql.Date convertFromDateToSQLDate(Date date) {
        return new java.sql.Date(date.getTime());
    }

    /**
     * Convierte un objeto de tipo Calendar en un objeto de tipo LocalDate.
     *
     * @param calendar el objeto de tipo Calendar a convertir.
     * @return el objeto de tipo LocalDate convertido.
     */
    public static LocalDate convertFromCalendarToLocalDate(Calendar calendar) {
        return LocalDate.ofInstant(calendar.toInstant(), zone_id);
    }

    /**
     * Convierte un objeto de tipo Calendar en un objeto de tipo LocalDate.
     *
     * @param calendar el objeto de tipo Calendar a convertir.
     * @return el objeto de tipo LocalTime convertido.
     */
    public static LocalTime convertFromCalendarToLocalTime(Calendar calendar) {
        return LocalTime.ofInstant(calendar.toInstant(), zone_id);
    }

    /**
     * Convierte un objeto de tipo Calendar en un objeto de tipo LocalDate.
     *
     * @param calendar el objeto de tipo Calendar a convertir.
     * @return el objeto de tipo LocalDateTime convertido.
     */
    public static LocalDateTime convertFromCalendarToLocalDateTime(Calendar calendar) {
        return LocalDateTime.ofInstant(calendar.toInstant(), zone_id);
    }

    /**
     * Convierte un objeto de tipo LocalDate en un objeto de tipo
     * java.util.Date.
     *
     * @param localDate el objeto de tipo LocalDate a convertir.
     * @return el objeto de tipo java.util.Date convertido.
     */
    public static Date convertFromLocalDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(zone_id).toInstant());
    }

    /**
     * Convierte un objeto de tipo LocalDate en un objeto de tipo Calendar.
     *
     * @param localDate el objeto de tipo LocalDate a convertir.
     * @return el objeto de tipo Calendar convertido.
     */
    public static Calendar convertFromLocalDateToCalendar(LocalDate localDate) {
        return GregorianCalendar.from(localDate.atStartOfDay(zone_id));
    }

    /**
     * Convierte un objeto de tipo LocalDate en un objeto de tipo LocalDateTime.
     *
     * @param localDate el objeto de tipo LocalDate a convertir.
     * @return el objeto de tipo LocalDateTime convertido.
     */
    public static LocalDateTime convertFromLocalDateToLocalDateTime(LocalDate localDate) {
        return LocalDateTime.of(localDate, LocalTime.MIN);
    }

    /**
     * Convierte un objeto de tipo LocalTime en un objeto de tipo
     * java.util.Date.
     *
     * @param localTime el objeto de tipo LocalTime a convertir.
     * @return el objeto de tipo java.util.Date convertido.
     */
    public static Date convertFromLocalTimeToDate(LocalTime localTime) {
        return new Date(localTime.getSecond() * 1000);
    }

    /**
     * Convierte un objeto de tipo LocalTime en un objeto de tipo Calendar.
     *
     * @param localTime el objeto de tipo LocalTime a convertir.
     * @return el objeto de tipo Calendar convertido.
     */
    public static Calendar convertFromLocalTimeToCalendar(LocalTime localTime) {
        return GregorianCalendar.from(localTime.atDate(LocalDate.EPOCH).atZone(zone_id));
    }

    /**
     * Convierte un objeto de tipo LocalTime en un objeto de tipo LocalDateTime.
     *
     * @param localTime el objeto de tipo LocalTime a convertir.
     * @return el objeto de tipo LocalDateTime convertido.
     */
    public static LocalDateTime convertFromLocalTimeToLocalDateTime(LocalTime localTime) {
        return LocalDateTime.of(LocalDate.MIN, localTime);
    }

    /**
     * Convierte un objeto de tipo LocalDateTime en un objeto de tipo
     * java.util.Date.
     *
     * @param localDateTime el objeto de tipo LocalDateTime a convertir.
     * @return el objeto de tipo java.util.Date convertido.
     */
    public static Date convertFromLocalDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(zone_id).toInstant());
    }

    /**
     * Convierte un objeto de tipo LocalDateTime en un objeto de tipo Calendar.
     *
     * @param localDateTime el objeto de tipo LocalDateTime a convertir.
     * @return el objeto de tipo Calendar convertido.
     */
    public static Calendar convertFromLocalDateTimeToCalendar(LocalDateTime localDateTime) {
        return GregorianCalendar.from(localDateTime.atZone(zone_id));
    }

    /**
     * Devuelve la zona horaria establecida por defecto.
     *
     * @return la zona horaria establecida por defecto.
     */
    public static ZoneId getTimeZone() {
        return zone_id;
    }

    /**
     * Establece la nueva zona horaria por defecto.
     *
     * @param timeZone la nueva zona horaria a establecer.
     */
    public static void setDefaulTimeZone(ZoneId timeZone) {
        zone_id = timeZone;
    }
}
