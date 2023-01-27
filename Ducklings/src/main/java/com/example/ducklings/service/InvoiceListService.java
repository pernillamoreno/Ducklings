package com.example.ducklings.service;



import com.example.ducklings.model.InvoiceItem;
import com.example.ducklings.model.InvoiceList;
import com.example.ducklings.respository.InvoiceListRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Service
public class InvoiceListService {

    private final InvoiceListRepo invoice;
    private InvoiceListService listRepository;

    public InvoiceListService() {
        this.invoice= new InvoiceListRepo();
    }

    public InvoiceList getInvoiceList(String username,String password) {
        InvoiceList list = listRepository.getInvoiceList(username, password);

        if(list == null) {
            //listRepository.createNew(username);
            list = new InvoiceList();
        }

        return list;
    }

    public void addInvoiceItem(String username, InvoiceItem item) {
        listRepository.addInvoiceItem(username, item);
    }
}
