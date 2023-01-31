package com.melita.ordertrackingapi.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Random;
import java.util.function.Supplier;

@Component
public class OrderNumberUtil implements Supplier<String> {
    @Override
    public String get() {
        Random rand = new SecureRandom();
        var builder = new StringBuilder("ORD-");
        var dash = "-";
        Calendar cal = Calendar.getInstance();
        return builder
                .append(cal.get(Calendar.YEAR))
                .append(dash)
                .append(cal.get(Calendar.MONTH))
                .append(dash)
                .append(cal.get(Calendar.DAY_OF_MONTH))
                .append(dash)
                .append(1000 + rand.nextInt(9000))
                .toString();
    }
}
