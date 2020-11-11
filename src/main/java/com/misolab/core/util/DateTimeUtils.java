package com.misolab.core.util;

import lombok.val;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public interface DateTimeUtils {

    default LocalDateTime getDateTime(String dt, String format) {
        val fmt = DateTimeFormatter.ofPattern(format);
        val ldt = LocalDateTime.from(fmt.parse(dt));
        return ldt;
    }

    default LocalDate getDate(String d, String format) {
        val fmt = DateTimeFormatter.ofPattern(format);
        val ld = LocalDate.from(fmt.parse(d));
        return ld;
    }

    default LocalTime getTime(String t, String format) {
        val fmt = DateTimeFormatter.ofPattern(format);
        val lt = LocalTime.from(fmt.parse(t));
        return lt;
    }

    default boolean after(String dt1, String dt2, String format) {
        val std = getDateTime(dt1, format);
        val other = getDateTime(dt2, format);
        return std.isAfter(other);
    }

    default boolean afterDate(String d1, String d2, String format) {
        val fmt = DateTimeFormatter.ofPattern(format);
        val std = getDate(d1, format);
        val other = getDate(d2, format);
        return std.isAfter(other);
    }

    default boolean afterTime(String t1, String t2, String format) {
        val fmt = DateTimeFormatter.ofPattern(format);
        val std = getTime(t1, format);
        val other = getTime(t2, format);
        return std.isAfter(other);
    }

}
