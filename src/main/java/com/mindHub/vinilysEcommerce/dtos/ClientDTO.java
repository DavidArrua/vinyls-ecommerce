package com.mindHub.vinilysEcommerce.dtos;

import com.mindHub.vinilysEcommerce.models.Client;

import java.util.Set;
import java.util.stream.Collectors;

public class ClientDTO {


    private long id;

    private String firstName, lastName, email, password;

    private boolean validation;

    private Set<BillDTO> bills;

    public ClientDTO() {
    }

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.validation = client.isValidation();
        this.bills = client.getBills().stream().map(bill -> new BillDTO(bill)).collect(Collectors.toSet());
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isValidation() {
        return validation;
    }

    public Set<BillDTO> getBills() {
        return bills;
    }
}
