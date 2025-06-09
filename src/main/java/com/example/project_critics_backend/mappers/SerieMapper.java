package com.example.project_critics_backend.mappers;

import com.example.project_critics_backend.DTOs.ActorShortDTO;
import com.example.project_critics_backend.DTOs.SerieDTO;
import com.example.project_critics_backend.entities.Actor;
import com.example.project_critics_backend.entities.Serie;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class SerieMapper {
    public SerieDTO toDTO(Serie serie) {
        SerieDTO dto = new SerieDTO();
        dto.id = serie.getId();
        dto.title = serie.getTitle();
        dto.year = serie.getYear();
        dto.types = serie.getTypes();
        dto.actors = serie.getActors().stream().map(this::toActorShort).collect(Collectors.toSet());
        return dto;
    }

    public ActorShortDTO toActorShort(Actor actor) {
        ActorShortDTO asDTO = new ActorShortDTO();
        asDTO.id = actor.getId();
        asDTO.lastname = actor.getLastname();
        asDTO.firstname = actor.getFirstname();
        return asDTO;
    }
}
