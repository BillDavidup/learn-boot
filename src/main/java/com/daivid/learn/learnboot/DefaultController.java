package com.daivid.learn.learnboot;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@RestController
@RequestMapping("/api")
public class DefaultController {
    @GetMapping("/monitor")
    public Object monitor() {
        return "alive";
    }

    public static void main(String[] args) {

        LocalDate nowLocalDate = LocalDate.now();

        getExpectedSizeOfSerialCalendarMonthSet(1, nowLocalDate);

        regexTest();
        regexTest2();
        regexTest3();

        Long seconds = getThisMonthDayBeginSecondsWithExpectedDayOfThisMonth(1);
        Long seconds2 = getThisMonthDayBeginSecondsWithExpectedDayOfThisMonth(16);
        Long seconds3 = getNextMonthFirstDayBeginSeconds();

        System.out.println("seconds:" + seconds);
        System.out.println("seconds2:" + seconds2);
        System.out.println("seconds3:" + seconds3);
        Calendar ca = Calendar.getInstance();
        Integer maxDaysOfMonth = ca.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.println("month of last day:" + ca.getActualMaximum(Calendar.DAY_OF_MONTH));

        testLongOfListContains();

    }

    /**
     * 返回指定的连续自然月，包括本月，用于判断当前日期是否在这几个自然月内
     *
     * @param numberOfMonth 指定生成几个连续的自然月
     * @param nowLocalDate  localDate
     */
    public static Set<String> getExpectedSizeOfSerialCalendarMonthSet(Integer numberOfMonth, LocalDate nowLocalDate) {
        if (Objects.isNull(numberOfMonth)) {
            return new HashSet<>(0);
        }
        if (numberOfMonth < 1) {
            return new HashSet<>(0);
        }
        HashSet<String> serialCalendarMonthSet = new HashSet<>();
        for (int i = 0; i < numberOfMonth; i++) {
            String date = nowLocalDate.getYear() + "" + nowLocalDate.getMonthValue();
            serialCalendarMonthSet.add(date);
            nowLocalDate = nowLocalDate.plusMonths(1);
        }
        return serialCalendarMonthSet;
    }

    public static void regexTest() {
        String regex = "K(\\d{1,2}T\\d{1,2}U\\d{1,2}Lesson\\d{1,2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("K1T1U1Lesson1");
        boolean matches = matcher.matches();
        System.out.println("is match:" + matches);
    }

    // (1|2|3|4|) 枚举选择
    public static void regexTest2() {
        String regex = "^A[1-9][0-9]?K[1-4]U[1-4]Lesson[1-9][0-9]?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("A99K1U1Lesson99");
        boolean matches = matcher.matches();
        System.out.println("is match:" + matches);
    }

    // 手机号 https://github.com/VincentSit/ChinaMobilePhoneNumberRegex
    public static void regexTest3() {
        String regex = "^(?:\\+?86)?[ ]?1(?:3\\d{3}|5[^4\\D]\\d{2}|8\\d{3}|7(?:[235-8]\\d{2}|4(?:0\\d|1[0-2]|9\\d))|9[0-35-9]\\d{2}|66\\d{2})\\d{6}$";
        // String regex = "^(?:\\+?86)?[ ]?1\\d{10}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("17801265844");
        boolean matches = matcher.matches();
        System.out.println("is match:" + matches);
    }

    public static Long getThisMonthDayBeginSecondsWithExpectedDayOfThisMonth(Integer expectedMonthOfDay) {
        LocalDateTime nowLocalDateTime = LocalDateTime.now();
        int thisYear = nowLocalDateTime.getYear();
        int thisMonthValue = nowLocalDateTime.getMonthValue();
        LocalDateTime expectedLocalDateTime = LocalDateTime.of(thisYear, thisMonthValue, expectedMonthOfDay, 0, 0, 0);
        return expectedLocalDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli() / 1000;
    }

    public static Long getNextMonthFirstDayBeginSeconds() {
        LocalDateTime now = LocalDateTime.now();
        int thisYear = now.getYear();
        int thisMonthValue = now.getMonthValue();
        // dayOfMonth参数没啥用，指定了1
        LocalDateTime tempLocalTime = LocalDateTime.of(thisYear, thisMonthValue, 1, 0, 0, 0);
        LocalDateTime lastDayLocalDateTime = tempLocalTime.with(TemporalAdjusters.lastDayOfMonth());
        LocalDateTime nextMonthFirstDayBeginLocalDateTime = lastDayLocalDateTime.plusDays(1);
        return nextMonthFirstDayBeginLocalDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli() / 1000;
    }

    public static void testLongOfListContains() {
        List<Long> userSubjectIdList = new ArrayList<>();
        Long l = new Long(1000);
        System.out.println("l:" + l);
        userSubjectIdList.add(l);
        Long l2 = new Long(1000);
        System.out.println("contains:" + userSubjectIdList.contains(l2));
    }

}
