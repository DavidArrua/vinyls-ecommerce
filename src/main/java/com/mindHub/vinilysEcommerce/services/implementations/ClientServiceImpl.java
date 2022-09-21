package com.mindHub.vinilysEcommerce.services.implementations;

import com.mindHub.vinilysEcommerce.email.verificationEmail;
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
    verificationEmail verificationEmail;

    @Autowired
    ClientRepository clientRepository;

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }
    @Override
    public Client getClientByEmail(String email){
        return clientRepository.findByEmail(email);
    }

    @Override
    public void sendVerificationMail(String email, String subject, String body) {
        verificationEmail.sendVerificationEmail(email, subject, body);
    }

    @Override
    public Client getClienteById(long id) {
        return clientRepository.findById(id);
    }
}
