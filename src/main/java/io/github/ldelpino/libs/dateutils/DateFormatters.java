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
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * La clase se encarga de la conversión de objetos de fechas y horas en cadenas
 * de caracteres.
 * <p>
 * La clase está compuesta por un conjunto de métodos estáticos que se encargan
 * de la conversión de objetos de la API de Java relacionados con fechas y horas
 * en cadenas de caracteres a partir de un patrón de formato específico, por
 * ejemplo: dd/MM/yyyy-HH:mm:ss. Para la realización de la conversión la clase
 * utiliza el patrón de formato de fecha y hora por defecto de la clase
 * {@link io.github.ldelpino.libs.dateutils.DatePatterns}. Para la conversión de
 * cadenas de caracteres en objetos de fechas y horas se utiliza la clase
 * {@link io.github.ldelpino.libs.dateutils.DateParsers}. La clase está
 * establecida como
 * <strong>final</strong> para no permitir crear clases que hereden de ella y el
 * constructor está establecido como <strong>private</strong> para no pemitir
 * nuevas instancias de la clase.</p>
 * <p>
 * En el modelo de conversión se hacen uso de los siguentes tipos de datos de
 * fechas y horas:
 * <ul>
 * <li>java.util.Date</li>
 * <li>java.util.Calendar</li>
 * <li>java.time.LocalDate</li>
 * <li>java.time.LocalTime</li>
 * <li>java.time.LocalDateTime</li>
 * </ul>
 * </p>
 *
 * @author Lázaro César del Pino Olivera
 * @since jdk-16.0.1
 * @version 1.0
 * @see io.github.ldelpino.libs.dateutils.DatePatterns
 * @see io.github.ldelpino.libs.dateutils.DateParsers
 */
public final class DateFormatters {

    /**
     * El constructor se establece como privado para no permitir instancias de
     * esta clase.
     */
    private DateFormatters() {

    }

    /**
     * Convierte un objeto de fecha y hora de tipo {@link java.util.Date} en una
     * cadena de caracteres a partir del patrón de formato establecido.
     * <p>
     * El patrón de formato de establecido se obtiene a través del método
     * {@link io.github.ldelpino.libs.dateutils.DatePatterns#getDateTimePattern()}
     * </p>
     *
     * @param date el objeto de fecha y hora a convertir en cadena.
     * @return la cadena de caracteres que convertida.
     */
    public static String format(Date date) {
        return format(date, DatePatterns.getDateTimePattern());
    }

    /**
     * Convierte un objeto de fecha y hora de tipo {@link java.util.Calendar} en
     * una cadena de caracteres a partir del patrón de formato establecido.
     * <p>
     * El patrón de formato de establecido se obtiene a través del método
     * {@link io.github.ldelpino.libs.dateutils.DatePatterns#getDateTimePattern()}
     * </p>
     *
     * @param calendar el objeto de fecha y hora a convertir en cadena.
     * @return la cadena de caracteres que convertida.
     */
    public static String format(Calendar calendar) {
        return format(calendar, DatePatterns.getDateTimePattern());
    }

    /**
     * Convierte un objeto de fecha de tipo {@link java.time.LocalDate} en una
     * cadena de caracteres a partir del patrón de formato establecido.
     * <p>
     * El patrón de formato de establecido se obtiene a través del método
     * {@link io.github.ldelpino.libs.dateutils.DatePatterns#getDatePattern() }
     * </p>
     *
     * @param localDate el objeto de fecha a convertir en cadena.
     * @return la cadena de caracteres que convertida.
     */
    public static String format(LocalDate localDate) {
        return format(localDate, DatePatterns.getDatePattern());
    }

    /**
     * Convierte un objeto de hora de tipo {@link java.time.LocalTime} en una
     * cadena de caracteres a partir del patrón de formato establecido.
     * <p>
     * El patrón de formato de establecido se obtiene a través del método
     * {@link io.github.ldelpino.libs.dateutils.DatePatterns#getTimePattern() }
     * </p>
     *
     * @param localTime el objeto de hora a convertir en cadena.
     * @return la cadena de caracteres que convertida.
     */
    public static String format(LocalTime localTime) {
        return format(localTime, DatePatterns.getTimePattern());
    }

    /**
     * Convierte un objeto de fecha y hora de tipo
     * {@link java.time.LocalDateTime} en una cadena de caracteres a partir del
     * patrón de formato establecido.
     * <p>
     * El patrón de formato de establecido se obtiene a través del método
     * {@link io.github.ldelpino.libs.dateutils.DatePatterns#getDateTimePattern()}
     * </p>
     *
     * @param localDateTime el objeto de fecha y hora a convertir en cadena.
     * @return la cadena de caracteres que convertida.
     */
    public static String format(LocalDateTime localDateTime) {
        return format(localDateTime, DatePatterns.getDateTimePattern());
    }

    /**
     * Convierte un objeto de fecha y hora de tipo {@link java.util.Date} en una
     * cadena de caracteres a partir de un patrón de formato especificado.
     *
     * @param date el objeto de fecha y hora a convertir en cadena.
     * @param dateTimePattern el patrón de formato de fecha y hora.
     * @return la cadena de caracteres que convertida.
     */
    public static String format(Date date, String dateTimePattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimePattern);
        return formatter.format(date.toInstant());
    }

    /**
     * Convierte un objeto de fecha y hora de tipo {@link java.util.Calendar} en
     * una cadena de caracteres a partir de un patrón de formato especificado.
     *
     * @param calendar el objeto de fecha y hora a convertir en cadena.
     * @param dateTimePattern el patrón de formato de fecha y hora.
     * @return la cadena de caracteres que convertida.
     */
    public static String format(Calendar calendar, String dateTimePattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimePattern);
        return formatter.format(calendar.toInstant());
    }

    /**
     * Convierte un objeto de fecha de tipo {@link java.time.LocalDate} en una
     * cadena de caracteres a partir de un patrón de formato especificado.
     *
     * @param localDate el objeto de fecha a convertir en cadena.
     * @param datePattern el patrón de formato de fecha.
     * @return la cadena de caracteres que convertida.
     */
    public static String format(LocalDate localDate, String datePattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
        return formatter.format(localDate);
    }

    /**
     * Convierte un objeto de hora de tipo {@link java.time.LocalTime} en una
     * cadena de caracteres a partir de un patrón de formato especificado.
     *
     * @param localTime el objeto de hora a convertir en cadena.
     * @param timePattern el patrón de formato de hora.
     * @return la cadena de caracteres que convertida.
     */
    public static String format(LocalTime localTime, String timePattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timePattern);
        return formatter.format(localTime);
    }

    /**
     * Convierte un objeto de fecha y hora de tipo
     * {@link java.time.LocalDateTime} en una cadena de caracteres a partir de
     * un patrón de formato especificado.
     *
     * @param localDateTime el objeto de fecha y hora a convertir en cadena.
     * @param dateTimePattern el patrón de formato de fecha y hora.
     * @return la cadena de caracteres que convertida.
     */
    public static String format(LocalDateTime localDateTime, String dateTimePattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimePattern);
        return formatter.format(localDateTime);
    }
}
