package com.mobilebanking.controllers;

import com.mobilebanking.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/sendEmail")
    public String sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String text) {
        emailService.sendSimpleMessage(to, subject, text);
        return "Email sent successfully!";
    }

    @GetMapping("/sendDynamicEmail")
    public String sendDynamicEmail(
            @RequestParam String host,
            @RequestParam int port,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String text) {
        emailService.sendDynamicEmail(host, port, username, password, to, subject, text);
        return "Dynamic email sent successfully!";
    }
}
