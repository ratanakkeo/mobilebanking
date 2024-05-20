package com.mobilebanking.utils;

import org.springframework.stereotype.Component;
import java.util.Random;
import java.util.UUID;

@Component
public class RandomUtils {
    public String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    public String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public String generateRandomAccountNumber() {
        Random rand = new Random();
        StringBuilder accountNumber = new StringBuilder(18);
        for (int i = 0; i < 18; i++) {
            accountNumber.append(rand.nextInt(10));
        }
        return accountNumber.toString();
    }

    public String generateRandomCreditCardNumber() {
        String bin = "4539"; // Example BIN for Visa cards
        StringBuilder number = new StringBuilder(bin);
        Random rand = new Random();
        for (int i = 0; i < 12; i++) {
            number.append(rand.nextInt(10));
        }
        number.append(calculateLuhnCheckDigit(number.toString()));
        return number.toString();
    }

    private int calculateLuhnCheckDigit(String number) {
        int sum = 0;
        boolean alternate = true;
        for (int i = number.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(number.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (10 - (sum % 10)) % 10;
    }
}