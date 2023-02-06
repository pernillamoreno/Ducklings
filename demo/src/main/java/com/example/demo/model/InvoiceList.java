package com.example.demo.model;


import java.util.ArrayList;
import java.util.List;

public class InvoiceList {

    private List<InvoiceItem> itemList;
    private String owner;

    public InvoiceList(String owner) {
        this.owner = owner;
        this.itemList = new ArrayList<>();
    }

    public String getOwner() {
        return owner;
    }

    public List<InvoiceItem> getItemList() {
        return itemList;
    }
}