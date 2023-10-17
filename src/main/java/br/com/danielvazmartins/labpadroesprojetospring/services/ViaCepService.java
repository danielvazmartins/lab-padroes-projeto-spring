package br.com.danielvazmartins.labpadroesprojetospring.services;

import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.danielvazmartins.labpadroesprojetospring.model.AddressModel;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
    
    @GetMapping("/{cep}/json")
    public Optional<AddressModel> getAddress(@PathVariable("cep") String cep);
}
