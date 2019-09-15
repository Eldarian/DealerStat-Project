package com.eldarian.dealerstat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("admin")
public class AdminController {
    @GetMapping
    public void getApproveRequests() {}

    @PostMapping
    public void postDecision() {}
}
