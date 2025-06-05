package com.example.project_critics_backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastname;
    private String firstname;
    private LocalDate dateOfBirth;

    @ManyToMany(mappedBy = "actors")
    @JsonBackReference
    private Set<Serie> series = new HashSet<>();
}
