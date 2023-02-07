package com.example.duckco.controller;

import com.example.duckco.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping("/auth/*")
public class AuthController {
    private UserService userService;

    public AuthController() {
        userService = new UserService();
    }


    @GetMapping("login")
    public String getLoginPage() {
        return "loginPage";
    }

    @PostMapping("login")
    public String login(HttpSession session, @RequestParam String username, @RequestParam String password) {

        var user = userService.getUser(username, password);

        if (user != null){
            session.setMaxInactiveInterval(60 * 30);
            session.setAttribute("username", user.getUsername());
            session.setAttribute("userId", user.getId());
            return "redirect:/invoice";
        } else {
            return "redirect:login";
        }

    }

    @GetMapping("logout")
    public String logout(HttpSession session) throws IOException {
        session.invalidate();
        return "redirect:/auth/login";
    }


}

