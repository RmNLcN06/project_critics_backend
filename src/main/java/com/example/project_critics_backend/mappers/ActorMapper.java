package com.example.project_critics_backend.mappers;

import com.example.project_critics_backend.DTOs.ActorDTO;
import com.example.project_critics_backend.DTOs.SerieShortDTO;
import com.example.project_critics_backend.entities.Actor;
import com.example.project_critics_backend.entities.Serie;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ActorMapper {
    public ActorDTO toDTO(Actor actor) {
        ActorDTO dto = new ActorDTO();
        dto.id = actor.getId();
        dto.lastname = actor.getLastname();
        dto.firstname = actor.getFirstname();
        dto.dateOfBirth = actor.getDateOfBirth();
        dto.series = actor.getSeries().stream().map(this::toSerieShort).collect(Collectors.toSet());
        return dto;
    }

    public SerieShortDTO toSerieShort(Serie serie) {
        SerieShortDTO ssDTO = new SerieShortDTO();
        ssDTO.id = serie.getId();
        ssDTO.title = serie.getTitle();
        ssDTO.year = serie.getYear();
        return ssDTO;
    }
}
