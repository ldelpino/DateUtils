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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ldelpino
 */
public class DatePatternsTest {

    public DatePatternsTest() {
    }

    @Test
    public void testSetDatePattern() {
        System.out.println("setDefaultDatePattern");
        String newDatePattern = DatePatterns.DEFAULT_DATE_PATTERN;
        try {
            DatePatterns.setDatePattern(newDatePattern);
            assertTrue(true);
        }
        catch (IllegalArgumentException ex) {
            assertTrue(false);
        }
    }

    @Test
    public void testSetDefaultTimePattern() {
        System.out.println("setDefaultTimePattern");
        String newTimePattern = DatePatterns.DEFAULT_TIME_PATTERN;
        try {
            DatePatterns.setTimePattern(newTimePattern);
            assertTrue(true);
        }
        catch (IllegalArgumentException ex) {
            assertTrue(false);
        }

    }

    @Test
    public void testSetDateTimePattern() {
        System.out.println("setDefaultDateTimePattern");
        String newDateTimePattern = DatePatterns.DEFAULT_DATE_TIME_PATTERN;
        try {
            DatePatterns.setDateTimePattern(newDateTimePattern);
            assertTrue(true);
        }
        catch (IllegalArgumentException ex) {
            assertTrue(false);
        }
    }
}
