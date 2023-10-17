package br.com.danielvazmartins.labpadroesprojetospring.model;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "client")
public class ClientModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private TYPE_PERSON typePerson;

    @ManyToOne
    private AddressModel address;
}
