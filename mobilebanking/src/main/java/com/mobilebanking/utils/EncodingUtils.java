package com.mobilebanking.utils;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class EncodingUtils {
    public String encodeBase64(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    public String decodeBase64(String base64Str) {
        return new String(Base64.getDecoder().decode(base64Str));
    }
}