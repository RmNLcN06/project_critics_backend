package com.example.project_critics_backend.DTOs;

import java.time.LocalDate;
import java.util.Set;

public class ActorDTO {
    public Long id;
    public String lastname;
    public String firstname;
    public LocalDate dateOfBirth;
    public Set<SerieShortDTO> series;
}
