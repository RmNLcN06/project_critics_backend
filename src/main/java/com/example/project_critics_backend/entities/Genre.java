package com.example.project_critics_backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The genre name cannot be empty")
    private String name;

    @ManyToMany(mappedBy = "genres")
    @JsonBackReference
    private Set<Serie> series = new HashSet<>();
}
