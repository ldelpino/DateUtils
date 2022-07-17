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
public class DateFormattersTest {

    private final Instant instant = Instant.EPOCH;

    @Test
    public void testFormat_Date_String() {
        System.out.println("formatDate");
        Date date = Date.from(instant);
        String pattern = DatePatterns.getDateTimePattern();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DatePatterns.getDateTimePattern());
        String expResult = dateTimeFormatter.format(instant);
        String result = DateFormatters.format(date, pattern);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormat_Calendar_String() {
        System.out.println("formatCalendar");
        Calendar calendar = GregorianCalendar.from(instant.atZone(DateConverters.getTimeZone()));
        String pattern = DatePatterns.getDateTimePattern();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DatePatterns.getDateTimePattern());
        String expResult = dateTimeFormatter.format(instant);
        String result = DateFormatters.format(calendar, pattern);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormat_LocalDate_String() {
        System.out.println("formatLocalDate");
        LocalDate localDate = LocalDate.from(instant);
        String pattern = DatePatterns.getDatePattern();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DatePatterns.getDatePattern());
        String expResult = dateTimeFormatter.format(instant);
        String result = DateFormatters.format(localDate, pattern);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormat_LocalTime_String() {
        System.out.println("formatLocalTime");
        LocalTime localTime = LocalTime.from(instant);
        String pattern = DatePatterns.getTimePattern();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DatePatterns.getTimePattern());
        String expResult = dateTimeFormatter.format(instant);
        String result = DateFormatters.format(localTime, pattern);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormat_LocalDateTime_String() {
        System.out.println("formatLocalDateTime");
        LocalDateTime localDateTime = LocalDateTime.from(instant);
        String pattern = DatePatterns.getDateTimePattern();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DatePatterns.getDateTimePattern());
        String expResult = dateTimeFormatter.format(instant);
        String result = DateFormatters.format(localDateTime, pattern);
        assertEquals(expResult, result);
    }
}
