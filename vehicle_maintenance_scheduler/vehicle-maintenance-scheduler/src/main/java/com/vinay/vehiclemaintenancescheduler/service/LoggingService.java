package com.vinay.vehiclemaintenancescheduler.service;

import org.springframework.stereotype.Service;

@Service
public class LoggingService {

    public void log(
            String stack,
            String level,
            String packageName,
            String message) {

        System.out.println(
                stack + " | " +
                        level + " | " +
                        packageName + " | " +
                        message
        );
    }
}