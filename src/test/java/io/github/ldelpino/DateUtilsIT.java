/*
 * Copyright 2021 Lazaro Cesar del Pino Olivera <lazaro.delpino.olivera@gmail.com>.
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
package io.github.ldelpino;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase de Pruebas unitarias de la clase {@link io.github.ldelpino.DateUtils}.
 *
 * @author Lazaro Cesar del Pino Olivera
 * @since JDK 16.0.1
 * @version 1.0.2-SNAPSHOT
 */
public class DateUtilsIT {

    private final String datePattern = "dd/MM/yyyy-HH/mm/ss";
    private final String stringDateResult = "22/06/2021-10/22/20";

    public DateUtilsIT() {
    }

    /**
     * Test of getDateTimeFormatter method, of class DateUtils.
     */
    @Test
    public void testGetDateTimeFormatter() {
        System.out.println("getDateTimeFormatter");
        DateTimeFormatter expResult = DateTimeFormatter.ofPattern(datePattern);
        DateTimeFormatter result = DateUtils.getDateTimeFormatter();
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of getDateFormat method, of class DateUtils.
     */
    @Test
    public void testGetDateFormat() {
        System.out.println("getDateFormat");
        DateFormat expResult = new SimpleDateFormat(datePattern, DateUtils.getDateTimeFormatter().getLocale());
        DateFormat result = DateUtils.getDateFormat();
        assertEquals(expResult, result);
    }

    /**
     * Test of format method, of class DateUtils.
     */
    @Test
    public void testFormat_LocalDateTime_String() {
        System.out.println("format");
        LocalDateTime date = LocalDateTime.of(2021, 6, 22, 10, 22, 20);
        String result = DateUtils.format(date, datePattern);
        assertEquals(stringDateResult, result);
    }

    /**
     * Test of format method, of class DateUtils.
     */
    @Test
    public void testFormat_Date_String() {
        System.out.println("format");
        Date date = new Date(121, 5, 22, 10, 22, 20);
        String result = DateUtils.format(date, datePattern);
        assertEquals(stringDateResult, result);
    }

    /**
     * Test of format method, of class DateUtils.
     */
    @Test
    public void testFormat_Calendar_String() {
        System.out.println("format");
        Calendar date = GregorianCalendar.from(LocalDateTime.of(2021, 6, 22, 10, 22, 20).
                atZone(ZoneId.systemDefault()));
        String result = DateUtils.format(date, datePattern);
        assertEquals(stringDateResult, result);
    }

    /**
     * Test of format method, of class DateUtils.
     */
    @Test
    public void testFormat_LocalDateTime() {
        System.out.println("format");
        LocalDateTime date = LocalDateTime.of(2021, 6, 22, 10, 22, 20);
        String result = DateUtils.format(date);
        assertEquals(stringDateResult, result);
    }

    /**
     * Test of format method, of class DateUtils.
     */
    @Test
    public void testFormat_LocalDate() {
        System.out.println("format");
        LocalDate date = LocalDate.of(2021, 6, 22);
        String expResult = "22/06/2021";
        String result = DateUtils.format(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of format method, of class DateUtils.
     */
    @Test
    public void testFormat_LocalTime() {
        System.out.println("format");
        LocalTime localTime = LocalTime.of(10, 22, 20);
        String expResult = "10/22/20";
        String result = DateUtils.format(localTime);
        assertEquals(expResult, result);
    }

    /**
     * Test of format method, of class DateUtils.
     */
    @Test
    public void testFormat_Date() {
        System.out.println("format");
        Date date = new Date(121, 5, 22, 10, 22, 20);
        String result = DateUtils.format(date);
        assertEquals(stringDateResult, result);
    }

    /**
     * Test of format method, of class DateUtils.
     */
    @Test
    public void testFormat_Calendar() {
        System.out.println("format");
        Calendar date = GregorianCalendar.from(LocalDateTime.of(2021, 6, 22, 10, 22, 20).
                atZone(ZoneId.systemDefault()));
        String result = DateUtils.format(date);
        assertEquals(stringDateResult, result);
    }

    /**
     * Test of parseToLocalDateTime method, of class DateUtils.
     */
    @Test
    public void testParseToLocalDateTime_String_String() {
        System.out.println("parseToLocalDateTime");
        LocalDateTime expResult = LocalDateTime.of(2021, 6, 22, 10, 22, 20);
        LocalDateTime result = DateUtils.parseToLocalDateTime(stringDateResult, datePattern);
        assertEquals(expResult, result);
    }

    /**
     * Test of parseToLocalDateTime method, of class DateUtils.
     */
    @Test
    public void testParseToLocalDate_String_String() {
        System.out.println("parseToLocalDate");
        LocalDate expResult = LocalDate.of(2021, 6, 22);
        String dateResult = "22/06/2021";
        String dateFormat = "dd/MM/yyyy";
        LocalDate result = DateUtils.parseToLocalDate(dateResult, dateFormat);
        assertEquals(expResult, result);
    }

    /**
     * Test of parseToLocalDateTime method, of class DateUtils.
     */
    @Test
    public void testParseToLocalTime_String_String() {
        System.out.println("parseToLocalTime");
        LocalTime expResult = LocalTime.of(10, 22, 20);
        String dateResult = "10/22/20";
        String dateFormat = "HH/mm/ss";
        LocalTime result = DateUtils.parseToLocalTime(dateResult, dateFormat);
        assertEquals(expResult, result);
    }

    /**
     * Test of parseToDate method, of class DateUtils.
     */
    @Test
    public void testParseToDate_String_String() {
        System.out.println("parseToDate");
        Date expResult = new Date(121, 5, 22, 10, 22, 20);
        Date result = DateUtils.parseToDate(stringDateResult, datePattern);
        assertEquals(expResult, result);
    }

    /**
     * Test of parseToCalendar method, of class DateUtils.
     */
    @Test
    public void testParseToCalendar_String_String() {
        System.out.println("parseToCalendar");
        Calendar expResult = GregorianCalendar.from(LocalDateTime.of(2021, 6, 22, 10, 22, 20).
                atZone(ZoneId.systemDefault()));
        Calendar result = DateUtils.parseToCalendar(stringDateResult, datePattern);
        assertEquals(expResult, result);
    }

    /**
     * Test of parseToLocalDateTime method, of class DateUtils.
     */
    @Test
    public void testParseToLocalDateTime_String() {
        System.out.println("parseToLocalDateTime");
        LocalDateTime expResult = LocalDateTime.of(2021, 6, 22, 10, 22, 20);
        LocalDateTime result = DateUtils.parseToLocalDateTime(stringDateResult);
        assertEquals(expResult, result);
    }

    /**
     * Test of parseToLocalDateTime method, of class DateUtils.
     */
    @Test
    public void testParseToLocalDate_String() {
        System.out.println("parseToLocalDate");
        LocalDate expResult = LocalDate.of(2021, 6, 22);
        String dateResult = "22/06/2021";
        LocalDate result = DateUtils.parseToLocalDate(dateResult);
        assertEquals(expResult, result);
    }

    /**
     * Test of parseToLocalDateTime method, of class DateUtils.
     */
    @Test
    public void testParseToLocalTime_String() {
        System.out.println("parseToLocalTime");
        LocalTime expResult = LocalTime.of(10, 22, 20);
        String timeResult = "10/22/20";
        LocalTime result = DateUtils.parseToLocalTime(timeResult);
        assertEquals(expResult, result);
    }

    /**
     * Test of parseToDate method, of class DateUtils.
     */
    @Test
    public void testParseToDate_String() {
        System.out.println("parseToDate");
        Date expResult = new Date(121, 5, 22, 10, 22, 20);
        Date result = DateUtils.parseToDate(stringDateResult);
        assertEquals(expResult, result);
    }

    /**
     * Test of parseToCalendar method, of class DateUtils.
     */
    @Test
    public void testParseToCalendar_String() {
        System.out.println("parseToCalendar");
        Calendar expResult = GregorianCalendar.from(LocalDateTime.of(2021, 6, 22, 10, 22, 20).
                atZone(ZoneId.systemDefault()));
        Calendar result = DateUtils.parseToCalendar(stringDateResult);
        assertEquals(expResult, result);
    }

    /**
     * Test of validDate method, of class DateUtils.
     */
    @Test
    public void testValidDate_String_String() {
        System.out.println("validDate");
        boolean expResult = true;
        boolean result = DateUtils.validDate(stringDateResult, datePattern);
        assertEquals(expResult, result);
    }

    /**
     * Test of validDate method, of class DateUtils.
     */
    @Test
    public void testValidDate_String() {
        System.out.println("validDate");
        boolean expResult = true;
        boolean result = DateUtils.validDate(stringDateResult);
        assertEquals(expResult, result);
    }

    /**
     * Test of convertFromLocalDateTimeToCalendar method, of class DateUtils.
     */
    @Test
    public void testConvertFromLocalDateTimeToCalendar() {
        System.out.println("convertFromLocalDateTimeToCalendar");
        LocalDateTime localDateTime = LocalDateTime.of(2021, 6, 22, 10, 22, 20);
        Calendar expResult = GregorianCalendar.from(LocalDateTime.of(2021, 6, 22, 10, 22, 20).
                atZone(ZoneId.systemDefault()));
        Calendar result = DateUtils.convertFromLocalDateTimeToCalendar(localDateTime);
        assertEquals(expResult, result);
    }

    /**
     * Test of convertFromCalendarToLocalDate method, of class DateUtils.
     */
    @Test
    public void testConvertFromCalendarToLocalDate() {
        System.out.println("convertFromCalendarToLocalDate");
        Calendar calendar = GregorianCalendar.from(LocalDateTime.of(2021, 6, 22, 10, 22, 20).
                atZone(ZoneId.systemDefault()));
        LocalDateTime expResult = LocalDateTime.of(2021, 6, 22, 10, 22, 20);
        LocalDateTime result = DateUtils.convertFromCalendarToLocalDate(calendar);
        assertEquals(expResult, result);
    }

    /**
     * Test of convertFromLocalDateToDate method, of class DateUtils.
     */
    @Test
    public void testConvertFromLocalDateToDate() {
        System.out.println("convertFromLocalDateToDate");
        LocalDateTime localDateTime = LocalDateTime.of(2021, 6, 22, 10, 22, 20);
        Date expResult = new Date(121, 5, 22, 10, 22, 20);
        Date result = DateUtils.convertFromLocalDateToDate(localDateTime);
        assertEquals(expResult, result);
    }

    /**
     * Test of convertFromDateToLocalDate method, of class DateUtils.
     */
    @Test
    public void testConvertFromDateToLocalDate() {
        System.out.println("convertFromDateToLocalDate");
        Date date = new Date(121, 5, 22, 10, 22, 20);
        LocalDateTime expResult = LocalDateTime.of(2021, 6, 22, 10, 22, 20);
        LocalDateTime result = DateUtils.convertFromDateToLocalDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of convertFromDateToCalendar method, of class DateUtils.
     */
    @Test
    public void testConvertFromDateToCalendar() {
        System.out.println("convertFromDateToCalendar");
        Date date = new Date(121, 5, 22, 10, 22, 20);
        Calendar expResult = GregorianCalendar.from(LocalDateTime.of(2021, 6, 22, 10, 22, 20).
                atZone(ZoneId.systemDefault()));
        Calendar result = DateUtils.convertFromDateToCalendar(date);
        assertEquals(expResult, result);
    }
}
