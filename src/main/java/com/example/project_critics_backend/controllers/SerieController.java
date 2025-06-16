package com.example.project_critics_backend.controllers;

import com.example.project_critics_backend.DTOs.SerieDTO;
import com.example.project_critics_backend.entities.Serie;
import com.example.project_critics_backend.services.SerieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/series")
public class SerieController {

    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping
    public List<SerieDTO> getAllSeries() {
        return serieService.findAll();
    }

    @PostMapping
    public Serie createSerie(@RequestBody Serie serie) {
        return serieService.create(serie);
    }

    @PutMapping("/{id}")
    public Serie updateSerie(@PathVariable Long id, @RequestBody Serie serie) {
        return serieService.update(id, serie);
    }

    @DeleteMapping("/{id}")
    public void deleteSerie(@PathVariable Long id) {
        serieService.delete(id);
    }

}
