package com.example.project_critics_backend.DTOs;

import java.util.List;
import java.util.Set;

public class SerieDTO {
    public Long id;
    public String title;
    public int year;
    public List<String> types;
    public Set<Long> actorsIds;
}
