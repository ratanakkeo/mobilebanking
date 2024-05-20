package com.mobilebanking.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/status/{code}")
    public ResponseEntity<String> getStatus(@PathVariable int code) {
        HttpStatus status = HttpStatus.resolve(code);
        if (status != null) {
            return new ResponseEntity<>("Status code: " + code, status);
        } else {
            return new ResponseEntity<>("Invalid status code: " + code, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/dynamicStatus")
    public ResponseEntity<String> getDynamicStatus(@RequestParam(value = "type", defaultValue = "success") String type) {
        return switch (type.toLowerCase()) {
            case "success" -> new ResponseEntity<>("Success", HttpStatus.OK);
            case "created" -> new ResponseEntity<>("Created", HttpStatus.CREATED);
            case "badrequest" -> new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
            case "unauthorized" -> new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
            case "forbidden" -> new ResponseEntity<>("Forbidden", HttpStatus.FORBIDDEN);
            case "notfound" -> new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
            default -> new ResponseEntity<>("Unknown type", HttpStatus.BAD_REQUEST);
        };
    }
}
