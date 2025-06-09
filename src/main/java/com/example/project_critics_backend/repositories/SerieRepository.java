package com.example.project_critics_backend.repositories;

import com.example.project_critics_backend.entities.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
}
