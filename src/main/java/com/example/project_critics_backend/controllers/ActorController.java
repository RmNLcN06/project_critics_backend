package com.example.project_critics_backend.controllers;

import com.example.project_critics_backend.DTOs.ActorDTO;
import com.example.project_critics_backend.entities.Actor;
import com.example.project_critics_backend.services.ActorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<ActorDTO> getAllActors() {
        return actorService.findAll();
    }

    @PostMapping
    public Actor createActor(@RequestBody Actor actor) {
        return actorService.create(actor);
    }

    @PutMapping("/{id}")
    public Actor updateActor(@PathVariable Long id, @RequestBody Actor actor) {
        return actorService.update(id, actor);
    }

    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable Long id) {
        actorService.delete(id);
    }
}
