package com.example.duckco.controller;

import com.example.duckco.model.Invoice;
import com.example.duckco.model.UserInvoice;
import com.example.duckco.service.InvoiceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
    private InvoiceService InvoiceService;

    public InvoiceController() {
        InvoiceService = new InvoiceService();
    }

    @GetMapping
    protected String showUserInvoice(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");

        UserInvoice userInvoices = InvoiceService.getInvoices(username);

        model.addAttribute("invoices", userInvoices.getInvoices());
        model.addAttribute("user", username);

        return "invoiceList";

    }

    @GetMapping("/new")
    public String registerPage(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        model.addAttribute("user", username);
        return "registerPage";
    }


    @PostMapping
    public String addInvoice(HttpSession session, @ModelAttribute Invoice invoice) {
        int userId = (int) session.getAttribute("userId");

        InvoiceService.addInvoice(userId, invoice);

        return "redirect:/invoice";
    }

    @GetMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable("id") int id){
        InvoiceService.deleteInvoice(id);
        return "redirect:/invoice";
    }

    @GetMapping("/editpage/{id}")
    public String editPage(@PathVariable("id") int id, Model model, HttpSession session){
        Invoice invoice = InvoiceService.getInvoice(id);
        model.addAttribute("invoice", invoice);
        model.addAttribute("user", session.getAttribute("username"));
        return "editPage";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Invoice invoice) {

        InvoiceService.updateInvoice(invoice);

        return "redirect:/invoice";
    }

}