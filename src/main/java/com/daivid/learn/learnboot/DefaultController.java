package com.daivid.learn.learnboot;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashSet;
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

}
