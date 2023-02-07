package com.example.duckco.model;

import java.util.ArrayList;
import java.util.List;

public class UserInvoice {
    private List<Invoice> invoices;


    public UserInvoice(String owner){

        this.invoices=new ArrayList<>();

    }
    public List<Invoice> getInvoices() {
        return invoices;
    }
}
