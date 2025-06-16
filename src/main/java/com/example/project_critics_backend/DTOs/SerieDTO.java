package com.example.project_critics_backend.DTOs;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Set;

public class SerieDTO {
    public Long id;

    @NotBlank(message = "The serie's title is required")
    public String title;

    public int year;

    public List<@NotBlank(message = "A type cannot be empty") String> types;

    public Set<@Valid ActorShortDTO> actors;
}
