package com.example.project_critics_backend.mappers;

import com.example.project_critics_backend.DTOs.ActorShortDTO;
import com.example.project_critics_backend.DTOs.SerieDTO;
import com.example.project_critics_backend.entities.Actor;
import com.example.project_critics_backend.entities.Serie;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SerieMapper {
    public SerieDTO toDTO(Serie serie) {

        if(serie == null) {
            return null;
        }

        SerieDTO dto = new SerieDTO();
        dto.id = serie.getId();
        dto.title = serie.getTitle();
        dto.year = serie.getYear();
        dto.genres = serie.getGenres();
        dto.actors = serie.getActors().stream().map(actor -> {
            ActorShortDTO actorShortDTO = new ActorShortDTO();
            actorShortDTO.id = actor.getId();
            actorShortDTO.lastname = actor.getLastname();
            actorShortDTO.firstname = actor.getFirstname();
            return actorShortDTO;
        }).collect(Collectors.toSet());
        return dto;
    }

    public Serie toEntity(SerieDTO serieDTO, Set<Actor> actors) {

        if(serieDTO == null) {
            return null;
        }

        Serie serie = new Serie();
        serie.setId(serieDTO.id);
        serie.setTitle(serieDTO.title);
        serie.setYear(serieDTO.year);
        serie.setGenres(serieDTO.genres);
        serie.setActors(actors);
        return serie;
    }

    /*public ActorShortDTO toActorShort(Actor actor) {
        ActorShortDTO asDTO = new ActorShortDTO();
        asDTO.id = actor.getId();
        asDTO.lastname = actor.getLastname();
        asDTO.firstname = actor.getFirstname();
        return asDTO;
    }*/
}
