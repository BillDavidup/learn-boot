package com.daivid.learn.learnboot;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    }

    /**
     * 返回指定的连续自然月，包括本月，用于判断当前日期是否在这几个自然月内
     * @param numberOfMonth 指定生成几个连续的自然月
     * @param nowLocalDate localDate
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
}
