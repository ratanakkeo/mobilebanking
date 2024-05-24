package com.mobilebanking.config;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class ResponseInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws IOException {
        int status = response.getStatus();
        // Call the response API
        callResponseApi(status);
    }

    private void callResponseApi(int status) throws IOException {
        // Here you can call your response API
        // For demonstration purposes, we're using Java's HttpURLConnection
        java.net.URL url = new java.net.URL("http://localhost:8080/responseApi?status=" + status);
        java.net.HttpURLConnection con = (java.net.HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.getResponseCode(); // Make the call
        con.disconnect();
    }
}
