package com.mabrouk.laitapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "qlait")
public class QLait {

    @Id
    @GeneratedValue
    private Long id ;

    private Date  date ;

    private double quantitejour ;

    private double quantitesoir ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", nullable = true)
    private Client client ;
}
