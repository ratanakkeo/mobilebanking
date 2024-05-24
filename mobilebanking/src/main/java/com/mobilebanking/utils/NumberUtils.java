package com.mobilebanking.utils;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Component
public class NumberUtils {
    private static final String DECIMAL_FORMAT = "#.##";

    public String formatNumber(double number) {
        DecimalFormat formatter = new DecimalFormat(DECIMAL_FORMAT);
        return formatter.format(number);
    }

    public String formatCurrency(double amount, String currency) {
        DecimalFormat formatter = new DecimalFormat("###,###.##");
        return currency + " " + formatter.format(amount);
    }

    public double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }

    public double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public boolean isValidMonetaryValue(String amount) {
        try {
            new BigDecimal(amount);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}