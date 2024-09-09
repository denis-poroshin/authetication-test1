package ru.authenticationtest.springauthenticationtest.entity;

import ru.authenticationtest.springauthenticationtest.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

//    @Column(name = "last_name")
//    private String lastName;

//    @Column(name = "surname")
//    private String surname;

    @Column(name = "password")
    private String password;
//    @OneToMany
//    @Column(name = "roles")
    @JoinColumn(name = "role")
    private String role;
}
