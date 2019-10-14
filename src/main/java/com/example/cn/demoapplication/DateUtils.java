package com.example.cn.demoapplication;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 测试使用Java8的日期类
 */
public class DateUtils {

    private static LocalDateTime localDateTime;

    private DateUtils () {}

    public static String format(LocalDateTime local) {
        if (local == null) {
            throw new NullPointerException();
        }
        localDateTime = local;
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static String format(LocalDateTime localTime, String pattern) {
        if (localTime == null || StringUtils.isBlank(pattern)) {
            throw new NullPointerException();
        }
        localDateTime = localTime;
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime parse(String text) {
        return LocalDateTime.parse(text, DateTimeFormatter.BASIC_ISO_DATE);
    }

    public static LocalDateTime parse(String text, String pattern) {
        return LocalDateTime.parse(text, DateTimeFormatter.ofPattern(pattern));
    }
}
