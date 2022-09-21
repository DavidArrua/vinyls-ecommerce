package com.mindHub.vinilysEcommerce.controllers;

import com.mindHub.vinilysEcommerce.dtos.ClientDTO;
import com.mindHub.vinilysEcommerce.models.Client;
import com.mindHub.vinilysEcommerce.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/clients")
    public List<ClientDTO> getClients(){
        return clientService.getAllClients().stream().map(client -> new ClientDTO(client)).collect(Collectors.toList());
    }

    @PostMapping("/clients")
    public ResponseEntity<Object> register(

            @RequestParam String firstName, @RequestParam String lastName,

            @RequestParam String email, @RequestParam String password) {

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {

            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);

        }

        if(!email.contains("@")){
            return new ResponseEntity<>("it's not an email", HttpStatus.FORBIDDEN);
        }

        if (clientService.getClientByEmail(email) != null) {
            return new ResponseEntity<>("Name already in use", HttpStatus.FORBIDDEN);
        }


        Client registerClient = new Client(firstName, lastName, email, passwordEncoder.encode(password), false);
        clientService.saveClient(registerClient);

        String mailSubjet = "Mail de verificacion Orpheus";
        String mailBody = "Casi esta todo listo, solo falta verificar tu cuenta, entra al siguiente link: localhost:8080/web/verified.html?id="+registerClient.getId();
        clientService.sendVerificationMail(registerClient.getEmail(), mailSubjet,mailBody);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/clients/verify/{id}")
    public ResponseEntity<Object> verifyClient(@PathVariable long id){
        Client client = clientService.getClienteById(id);
        client.setValidation(true);
        clientService.saveClient(client);
        return new ResponseEntity<>("Verificado!", HttpStatus.CREATED);
    }

        @RequestMapping("/clients/current")
        public ClientDTO getCurrent(Authentication authentication) {
            return new ClientDTO(clientService.getClientByEmail(authentication.getName()));
        }
}
