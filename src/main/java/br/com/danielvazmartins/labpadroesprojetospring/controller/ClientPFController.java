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
import br.com.danielvazmartins.labpadroesprojetospring.services.ClientServicePF;

@RestController
@RequestMapping(path = "clientsPF")
public class ClientPFController {

    @Autowired
    private ClientServicePF clientServicePF;

    @GetMapping()
    public ResponseEntity<List<ClientModel>> getAll() {
        return ResponseEntity.ok(clientServicePF.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientModel> getOne(@PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(clientServicePF.getOne(id));
    }

    @PostMapping()
    public ResponseEntity<String> createPF(@RequestBody() ClientCreateDTO client) {
        ClientModel newClient = new ClientModel();
        newClient.setName(client.getName());
        newClient.setEmail(client.getEmail());
        AddressModel address = new AddressModel();
        address.setCep(client.getCep());
        newClient.setAddress(address);
        
        return clientServicePF.registerClient(newClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("id") UUID id, @RequestBody ClientModel client) {
        return clientServicePF.updateClient(id, client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") UUID id) {
        return clientServicePF.deleteClient(id);
    }
}
