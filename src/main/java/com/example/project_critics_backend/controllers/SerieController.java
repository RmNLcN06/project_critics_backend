package com.example.project_critics_backend.controllers;

import com.example.project_critics_backend.DTOs.ActorDTO;
import com.example.project_critics_backend.DTOs.SerieDTO;
import com.example.project_critics_backend.entities.Serie;
import com.example.project_critics_backend.services.SerieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/series")
@RequiredArgsConstructor
public class SerieController {

    private final SerieService serieService;

    @GetMapping
    public List<SerieDTO> getAllSeries() {
        return serieService.findAll();
    }

    @GetMapping("/{id}")
    public SerieDTO getSerieById(@PathVariable Long id) {
        return serieService.findById(id);
    }

    @PostMapping
    public ResponseEntity<SerieDTO> createSerie(@RequestBody @Valid SerieDTO serieDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serieService.create(serieDTO));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<SerieDTO> updateSerie(@PathVariable Long id, @RequestBody @Valid SerieDTO serieDTO) {
        return ResponseEntity.ok(serieService.update(id, serieDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSerie(@PathVariable Long id) {
        serieService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
