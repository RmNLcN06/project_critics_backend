package com.example.project_critics_backend.mappers;

import com.example.project_critics_backend.DTOs.ActorDTO;
import com.example.project_critics_backend.DTOs.SerieShortDTO;
import com.example.project_critics_backend.entities.Actor;
import com.example.project_critics_backend.entities.Serie;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ActorMapper {
    public ActorDTO toDTO(Actor actor) {

        if(actor == null) {
            return null;
        }

        ActorDTO dto = new ActorDTO();
        dto.id = actor.getId();
        dto.lastname = actor.getLastname();
        dto.firstname = actor.getFirstname();
        dto.dateOfBirth = actor.getDateOfBirth();
        dto.series = actor.getSeries().stream().map(serie-> {
            SerieShortDTO serieShortDTO = new SerieShortDTO();
            serieShortDTO.id = serie.getId();
            serieShortDTO.title = serie.getTitle();
            serieShortDTO.year = serie.getYear();
            return serieShortDTO;
        }).collect(Collectors.toSet());
        return dto;
    }

    public Actor toEntity(ActorDTO actorDTO, Set<Serie> series) {

        if(actorDTO == null) {
            return null;
        }

        Actor actor = new Actor();
        actor.setId(actorDTO.id);
        actor.setLastname(actorDTO.lastname);
        actor.setFirstname(actorDTO.firstname);
        actor.setDateOfBirth(actorDTO.dateOfBirth);
        actor.setSeries(series);
        return actor;
    }

    /*public SerieShortDTO toSerieShort(Serie serie) {
        SerieShortDTO ssDTO = new SerieShortDTO();
        ssDTO.id = serie.getId();
        ssDTO.title = serie.getTitle();
        ssDTO.year = serie.getYear();
        return ssDTO;
    }*/
}
