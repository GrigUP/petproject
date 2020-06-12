package ru.grig.petproject.domain.entities;

import lombok.Data;
import ru.grig.petproject.domain.Role;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "users")
public class BaseUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotEmpty
    private String username;

    @Column(unique = true)
    @NotEmpty
    private String password;

    @Column
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

}
