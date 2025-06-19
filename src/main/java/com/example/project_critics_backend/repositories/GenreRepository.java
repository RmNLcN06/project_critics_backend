package com.example.project_critics_backend.repositories;

import com.example.project_critics_backend.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
