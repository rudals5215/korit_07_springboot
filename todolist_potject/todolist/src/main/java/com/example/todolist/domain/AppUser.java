package com.example.todolist.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private final String username;

    @Column(nullable = false)
    private final String password;

    @Column(nullable = false)
    private final String role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appUser")
    private final List<Todo> todos;
}
