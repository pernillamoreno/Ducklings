package com.example.demo.controller;

import com.example.demo.model.InvoiceItem;
import com.example.demo.model.InvoiceList;

import com.example.demo.service.InvoiceListService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/invoiceList")
public class InvoiceListController {

    private InvoiceListService listService;

    public InvoiceListController() {
        listService = new InvoiceListService();
    }

    @GetMapping
    protected String showShoppingList(Model model, HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, IOException {
        //resp.setContentType("text/html"); hanteras responseBody
        String username = (String) session.getAttribute("username");
        //String password = (String) session.getAttribute("password");


        InvoiceList userInvoiceList = listService.getInvoiceList(username);


        model.addAttribute("items",userInvoiceList.getItemList());


        return "invoceListPage";
    }

    @PostMapping
    public String addItem(HttpSession session, @ModelAttribute InvoiceItem invoiceItem) {
        String username = (String) session.getAttribute("username");
       // String password = (String) session.getAttribute("password");

        listService.addInvoiceItem(username, invoiceItem);

        return "redirect:/invoiceList";
    }
}