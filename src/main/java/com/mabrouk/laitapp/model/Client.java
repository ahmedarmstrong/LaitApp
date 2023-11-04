package com.mabrouk.laitapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue
    private Long id ;

    @NotBlank(message="firstname must not be blank")
    @Size(min=3, message="Name must be at least 5 characters long")
    private String firstname ;

    @NotBlank(message="lastname must not be blank")
    @Size(min=3, message="lastname must be at least 5 characters long")
    private String lastname;

    @NotBlank(message="Mobile number must not be blank")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 9 digits")
    @Column(unique = true)
    private String tel ;

    @NotBlank(message="Confirm Email must not be blank")
    @Email(message = "Please provide a valid confirm email address" )
    @Column(unique = true)
    private String email ;


    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,targetEntity = QLait.class)
    private List<QLait> lait;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id", nullable = true)
    private Region region ;

}
