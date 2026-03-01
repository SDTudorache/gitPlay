package com.qa.framework.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BasketCalculator {

    public static double mangoTotal(int qty) {
        int payable = (qty / 2) + (qty % 2);
        return round(payable * 3.00);
    }

    public static double chickenTotal(int qty) {
        double total = 0;
        for (int i = 1; i <= qty; i++) {
            if (i % 3 == 0) {
                total += 12 * 0.75;
            } else {
                total += 12;
            }
        }
        return round(total);
    }

    public static double applyDelivery(double subtotal) {
        return subtotal >= 100 ? 0 : 5;
    }

    private static double round(double value) {
        return BigDecimal.valueOf(value)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
