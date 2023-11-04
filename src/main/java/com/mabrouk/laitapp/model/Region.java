package com.mabrouk.laitapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue
    private Long id ;

    @NotBlank(message="Name must not be blank")
    @Size(min=3, message="Name must be at least 3 characters long")
    @Column(unique = true)
    private String nom ;

    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,targetEntity = Client.class)
    private List<Client> client;
}
