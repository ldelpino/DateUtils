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

import java.time.format.DateTimeFormatter;

/**
 * La clase almacena las constantes y valores por defecto de los patrones de
 * formato de fechas y horas.
 * <p>
 * La clase DatePatterns se encarga de almacenar los valores por defecto de los
 * patrones de fecha, hora y fecha y hora, estos patrones son utilizados para la
 * conversion de objetos en cadenas de caracteres y viceversa, métodos que se
 * encuentran en las clases
 * {@link io.github.ldelpino.libs.dateutils.DateFormatters} y
 * {@link io.github.ldelpino.libs.dateutils.DateParsers}. La clase contiene
 * además las constantes predeterminadas de los valores de los patrones de
 * formato en caso de no establecerse uno o para utilizarlos por defecto
 * siempre.</p>
 *
 * @author Lázaro César del Pino Olivera
 * @since jdk-16.0.1
 * @version 2.0
 * @see io.github.ldelpino.libs.dateutils.DateFormatters
 * @see io.github.ldelpino.libs.dateutils.DateParsers
 */
public final class DatePatterns {

    /**
     * El patrón por defecto para la conversión de solo fechas en cadenas de
     * caracteres.
     */
    public static final String DEFAULT_DATE_PATTERN = "dd/MM/yyyy";

    /**
     * El patrón por defecto para la conversión de solo horas en cadenas de
     * caracteres.
     */
    public static final String DEFAULT_TIME_PATTERN = "HH/mm/ss";

    /**
     * El patrón por defecto para la conversión de fechas y horas en cadenas de
     * caracteres.
     */
    public static final String DEFAULT_DATE_TIME_PATTERN = "dd/MM/yyyy-HH/mm/ss";

    /**
     * Patrón de conversión de fechas.
     */
    private static String date_pattern = DEFAULT_DATE_PATTERN;

    /**
     * Patrón de conversión de horas.
     */
    private static String time_pattern = DEFAULT_TIME_PATTERN;

    /**
     * Patrón de conversión de fechas y horas.
     */
    private static String date_time_pattern = DEFAULT_DATE_TIME_PATTERN;

    /**
     * El constructor se establece como privado para no permitir instancias de
     * esta clase.
     */
    private DatePatterns() {

    }

    /**
     * Establece el nuevo patrón de fecha por defecto.
     *
     * @param newDatePattern el nuevo patrón a establecer.
     * @throws IllegalArgumentException si el patrón de fecha no es válido.
     */
    public static void setDatePattern(String newDatePattern) throws IllegalArgumentException {
        DateTimeFormatter.ofPattern(newDatePattern);
        date_pattern = newDatePattern;
    }

    /**
     * Devuelve el patrón de fecha establecido por defecto.
     *
     * @return el patrón de fecha establecido por defecto.
     */
    public static String getDatePattern() {
        return date_pattern;
    }

    /**
     * Establece el nuevo patrón de horas por defecto.
     *
     * @param newTimePattern el nuevo patrón a establecer.
     * @throws IllegalArgumentException si el patrón de hora no es válido.
     */
    public static void setTimePattern(String newTimePattern) throws IllegalArgumentException {
        DateTimeFormatter.ofPattern(newTimePattern);
        time_pattern = newTimePattern;
    }

    /**
     * Devuelve el patrón de hora establecido por defecto.
     *
     * @return el patrón de hora establecido por defecto.
     */
    public static String getTimePattern() {
        return time_pattern;
    }

    /**
     * Establece el nuevo patrón de horas por defecto.
     *
     * @param newDateTimePattern el nuevo patrón a establecer.
     * @throws IllegalArgumentException si el patrón de fecha-hora no es válido.
     */
    public static void setDateTimePattern(String newDateTimePattern) throws IllegalArgumentException {
        DateTimeFormatter.ofPattern(newDateTimePattern);
        date_time_pattern = newDateTimePattern;
    }

    /**
     * Devuelve el patrón de fecha y hora establecido por defecto.
     *
     * @return el patrón de fecha y hora establecido por defecto.
     */
    public static String getDateTimePattern() {
        return date_time_pattern;
    }
}
