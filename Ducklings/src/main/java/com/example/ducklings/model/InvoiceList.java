package com.example.ducklings.model;



import java.util.List;

public class InvoiceList {


    private List<InvoiceItem> invoices;
    private String users;

    public InvoiceList() {
    }

    public InvoiceList(List<InvoiceItem> invoices, String user) {
        this.invoices = invoices;
        this.users = user;
    }

    public List<InvoiceItem> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<InvoiceItem> invoices) {
        this.invoices = invoices;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "InvoiceList{" +
                "invoices=" + invoices +
                ", users='" + users + '\'' +
                '}';
    }
}