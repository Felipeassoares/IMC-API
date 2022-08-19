package com.capgemini.Imc_Api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/api")
    public String welcome() {
        return "A média do imc nesse momento é: 23.66";
    }
}
