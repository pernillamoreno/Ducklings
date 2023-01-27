package com.example.ducklings.controller;

import com.example.ducklings.service.InvoiceListService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth/*")
public class AuthController {
    private InvoiceListService invoiceListService;

   /* @PostMapping("register")
    public String register(HttpSession session, @RequestParam String username, @RequestParam String password){
        //register user
        //register to login
    }
    @PostMapping("login")
    public String login(HttpSession session, @RequestParam String username, @RequestParam String password){
        //Sign in user if valid
        //redirect to journal if valid
        //redirect to homepage if valid
    }
    @PostMapping("logout")
    public String logout(HttpSession session,@RequestParam String username, @RequestParam String password){
        //invalid session
        //redirect to homepage*/
    }


