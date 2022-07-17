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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ldelpino
 */
public class DateConvertersTest {

    private final Instant instant = Instant.EPOCH;
    
    @Test
    public void testConvertFromDateToCalendar() {
        System.out.println("convertFromDateToCalendar");
        Date date = Date.from(instant);
        Calendar expResult = GregorianCalendar.from(instant.atZone(DateConverters.getTimeZone()));
        Calendar result = DateConverters.convertFromDateToCalendar(date);
        assertEquals(expResult.getTimeInMillis(), result.getTimeInMillis());
    }

    @Test
    public void testConvertFromDateToLocalDate() {
        System.out.println("convertFromDateToLocalDate");
        Date date = Date.from(instant);
        LocalDate expResult = LocalDate.from(instant);
        LocalDate result = DateConverters.convertFromDateToLocalDate(date);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromDateToLocalTime() {
        System.out.println("convertFromDateToLocalTime");
        Date date = Date.from(instant);
        LocalTime expResult = LocalTime.from(instant);
        LocalTime result = DateConverters.convertFromDateToLocalTime(date);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromDateToLocalDateTime() {
        System.out.println("convertFromDateToLocalDateTime");
        Date date = Date.from(instant);
        LocalDateTime expResult = LocalDateTime.from(instant);
        LocalDateTime result = DateConverters.convertFromDateToLocalDateTime(date);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromDateToSQLDate() {
        System.out.println("convertFromDateToSQLDate");
        Date date = Date.from(instant);
        java.sql.Date expResult = new java.sql.Date(date.getTime());
        java.sql.Date result = DateConverters.convertFromDateToSQLDate(date);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromCalendarToLocalDate() {
        System.out.println("convertFromCalendarToLocalDate");
        Calendar calendar = GregorianCalendar.from(instant.atZone(DateConverters.getTimeZone()));
        LocalDate expResult = LocalDate.from(instant);
        LocalDate result = DateConverters.convertFromCalendarToLocalDate(calendar);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromCalendarToLocalTime() {
        System.out.println("convertFromCalendarToLocalTime");
        Calendar calendar = GregorianCalendar.from(instant.atZone(DateConverters.getTimeZone()));
        LocalTime expResult = LocalTime.from(instant);
        LocalTime result = DateConverters.convertFromCalendarToLocalTime(calendar);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromCalendarToLocalDateTime() {
        System.out.println("convertFromCalendarToLocalDateTime");
        Calendar calendar = GregorianCalendar.from(instant.atZone(DateConverters.getTimeZone()));
        LocalDateTime expResult = LocalDateTime.from(instant);
        LocalDateTime result = DateConverters.convertFromCalendarToLocalDateTime(calendar);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromLocalDateToDate() {
        System.out.println("convertFromLocalDateToDate");
        LocalDate localDate = LocalDate.from(instant);
        Date expResult = Date.from(instant);
        Date result = DateConverters.convertFromLocalDateToDate(localDate);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromLocalDateToCalendar() {
        System.out.println("convertFromLocalDateToCalendar");
        LocalDate localDate = LocalDate.from(instant);
        Calendar expResult = GregorianCalendar.from(instant.atZone(DateConverters.getTimeZone()));
        Calendar result = DateConverters.convertFromLocalDateToCalendar(localDate);
        assertEquals(expResult.getTimeInMillis(), result.getTimeInMillis());
    }

    @Test
    public void testConvertFromLocalDateToLocalDateTime() {
        System.out.println("convertFromLocalDateToLocalDateTime");
        LocalDate localDate = LocalDate.from(instant);
        LocalDateTime expResult = LocalDateTime.from(instant);
        LocalDateTime result = DateConverters.convertFromLocalDateToLocalDateTime(localDate);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromLocalTimeToDate() {
        System.out.println("convertFromLocalTimeToDate");
        LocalTime localTime = LocalTime.from(instant);
        Date result = Date.from(instant);
        Date expResult = DateConverters.convertFromLocalTimeToDate(localTime);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromLocalTimeToCalendar() {
        System.out.println("convertFromLocalTimeToCalendar");
        LocalTime localTime = LocalTime.from(instant);
        Calendar expResult = GregorianCalendar.from(instant.atZone(DateConverters.getTimeZone()));
        Calendar result = DateConverters.convertFromLocalTimeToCalendar(localTime);
        assertEquals(expResult.getTimeInMillis(), result.getTimeInMillis());
    }

    @Test
    public void testConvertFromLocalTimeToLocalDateTime() {
        System.out.println("convertFromLocalTimeToLocalDateTime");
        LocalTime localTime = LocalTime.from(instant);
        LocalDateTime expResult = LocalDateTime.from(instant);
        LocalDateTime result = DateConverters.convertFromLocalTimeToLocalDateTime(localTime);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromLocalDateTimeToDate() {
        System.out.println("convertFromLocalDateTimeToDate");
        LocalDateTime localDateTime = LocalDateTime.from(instant);
        Date expResult = Date.from(instant);
        Date result = DateConverters.convertFromLocalDateTimeToDate(localDateTime);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromLocalDateTimeToCalendar() {
        System.out.println("convertFromLocalDateTimeToCalendar");
        LocalDateTime localDateTime = LocalDateTime.from(instant);
        Calendar expResult = GregorianCalendar.from(instant.atZone(DateConverters.getTimeZone()));
        Calendar result = DateConverters.convertFromLocalDateTimeToCalendar(localDateTime);
        assertEquals(expResult.getTimeInMillis(), result.getTimeInMillis());
    }
}
