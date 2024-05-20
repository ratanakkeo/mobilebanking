package com.mobilebanking.utils;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class StringUtils {
    public boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    public String toUpperCase(String str) {
        return str != null ? str.toUpperCase() : null;
    }

    public String toLowerCase(String str) {
        return str != null ? str.toLowerCase() : null;
    }

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

    public String trim(String str) {
        return str != null ? str.trim() : null;
    }

    public boolean isNumeric(String str) {
        return str != null && str.matches("\\d+");
    }

    public boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        String cleanStr = str.replaceAll("\\s+", "").toLowerCase();
        return cleanStr.equals(new StringBuilder(cleanStr).reverse().toString());
    }

    public String listToString(List<String> list, String delimiter) {
        return String.join(delimiter, list);
    }

    public List<String> stringToList(String str, String delimiter) {
        return Arrays.asList(str.split(Pattern.quote(delimiter)));
    }
}