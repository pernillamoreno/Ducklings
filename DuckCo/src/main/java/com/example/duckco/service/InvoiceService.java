package com.example.duckco.service;

import com.example.duckco.model.Invoice;
import com.example.duckco.model.UserInvoice;
import com.example.duckco.repository.InvoiceRepository;

public class InvoiceService {
    private InvoiceRepository InvoiceRepository;

    public InvoiceService() {
        this.InvoiceRepository = new InvoiceRepository();
    }

    public UserInvoice getInvoices(String username) {
        UserInvoice invoices = InvoiceRepository.getInvoices(username);
        return invoices;
    }

    public void addInvoice(int userId, Invoice invoice) {
        InvoiceRepository.addInvoice(userId, invoice);
    }

    public boolean deleteInvoice(int id) {
        return InvoiceRepository.deleteInvoice(id);
    }

    public Invoice getInvoice(int id) {
        return InvoiceRepository.getInvoice(id);
    }

    public void updateInvoice(Invoice invoice) {
        InvoiceRepository.updateInvoice(invoice);
    }

}
