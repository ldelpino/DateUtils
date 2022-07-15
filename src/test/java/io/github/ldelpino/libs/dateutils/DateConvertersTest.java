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

    @Test
    public void testConvertFromDateToCalendar() {
        System.out.println("convertFromDateToCalendar");
        Date date = new Date(122, 6, 15, 4, 40, 10);
        Calendar expResult = new GregorianCalendar(2022, 6, 15, 4, 40, 10);
        Calendar result = DateConverters.convertFromDateToCalendar(date);
        assertEquals(expResult.getTimeInMillis(), result.getTimeInMillis());
    }

    @Test
    public void testConvertFromDateToLocalDate() {
        System.out.println("convertFromDateToLocalDate");
        Date date = new Date(122, 6, 15, 4, 40, 10);
        LocalDate expResult = LocalDate.of(2022, 7, 15);
        LocalDate result = DateConverters.convertFromDateToLocalDate(date);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromDateToLocalTime() {
        System.out.println("convertFromDateToLocalTime");
        Date date = new Date(122, 6, 15, 4, 40, 10);
        LocalTime expResult = LocalTime.of(4, 40, 10);
        LocalTime result = DateConverters.convertFromDateToLocalTime(date);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromDateToLocalDateTime() {
        System.out.println("convertFromDateToLocalDateTime");
        Date date = new Date(122, 6, 15, 4, 40, 10);
        LocalDateTime expResult = LocalDateTime.of(2022, 7, 15, 4, 40, 10);
        LocalDateTime result = DateConverters.convertFromDateToLocalDateTime(date);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromDateToSQLDate() {
        System.out.println("convertFromDateToSQLDate");
        Date date = new Date(1000);
        java.sql.Date expResult = new java.sql.Date(1000);
        java.sql.Date result = DateConverters.convertFromDateToSQLDate(date);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromCalendarToLocalDate() {
        System.out.println("convertFromCalendarToLocalDate");
        Calendar calendar = new GregorianCalendar(2022, 6, 15, 4, 40, 10);
        LocalDate expResult = LocalDate.of(2022, 7, 15);
        LocalDate result = DateConverters.convertFromCalendarToLocalDate(calendar);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromCalendarToLocalTime() {
        System.out.println("convertFromCalendarToLocalTime");
        Calendar calendar = new GregorianCalendar(2022, 6, 15, 4, 40, 10);
        LocalTime expResult = LocalTime.of(4, 40, 10);
        LocalTime result = DateConverters.convertFromCalendarToLocalTime(calendar);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromCalendarToLocalDateTime() {
        System.out.println("convertFromCalendarToLocalDateTime");
        Calendar calendar = new GregorianCalendar(2022, 6, 15, 4, 40, 10);
        LocalDateTime expResult = LocalDateTime.of(2022, 7, 15, 4, 40, 10);
        LocalDateTime result = DateConverters.convertFromCalendarToLocalDateTime(calendar);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromLocalDateToDate() {
        System.out.println("convertFromLocalDateToDate");
        LocalDate localDate = LocalDate.of(2022, 7, 15);
        Date expResult = new Date(122, 6, 15, 0, 0, 0);
        Date result = DateConverters.convertFromLocalDateToDate(localDate);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromLocalDateToCalendar() {
        System.out.println("convertFromLocalDateToCalendar");
        LocalDate localDate = LocalDate.of(2022, 7, 15);
        Calendar expResult = new GregorianCalendar(2022, 6, 15, 0, 0, 0);
        Calendar result = DateConverters.convertFromLocalDateToCalendar(localDate);
        assertEquals(expResult.getTimeInMillis(), result.getTimeInMillis());
    }

    @Test
    public void testConvertFromLocalDateToLocalDateTime() {
        System.out.println("convertFromLocalDateToLocalDateTime");
        LocalDate localDate = LocalDate.of(2022, 7, 15);
        LocalDateTime expResult = LocalDateTime.of(2022, 7, 15, 0, 0, 0);
        LocalDateTime result = DateConverters.convertFromLocalDateToLocalDateTime(localDate);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromLocalTimeToDate() {
        System.out.println("convertFromLocalTimeToDate");
        LocalTime localTime = LocalTime.of(4, 40, 10);
        Date expResult = new Date(10000);
        Date result = DateConverters.convertFromLocalTimeToDate(localTime);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromLocalTimeToCalendar() {
        System.out.println("convertFromLocalTimeToCalendar");
        LocalTime localTime = LocalTime.of(4, 40, 10);
        Calendar expResult = new GregorianCalendar(LocalDate.EPOCH.getYear(), LocalDate.EPOCH.getMonth().getValue() - 1, 
                LocalDate.EPOCH.getDayOfMonth(), 4, 40, 10);
        Calendar result = DateConverters.convertFromLocalTimeToCalendar(localTime);
        assertEquals(expResult.getTimeInMillis(), result.getTimeInMillis());
    }

    @Test
    public void testConvertFromLocalTimeToLocalDateTime() {
        System.out.println("convertFromLocalTimeToLocalDateTime");
        LocalTime localTime = LocalTime.of(4, 40, 10);
        LocalDateTime expResult = LocalDateTime.of(LocalDate.MIN, LocalTime.of(4, 40, 10));
        LocalDateTime result = DateConverters.convertFromLocalTimeToLocalDateTime(localTime);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromLocalDateTimeToDate() {
        System.out.println("convertFromLocalDateTimeToDate");
        LocalDateTime localDateTime = LocalDateTime.of(2022, 7, 15, 4, 40, 10);
        Date expResult = new Date(122, 6, 15, 4, 40, 10);
        Date result = DateConverters.convertFromLocalDateTimeToDate(localDateTime);
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertFromLocalDateTimeToCalendar() {
        System.out.println("convertFromLocalDateTimeToCalendar");
        LocalDateTime localDateTime = LocalDateTime.of(2022, 7, 15, 4, 40, 10);
        Calendar expResult = new GregorianCalendar(2022, 6, 15, 4, 40, 10);
        Calendar result = DateConverters.convertFromLocalDateTimeToCalendar(localDateTime);
        assertEquals(expResult.getTimeInMillis(), result.getTimeInMillis());
    }
}
