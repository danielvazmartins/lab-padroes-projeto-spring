package br.com.danielvazmartins.labpadroesprojetospring.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.danielvazmartins.labpadroesprojetospring.model.ClientModel;
import br.com.danielvazmartins.labpadroesprojetospring.model.TYPE_PERSON;

import java.util.List;


public interface ClientRepository extends JpaRepository<ClientModel, UUID> {
    List<ClientModel> findByEmail(String email);
    List<ClientModel> findByTypePerson(TYPE_PERSON typePerson);
}
