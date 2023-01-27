package com.example.ducklings.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/journal/page/*")
public class PageController {

  ;

   /* @GetMapping("{date}")
    public String showDateContent(HttpSession session, @PathVariable String date){
        //Fetch journal user
        //Show page from specific date
    }*/
}
