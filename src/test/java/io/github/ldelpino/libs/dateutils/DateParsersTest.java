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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ldelpino
 */
public class DateParsersTest {

    private final Instant instant = Instant.EPOCH;

    @Test
    public void testParseToDate_String_String() {
        System.out.println("parseToDate");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DatePatterns.getDateTimePattern());
        String date = dateTimeFormatter.format(instant);
        String dateTimePattern = DatePatterns.getDateTimePattern();
        Date expResult = Date.from(instant);
        Date result = DateParsers.parseToDate(date, dateTimePattern);
        assertEquals(expResult, result);
    }

    @Test
    public void testParseToCalendar_String_String() {
        System.out.println("parseToCalendar");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DatePatterns.getDateTimePattern());
        String calendar = dateTimeFormatter.format(instant);
        String dateTimePattern = DatePatterns.getDateTimePattern();
        Calendar expResult = GregorianCalendar.from(instant.atZone(DateConverters.getTimeZone()));
        Calendar result = DateParsers.parseToCalendar(calendar, dateTimePattern);
        assertEquals(expResult, result);
    }

    @Test
    public void testParseToLocalDate_String_String() {
        System.out.println("parseToLocalDate");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DatePatterns.getDatePattern());
        String localDate = dateFormatter.format(instant);
        String datePattern = DatePatterns.getDatePattern();
        LocalDate expResult = LocalDate.from(instant);
        LocalDate result = DateParsers.parseToLocalDate(localDate, datePattern);
        assertEquals(expResult, result);
    }

    @Test
    public void testParseToLocalTime_String_String() {
        System.out.println("parseToLocalTime");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(DatePatterns.getTimePattern());
        String localTime = timeFormatter.format(instant);
        String timePattern = DatePatterns.getTimePattern();
        LocalTime expResult = LocalTime.from(instant);
        LocalTime result = DateParsers.parseToLocalTime(localTime, timePattern);
        assertEquals(expResult, result);
    }

    @Test
    public void testParseToLocalDateTime_String_String() {
        System.out.println("parseToLocalDateTime");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DatePatterns.getDateTimePattern());
        String localDateTime = dateTimeFormatter.format(instant);
        String dateTimePattern = DatePatterns.getDateTimePattern();
        LocalDateTime expResult = LocalDateTime.from(instant);
        LocalDateTime result = DateParsers.parseToLocalDateTime(localDateTime, dateTimePattern);
        assertEquals(expResult, result);
    }

}
