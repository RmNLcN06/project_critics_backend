package com.example.project_critics_backend.services;

import com.example.project_critics_backend.DTOs.ActorDTO;
import com.example.project_critics_backend.DTOs.SerieShortDTO;
import com.example.project_critics_backend.entities.Actor;
import com.example.project_critics_backend.entities.Serie;
import com.example.project_critics_backend.mappers.ActorMapper;
import com.example.project_critics_backend.repositories.ActorRepository;
import com.example.project_critics_backend.repositories.SerieRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActorService {
    private final ActorRepository actorRepository;
    private final SerieRepository serieRepository;
    private final ActorMapper actorMapper;

    public List<ActorDTO> findAll() {
        return actorRepository.findAll().stream()
                .map(actorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ActorDTO findById(Long id) {
        return actorMapper.toDTO(actorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Actor not found")));
    }

    public ActorDTO create(ActorDTO actorDTO) {
        Set<Serie> series = getSeriesFromDto(actorDTO.series);
        Actor actor = actorMapper.toEntity(actorDTO, series);
        return actorMapper.toDTO(actorRepository.save(actor));
    }

    public ActorDTO update(Long id, ActorDTO actorDTO) {
        Actor existingActor = actorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Actor not found"));
        Set<Serie> series = getSeriesFromDto(actorDTO.series);
        Actor updatedActor = actorMapper.toEntity(actorDTO, series);
        updatedActor.setId(existingActor.getId());
        return actorMapper.toDTO(actorRepository.save(updatedActor));
    }

    public void delete(Long id) {

        if(!actorRepository.existsById(id)) {
            throw new EntityNotFoundException("Actor not found");
        }
        actorRepository.deleteById(id);
    }

    private Set<Serie> getSeriesFromDto(Set<SerieShortDTO> serieShortDTOS) {

        if(serieShortDTOS == null) {
            return Collections.emptySet();
        }

        return serieShortDTOS.stream()
                .map(serieShortDTO -> serieRepository.findById(serieShortDTO.id)
                        .orElseThrow(() -> new EntityNotFoundException("Serie not found")))
                .collect(Collectors.toSet());
    }
}
