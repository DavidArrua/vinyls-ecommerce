package com.mindHub.vinilysEcommerce.services;

import com.mindHub.vinilysEcommerce.models.Client;

import java.util.List;

public interface ClientService {

    public void saveProduct(Client client);

    public List<Client> getAllClients();
}
