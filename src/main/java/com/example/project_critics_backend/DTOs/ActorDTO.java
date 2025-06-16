package com.example.project_critics_backend.DTOs;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;
import java.util.Set;

public class ActorDTO {
    public Long id;

    @NotBlank(message = "The actor's lastname is required")
    public String lastname;

    @NotBlank(message = "The actor's firstname is required")
    public String firstname;

    @Past(message = "The date of birth must be in the past")
    public LocalDate dateOfBirth;

    public Set<@Valid SerieShortDTO> series;
}
