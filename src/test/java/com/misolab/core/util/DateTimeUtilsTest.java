package com.misolab.core.util;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DateTimeUtilsTest {


    @Test
    void testBefore() {
        val dt1 = "2020-11-12 00:00:00";
        val dt2 = "2020-11-11 23:59:59";
        assertTrue(DateTimeUtils.after(dt1, dt2, "yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    void testNow() {
        val dt = "2020-11-12 00:00:00";
        assertTrue(DateTimeUtils.after(dt, "yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    void testTime() {
        val t1 = "00:00:01";
        val t2 = "00:00:00";
        assertTrue(DateTimeUtils.afterTime(t1, t2, "HH:mm:ss"));
    }

    @Test
    void testDate() {
        val d1 = "2020-11-12";
        val d2 = "2020-11-11";
        assertTrue(DateTimeUtils.afterDate(d1, d2, "yyyy-MM-dd"));
    }
}
