package com.example.project_critics_backend.services;

import com.example.project_critics_backend.DTOs.ActorDTO;
import com.example.project_critics_backend.entities.Actor;
import com.example.project_critics_backend.mappers.ActorMapper;
import com.example.project_critics_backend.repositories.ActorRepository;
import com.example.project_critics_backend.repositories.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService {
    private final ActorRepository actorRepository;
    private final SerieRepository serieRepository;
    private final ActorMapper actorMapper;

    public ActorService(ActorRepository actorRepository, SerieRepository serieRepository, ActorMapper actorMapper) {
        this.actorRepository = actorRepository;
        this.serieRepository = serieRepository;
        this.actorMapper = actorMapper;
    }

    public List<ActorDTO> findAll() {
        return actorRepository.findAll().stream()
                .map(actorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Actor create(Actor actor) {
        return actorRepository.save(actor);
    }

    public Actor update(Long id, Actor actorDetails) {
        Actor actor = actorRepository.findById(id).orElseThrow();
        actor.setLastname(actorDetails.getLastname());
        actor.setFirstname(actorDetails.getFirstname());
        actor.setDateOfBirth(actorDetails.getDateOfBirth());
        actor.setSeries(actorDetails.getSeries());
        return actorRepository.save(actor);
    }

    public void delete(Long id) {
        actorRepository.deleteById(id);
    }
}
