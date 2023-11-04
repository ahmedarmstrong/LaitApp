package com.mabrouk.laitapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message="username must not be blank")
    @Size(min=5, message="Name must be at least 5 characters long")
    private String username;

    //@NotBlank(message="firstname must not be blank")
    @Size(min=3, message="Name must be at least 5 characters long")
    private String firstname;

    //@NotBlank(message="lastname must not be blank")
    @Size(min=3, message="lastname must be at least 5 characters long")
    private String lastname;

    @NotBlank(message="Email must not be blank")
    @Email(message = "Please provide a valid email address" )
    @Column(unique = true)
    private String email;

    @NotBlank(message="Password must not be blank")
    @Size(min=6, message="Password must be at least 5 characters long")
    private String password;

    private Boolean locked = false;
    private Boolean enabled = false;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
