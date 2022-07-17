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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ldelpino
 */
public class DateParsersTest {

    public DateParsersTest() {
    }

    @Test
    public void testParseToDate_String_String() {
        System.out.println("parseToDate");
        String date = "";
        String dateTimePattern = "";
        Date expResult = null;
        Date result = DateParsers.parseToDate(date, dateTimePattern);
        assertEquals(expResult, result);
    }

    @Test
    public void testParseToCalendar_String_String() {
        System.out.println("parseToCalendar");
        String calendar = "";
        String dateTimePattern = "";
        Calendar expResult = null;
        Calendar result = DateParsers.parseToCalendar(calendar, dateTimePattern);
        assertEquals(expResult, result);
    }

    @Test
    public void testParseToLocalDate_String_String() {
        System.out.println("parseToLocalDate");
        String localDate = "";
        String datePattern = "";
        LocalDate expResult = null;
        LocalDate result = DateParsers.parseToLocalDate(localDate, datePattern);
        assertEquals(expResult, result);
    }

    @Test
    public void testParseToLocalTime_String_String() {
        System.out.println("parseToLocalTime");
        String localTime = "";
        String timePattern = "";
        LocalTime expResult = null;
        LocalTime result = DateParsers.parseToLocalTime(localTime, timePattern);
        assertEquals(expResult, result);
    }

    @Test
    public void testParseToLocalDateTime_String_String() {
        System.out.println("parseToLocalDateTime");
        String localDateTime = "";
        String dateTimePattern = "";
        LocalDateTime expResult = null;
        LocalDateTime result = DateParsers.parseToLocalDateTime(localDateTime, dateTimePattern);
        assertEquals(expResult, result);
    }

}
