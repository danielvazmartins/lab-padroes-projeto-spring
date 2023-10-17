package br.com.danielvazmartins.labpadroesprojetospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.danielvazmartins.labpadroesprojetospring.model.AddressModel;

@Repository
public interface AddressRepository extends JpaRepository<AddressModel, String>  {
    
}
