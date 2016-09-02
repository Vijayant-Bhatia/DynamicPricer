package com.prizy.dynamic.pricer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author a579157
 *
 */
@RestController
public class HomeController {
    
    @Value("${home.controller.welcomeMessage}")
    private String welcomeMessage;

    @RequestMapping("/")
    @Transactional(readOnly = true)
    public String home() {
        return welcomeMessage;
    }
}