package com.mindHub.vinilysEcommerce.services.implementations;


import com.mindHub.vinilysEcommerce.repositories.BillRepository;
import com.mindHub.vinilysEcommerce.services.ClientService;
import com.mindHub.vinilysEcommerce.services.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PdfServiceImpl implements PdfService {


    @Autowired
    ClientService clientService;

    @Autowired
    BillRepository billRepository;

}
