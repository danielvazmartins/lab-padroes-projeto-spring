package br.com.danielvazmartins.labpadroesprojetospring.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.danielvazmartins.labpadroesprojetospring.model.AddressModel;
import br.com.danielvazmartins.labpadroesprojetospring.model.ClientModel;
import br.com.danielvazmartins.labpadroesprojetospring.model.TYPE_PERSON;
import br.com.danielvazmartins.labpadroesprojetospring.repository.AddressRepository;
import br.com.danielvazmartins.labpadroesprojetospring.repository.ClientRepository;

@Service
public class ClientServicePJ implements ClientServiceStrategy {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public ClientModel getOne(UUID id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public List<ClientModel> getAll() {
        return clientRepository.findByTypePerson(TYPE_PERSON.PJ);
    }

    @Override
    public ResponseEntity<String> registerClient(ClientModel client) {
        List<ClientModel> clientWithEmail = clientRepository.findByEmail(client.getEmail());
        if (clientWithEmail.size() > 0) {
            return ResponseEntity.badRequest().body("Já existe um usuário com esse e-mail!");
        }

        Optional<AddressModel> fullAddress = addressRepository.findById(client.getAddress().getCep());
        if (fullAddress.isEmpty()) {
            fullAddress = viaCepService.getAddress(client.getAddress().getCep());
        }

        client.setTypePerson(TYPE_PERSON.PJ);

        addressRepository.save(fullAddress.get());
        client.setAddress(fullAddress.get());
        clientRepository.save(client);

        return ResponseEntity.ok().body("Cliente cadastrado com sucesso!");
    }

    @Override
    public ResponseEntity<String> updateClient(UUID id, ClientModel client) {
        Optional<ClientModel> savedClient = clientRepository.findById(id);
        if (savedClient.isEmpty()) {
            return ResponseEntity.badRequest().body("Cliente não encontrado!");
        }

        clientRepository.save(client);
        return ResponseEntity.ok().body("Cliente salvo com sucesso!");
    }

    @Override
    public ResponseEntity<String> deleteClient(UUID id) {
        clientRepository.deleteById(id);
        return ResponseEntity.ok("Cliente removido!");
    }    
}
