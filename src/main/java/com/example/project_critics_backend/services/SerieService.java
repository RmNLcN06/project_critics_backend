package com.example.project_critics_backend.services;

import com.example.project_critics_backend.DTOs.ActorShortDTO;
import com.example.project_critics_backend.DTOs.SerieDTO;
import com.example.project_critics_backend.entities.Actor;
import com.example.project_critics_backend.entities.Serie;
import com.example.project_critics_backend.mappers.SerieMapper;
import com.example.project_critics_backend.repositories.ActorRepository;
import com.example.project_critics_backend.repositories.SerieRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SerieService {
    private final SerieRepository serieRepository;
    private final ActorRepository actorRepository;
    private final SerieMapper serieMapper;

    public List<SerieDTO> findAll() {
        return serieRepository.findAll().stream()
                .map(serieMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SerieDTO findById(Long id) {
        return serieMapper.toDTO(serieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Serie not found")));
    }

    public SerieDTO create(SerieDTO serieDTO) {
        Set<Actor> actors = getActorsFromDto(serieDTO.actors);
        Serie serie = serieMapper.toEntity(serieDTO, actors);
        return serieMapper.toDTO(serieRepository.save(serie));
    }

    public SerieDTO update(Long id, SerieDTO serieDTO) {
        Serie existingSerie = serieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Serie not found"));
        Set<Actor> actors = getActorsFromDto(serieDTO.actors);
        Serie updatedSerie = serieMapper.toEntity(serieDTO, actors);
        updatedSerie.setId(existingSerie.getId());
        return serieMapper.toDTO(serieRepository.save(updatedSerie));
    }

    public void delete(Long id) {

        if(!serieRepository.existsById(id)) {
            throw new EntityNotFoundException("Serie not found");
        }

        serieRepository.deleteById(id);
    }

    private Set<Actor> getActorsFromDto(Set<ActorShortDTO> actorShortDTOS) {

        if(actorShortDTOS == null) {
            return Collections.emptySet();
        }

        return actorShortDTOS.stream()
                .map(dto -> actorRepository.findById(dto.id)
                        .orElseThrow(() -> new EntityNotFoundException("Actor not found")))
                .collect(Collectors.toSet());
    }
}
