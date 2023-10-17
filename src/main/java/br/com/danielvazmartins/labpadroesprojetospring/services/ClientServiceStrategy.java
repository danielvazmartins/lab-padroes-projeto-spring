package br.com.danielvazmartins.labpadroesprojetospring.services;

import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;

import br.com.danielvazmartins.labpadroesprojetospring.model.ClientModel;

public interface ClientServiceStrategy {
    public ClientModel getOne(UUID id);
    public List<ClientModel> getAll();
    public ResponseEntity<String> registerClient(ClientModel client);
    public ResponseEntity<String> updateClient(UUID id, ClientModel client);
    public ResponseEntity<String> deleteClient(UUID id);
}
