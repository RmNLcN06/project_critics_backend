package com.example.project_critics_backend.controllers;

import com.example.project_critics_backend.DTOs.ActorDTO;
import com.example.project_critics_backend.entities.Actor;
import com.example.project_critics_backend.services.ActorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @GetMapping
    public List<ActorDTO> getAllActors() {
        return actorService.findAll();
    }

    @GetMapping("/{id}")
    public ActorDTO getActorById(@PathVariable Long id) {
        return actorService.findById(id);
    }

    @PostMapping
    public ResponseEntity<ActorDTO> createActor(@RequestBody @Valid ActorDTO actorDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(actorService.create(actorDTO));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ActorDTO> updateActor(@PathVariable Long id, @RequestBody @Valid ActorDTO actorDTO) {
        return ResponseEntity.ok(actorService.update(id, actorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable Long id) {
        actorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
