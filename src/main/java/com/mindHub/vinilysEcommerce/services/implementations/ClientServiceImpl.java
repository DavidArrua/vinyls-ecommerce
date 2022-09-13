package com.mindHub.vinilysEcommerce.services.implementations;

import com.mindHub.vinilysEcommerce.models.Client;
import com.mindHub.vinilysEcommerce.models.Product;
import com.mindHub.vinilysEcommerce.repositories.ClientRepository;
import com.mindHub.vinilysEcommerce.repositories.ProductRepository;
import com.mindHub.vinilysEcommerce.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public void saveProduct(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }
}
