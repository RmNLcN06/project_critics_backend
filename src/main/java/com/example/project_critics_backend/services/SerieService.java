package com.example.project_critics_backend.services;

import com.example.project_critics_backend.DTOs.SerieDTO;
import com.example.project_critics_backend.entities.Serie;
import com.example.project_critics_backend.mappers.SerieMapper;
import com.example.project_critics_backend.repositories.ActorRepository;
import com.example.project_critics_backend.repositories.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService {
    private final SerieRepository serieRepository;
    private final ActorRepository actorRepository;
    private final SerieMapper serieMapper;

    public SerieService(SerieRepository serieRepository, ActorRepository actorRepository, SerieMapper serieMapper) {
        this.serieRepository = serieRepository;
        this.actorRepository = actorRepository;
        this.serieMapper = serieMapper;
    }

    public List<SerieDTO> findAll() {
        return serieRepository.findAll().stream()
                .map(serieMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Serie create(Serie serie) {
        return serieRepository.save(serie);
    }

    public Serie update(Long id, Serie serieDetails) {
        Serie serie = serieRepository.findById(id).orElseThrow();
        serie.setTitle(serieDetails.getTitle());
        serie.setYear(serieDetails.getYear());
        serie.setTypes(serieDetails.getTypes());
        serie.setActors(serieDetails.getActors());
        return serieRepository.save(serie);
    }

    public void delete(Long id) {
        serieRepository.deleteById(id);
    }
}
