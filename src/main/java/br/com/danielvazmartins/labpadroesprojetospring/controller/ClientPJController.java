package br.com.danielvazmartins.labpadroesprojetospring.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielvazmartins.labpadroesprojetospring.model.AddressModel;
import br.com.danielvazmartins.labpadroesprojetospring.model.ClientModel;
import br.com.danielvazmartins.labpadroesprojetospring.model.DTO.ClientCreateDTO;
import br.com.danielvazmartins.labpadroesprojetospring.services.ClientServicePJ;

@RestController
@RequestMapping(path = "clientsPJ")
public class ClientPJController {

    @Autowired
    private ClientServicePJ clientServicePJ;

    @GetMapping()
    public ResponseEntity<List<ClientModel>> getAll() {
        return ResponseEntity.ok(clientServicePJ.getAll());
    }

    @PostMapping()
    public ResponseEntity<String> createPF(@RequestBody() ClientCreateDTO client) {
        ClientModel newClient = new ClientModel();
        newClient.setName(client.getName());
        newClient.setEmail(client.getEmail());
        AddressModel address = new AddressModel();
        address.setCep(client.getCep());
        newClient.setAddress(address);
        
        return clientServicePJ.registerClient(newClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("id") UUID id, @RequestBody ClientModel client) {
        return clientServicePJ.updateClient(id, client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") UUID id) {
        return clientServicePJ.deleteClient(id);
    }
}
