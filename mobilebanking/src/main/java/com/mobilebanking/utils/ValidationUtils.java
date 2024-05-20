package com.mobilebanking.utils;

import org.springframework.stereotype.Component;

@Component
public class ValidationUtils {
    public boolean isValidAccountNumber(String accountNumber) {
        return accountNumber != null && accountNumber.matches("\\d{10,18}");
    }

    public boolean isValidCreditCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 13 || cardNumber.length() > 19) {
            return false;
        }
        int sum = 0;
        boolean alternate = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }

    public boolean isValidIBAN(String iban) {
        if (iban == null || iban.length() < 15 || iban.length() > 34) {
            return false;
        }
        String reformattedIban = iban.substring(4) + iban.substring(0, 4);
        int total = 0;
        for (char ch : reformattedIban.toCharArray()) {
            int value;
            if (Character.isDigit(ch)) {
                value = Character.getNumericValue(ch);
            } else if (Character.isLetter(ch)) {
                value = Character.getNumericValue(ch) + 9;
            } else {
                return false;
            }
            total = (total * 10 + value) % 97;
        }
        return total == 1;
    }
}
