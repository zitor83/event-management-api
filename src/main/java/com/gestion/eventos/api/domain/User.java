package com.gestion.eventos.api.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;

    // Relación Many-to-Many con Role
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

    // Configuración de la tabla intermedia para la relación Many-to-Many entre User y Role
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles= new HashSet<>();
}
