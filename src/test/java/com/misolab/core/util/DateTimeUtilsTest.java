package com.misolab.core.util;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DateTimeUtilsTest {

    static class TestMock implements DateTimeUtils {
    }

    @Test
    void testBefore() {
        val dtu = new TestMock();
        val dt1 = "2020-11-12 00:00:00";
        val dt2 = "2020-11-11 23:59:59";
        assertTrue(dtu.after(dt1, dt2, "yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    void testTime() {
        val dtu = new TestMock();
        val t1 = "00:00:01";
        val t2 = "00:00:00";
        assertTrue(dtu.afterTime(t1, t2, "HH:mm:ss"));
    }

    @Test
    void testDate() {
        val dtu = new TestMock();
        val d1 = "2020-11-12";
        val d2 = "2020-11-11";
        assertTrue(dtu.afterDate(d1, d2, "yyyy-MM-dd"));
    }
}
