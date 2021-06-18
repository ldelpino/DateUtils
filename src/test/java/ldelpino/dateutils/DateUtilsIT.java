/*
 * Copyright (C) 2021 EL ROJO
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ldelpino.dateutils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Clase de pruebas unitarias para la clase {@link ldelpino.date.util.DateUtils}
 * <p>
 * La clase de pruebas incluye todas las pruebas de los metodos estaticos
 * pertenecientes a la clase {@link ldelpino.date.util.DateUtils}.</p>
 *
 * @author Lazaro Cesar del Pino Olivera
 * @since jdk 1.8
 * @version 1.0
 * @see ldelpino.date.util.DateUtils
 */
public class DateUtilsIT {

    /**
     * Prueba del metodo
     * {@link ldelpino.date.util.DateUtils#format(java.time.LocalDate)} de la
     * clase {@link ldelpino.date.util.DateUtils}
     */
    @Test
    public void testFormat_LocalDate() {
        System.out.println("format");
        LocalDate date = LocalDate.of(2021, 6, 12);
        String expResult = "12/06/2021";
        String result = DateUtils.format(date);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo
     * {@link ldelpino.date.util.DateUtils#format(java.util.Calendar)} de la
     * clase {@link ldelpino.date.util.DateUtils}
     */
    @Test
    public void testFormat_Calendar() {
        System.out.println("format");
        Calendar calendar = DateUtils.convertFromLocalDateToCalendar(LocalDate.of(2021, 6, 12));
        String expResult = "12/06/2021";
        String result = DateUtils.format(calendar);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo
     * {@link ldelpino.date.util.DateUtils#format(java.time.LocalDate)} de la
     * clase {@link ldelpino.date.util.DateUtils}
     */
    @Test
    public void testFormat_LocalDate_String() {
        System.out.println("format");
        LocalDate date = LocalDate.of(2021, 6, 12);
        String datePattern = DateUtils.DEFAULT_DATE_PATTERN;
        String expResult = "12/06/2021";
        String result = DateUtils.format(date, datePattern);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo
     * {@link ldelpino.date.util.DateUtils#format(java.util.Calendar)} de la
     * clase {@link ldelpino.date.util.DateUtils}
     */
    @Test
    public void testFormat_Calendar_String() {
        System.out.println("format");
        Calendar calendar = DateUtils.convertFromLocalDateToCalendar(LocalDate.of(2021, 6, 12));
        String datePattern = DateUtils.DEFAULT_DATE_PATTERN;
        String expResult = "12/06/2021";
        String result = DateUtils.format(calendar, datePattern);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo
     * {@link ldelpino.date.util.DateUtils#parse(java.lang.String)} de la clase
     * {@link ldelpino.date.util.DateUtils}
     */
    @Test
    public void testParse_String() {
        System.out.println("parse");
        String dateString = "12/06/2021";
        LocalDate expResult = LocalDate.of(2021, 6, 12);
        LocalDate result = DateUtils.parse(dateString);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo
     * {@link ldelpino.date.util.DateUtils#parse(java.lang.String, java.lang.String)}
     * de la clase {@link ldelpino.date.util.DateUtils}
     */
    @Test
    public void testParse_String_String() {
        System.out.println("parse");
        String dateString = "12/06/2021";
        String datePattern = DateUtils.DEFAULT_DATE_PATTERN;
        LocalDate expResult = LocalDate.of(2021, 6, 12);
        LocalDate result = DateUtils.parse(dateString, datePattern);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo
     * {@link ldelpino.date.util.DateUtils#validDate(java.lang.String, java.lang.String)}
     * de la clase {@link ldelpino.date.util.DateUtils}
     */
    @Test
    public void testValidDate_String_String() {
        System.out.println("validDate");
        String dateString = "12/06/2021";
        String datePattern = DateUtils.DEFAULT_DATE_PATTERN;
        boolean expResult = true;
        boolean result = DateUtils.validDate(dateString, datePattern);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo
     * {@link ldelpino.date.util.DateUtils#validDate(java.lang.String)} de la
     * clase {@link ldelpino.date.util.DateUtils}
     */
    @Test
    public void testValidDate_String() {
        System.out.println("validDate");
        String dateString = "12/06/2021";
        boolean expResult = true;
        boolean result = DateUtils.validDate(dateString);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo
     * {@link ldelpino.date.util.DateUtils#convertFromLocalDateToDate(java.time.LocalDate)}
     * de la clase {@link ldelpino.date.util.DateUtils}
     */
    @Test
    public void testConvertFromLocalDateToDate() {
        System.out.println("convertFromLocalDateToDate");
        LocalDate localDate = LocalDate.of(2021, 6, 12);
        Date expResult = new Date(121, 5, 12);
        Date result = DateUtils.convertFromLocalDateToDate(localDate);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo
     * {@link ldelpino.date.util.DateUtils#convertFromDateToLocalDate(java.util.Date)}
     * de la clase {@link ldelpino.date.util.DateUtils}
     */
    @Test
    public void testConvertFromDateToLocalDate() {
        System.out.println("convertFromDateToLocalDate");
        Date date = new Date(121, 5, 12);
        LocalDate expResult = LocalDate.of(2021, 6, 12);
        LocalDate result = DateUtils.convertFromDateToLocalDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo
     * {@link ldelpino.date.util.DateUtils#convertFromLocalDateToCalndar(java.time.LocalDate)}
     * de la clase {@link ldelpino.date.util.DateUtils}
     */
    @Test
    public void testConvertFromLocalDateToCalendar() {
        System.out.println("convertFromLocalDateToCalendar");
        LocalDate localDate = LocalDate.of(2021, 6, 12);
        Calendar expResult = GregorianCalendar.from(LocalDate.of(2021, 6, 12).atStartOfDay(ZoneId.systemDefault()));
        Calendar result = DateUtils.convertFromLocalDateToCalendar(localDate);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo
     * {@link ldelpino.date.util.DateUtils#convertFromCalndarToLocalDate(java.util.Calendar)}
     * de la clase {@link ldelpino.date.util.DateUtils}
     */
    @Test
    public void testConvertFromCalendarToLocalDate() {
        System.out.println("convertFromCalendarToLocalDate");
        Calendar calendar = new GregorianCalendar(2021, 5, 12);
        LocalDate expResult = LocalDate.of(2021, 6, 12);
        LocalDate result = DateUtils.convertFromCalendarToLocalDate(calendar);
        assertEquals(expResult, result);
    }

}
