package com.nameless.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class GenreDTO {
    private UUID genreId;
    private String name;
    private String description;
}
