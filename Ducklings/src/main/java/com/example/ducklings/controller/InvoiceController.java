package com.example.ducklings.controller;

import com.example.ducklings.service.InvoiceListService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class InvoiceController {
    private InvoiceListService invoiceListService;

    @GetMapping
    public String showContentPage() {
        return "journalForm.jsp";
    }

    @PostMapping
    public String addEntry(HttpSession session, @RequestParam String title, @RequestParam String content) {
        //fetch username
        //Create journalpage frome title and content
        //add page to profile journal in database
        //redirect to get mapping

        return title;
    }
}