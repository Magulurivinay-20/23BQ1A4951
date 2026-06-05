package com.vinay.vehiclemaintenancescheduler.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchedulerController {

    @GetMapping("/")
    public String test() {
        return "Vehicle Maintenance Scheduler Running";
    }

    @GetMapping("/schedule")
    public String schedule() {
        return "Schedule Generated Successfully";
    }
}