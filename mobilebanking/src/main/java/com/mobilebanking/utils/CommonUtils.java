package com.mobilebanking.utils;

import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.Base64;

@Component
public class CommonUtils {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd";
    private static final String DECIMAL_FORMAT = "#.##";

    /**
     * Formats a date to a string with the default format.
     *
     * @param date the date to format
     * @return the formatted date string
     */
    public String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(date);
    }

    /**
     * Parses a date string to a Date object with the default format.
     *
     * @param dateString the date string to parse
     * @return the parsed Date object
     * @throws ParseException if the date string is invalid
     */
    public Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.parse(dateString);
    }

    /**
     * Formats a date to a string with a simple date format (yyyy-MM-dd).
     *
     * @param date the date to format
     * @return the formatted date string
     */
    public String formatSimpleDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
        return formatter.format(date);
    }

    /**
     * Checks if a string is null or empty.
     *
     * @param str the string to check
     * @return true if the string is null or empty, false otherwise
     */
    public boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * Validates an email address.
     *
     * @param email the email to validate
     * @return true if the email is valid, false otherwise
     */
    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    /**
     * Converts a string to uppercase.
     *
     * @param str the string to convert
     * @return the uppercase string
     */
    public String toUpperCase(String str) {
        return str != null ? str.toUpperCase() : null;
    }

    /**
     * Converts a string to lowercase.
     *
     * @param str the string to convert
     * @return the lowercase string
     */
    public String toLowerCase(String str) {
        return str != null ? str.toLowerCase() : null;
    }

    /**
     * Formats a number to a string with two decimal places.
     *
     * @param number the number to format
     * @return the formatted number string
     */
    public String formatNumber(double number) {
        DecimalFormat formatter = new DecimalFormat(DECIMAL_FORMAT);
        return formatter.format(number);
    }

    /**
     * Joins an array of strings with a delimiter.
     *
     * @param delimiter the delimiter to use
     * @param elements  the elements to join
     * @return the joined string
     */
    public String join(String delimiter, String... elements) {
        if (elements == null || elements.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String element : elements) {
            sb.append(element).append(delimiter);
        }
        sb.setLength(sb.length() - delimiter.length());
        return sb.toString();
    }

    /**
     * Checks if a string contains only digits.
     *
     * @param str the string to check
     * @return true if the string contains only digits, false otherwise
     */
    public boolean isNumeric(String str) {
        return str != null && str.matches("\\d+");
    }

    /**
     * Trims leading and trailing whitespace from a string.
     *
     * @param str the string to trim
     * @return the trimmed string
     */
    public String trim(String str) {
        return str != null ? str.trim() : null;
    }

    /**
     * Generates a random alphanumeric string of specified length.
     *
     * @param length the length of the string to generate
     * @return the generated string
     */
    public String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = (int) (characters.length() * Math.random());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    /**
     * Generates a random UUID.
     *
     * @return the generated UUID string
     */
    public String generateUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * Encodes a string to Base64.
     *
     * @param str the string to encode
     * @return the encoded Base64 string
     */
    public String encodeBase64(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    /**
     * Decodes a Base64 string.
     *
     * @param base64Str the Base64 string to decode
     * @return the decoded string
     */
    public String decodeBase64(String base64Str) {
        return new String(Base64.getDecoder().decode(base64Str));
    }

    /**
     * Checks if a string is a palindrome.
     *
     * @param str the string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        String cleanStr = str.replaceAll("\\s+", "").toLowerCase();
        return cleanStr.equals(new StringBuilder(cleanStr).reverse().toString());
    }

    /**
     * Reads a file to a string.
     *
     * @param filePath the file path
     * @return the file content as a string
     * @throws IOException if an I/O error occurs
     */
    public String readFileToString(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
            return sb.toString();
        }
    }

    /**
     * Writes a string to a file.
     *
     * @param filePath the file path
     * @param content  the content to write
     * @throws IOException if an I/O error occurs
     */
    public void writeStringToFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }

    /**
     * Sorts a list of strings.
     *
     * @param list the list to sort
     * @return the sorted list
     */
    public List<String> sortList(List<String> list) {
        if (list != null) {
            Collections.sort(list);
        }
        return list;
    }

    /**
     * Converts a list of strings to a single string with a delimiter.
     *
     * @param list      the list to convert
     * @param delimiter the delimiter
     * @return the joined string
     */
    public String listToString(List<String> list, String delimiter) {
        return String.join(delimiter, list);
    }

    /**
     * Converts a delimited string to a list of strings.
     *
     * @param str       the string to convert
     * @param delimiter the delimiter
     * @return the list of strings
     */
    public List<String> stringToList(String str, String delimiter) {
        return Arrays.asList(str.split(Pattern.quote(delimiter)));
    }

    /**
     * Calculates simple interest.
     *
     * @param principal the principal amount
     * @param rate      the annual interest rate (in percentage)
     * @param time      the time the money is invested for (in years)
     * @return the calculated simple interest
     */
    public double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    /**
     * Validates a bank account number.
     *
     * @param accountNumber the account number to validate
     * @return true if the account number is valid, false otherwise
     */
    public boolean isValidAccountNumber(String accountNumber) {
        // This is a simple validation, a real-world scenario might involve checksum validation.
        return accountNumber != null && accountNumber.matches("\\d{10,18}");
    }

    /**
     * Formats a number to a currency string.
     *
     * @param amount   the amount to format
     * @param currency the currency symbol
     * @return the formatted currency string
     */
    public String formatCurrency(double amount, String currency) {
        DecimalFormat formatter = new DecimalFormat("###,###.##");
        return currency + " " + formatter.format(amount);
    }

    /**
     * Converts an amount from one currency to another.
     *
     * @param amount        the amount to convert
     * @param exchangeRate  the exchange rate from the source currency to the target currency
     * @return the converted amount
     */
    public double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }

    /**
     * Validates a credit card number using Luhn's algorithm.
     *
     * @param cardNumber the credit card number to validate
     * @return true if the card number is valid, false otherwise
     */
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

    /**
     * Generates a random bank account number.
     *
     * @return the generated account number
     */
    public String generateRandomAccountNumber() {
        Random rand = new Random();
        StringBuilder accountNumber = new StringBuilder(18);
        for (int i = 0; i < 18; i++) {
            accountNumber.append(rand.nextInt(10));
        }
        return accountNumber.toString();
    }

    /**
     * Validates an IBAN number.
     *
     * @param iban the IBAN to validate
     * @return true if the IBAN is valid, false otherwise
     */
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

    /**
     * Generates a random credit card number.
     *
     * @return the generated credit card number
     */
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

    /**
     * Calculates the Luhn check digit for a card number.
     *
     * @param number the card number without the check digit
     * @return the calculated check digit
     */
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

    /**
     * Checks if a given string is a valid monetary value.
     *
     * @param amount the string to check
     * @return true if the string is a valid monetary value, false otherwise
     */
    public boolean isValidMonetaryValue(String amount) {
        try {
            new BigDecimal(amount);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
