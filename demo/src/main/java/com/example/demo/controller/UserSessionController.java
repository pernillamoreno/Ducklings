package com.example.demo.controller;

import com.example.demo.model.AuthDetails;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/userSession/*")
public class UserSessionController {

    @GetMapping("login")
    public String showLoginPage() {
        return "loginPage";
    }
    @PostMapping("login")
    public String login(HttpSession session, RedirectAttributes redirect, @ModelAttribute AuthDetails auth) {

        if (session.getAttribute("username") != null) {
            return "redirect:/invoiceList";
        } else {


            if (auth.getUsername() != null) {
                session.setMaxInactiveInterval(60 * 30);
                session.setAttribute("username", auth.getUsername());

                return "redirect:/invoiceList";
            } else {
                return "redirect:login";
            }
        }
    }
    @PostMapping("logout")
    public String logout(HttpSession session) throws IOException {
        session.invalidate();
        return "redirect:/index.html";
    }
}
