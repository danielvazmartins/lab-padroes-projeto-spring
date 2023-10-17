package br.com.danielvazmartins.labpadroesprojetospring.model.DTO;

import lombok.Data;

@Data
public class ClientCreateDTO {
    private String name = "";
    private String email = "";
    private String cep;
}
