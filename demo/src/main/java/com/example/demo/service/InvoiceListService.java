package com.example.demo.service;

import com.example.demo.model.InvoiceItem;
import com.example.demo.model.InvoiceList;

import com.example.demo.repository.InvoiceListRepository;


public class InvoiceListService {

    private InvoiceListRepository listRepository;

    public InvoiceListService() {
        this.listRepository = new InvoiceListRepository();
    }

    public InvoiceList getInvoiceList(String username) {
        InvoiceList list = listRepository.getInvoiceList(username);

        if(list == null) {
            list = new InvoiceList(username);
        }

        return list;
    }

    public void addInvoiceItem(String username, InvoiceItem item) {
        listRepository.addItem(username, item);
    }


}

