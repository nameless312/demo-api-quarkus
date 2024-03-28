package com.nameless.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AuthorDTO {
    private UUID authorId;
    private String name;
    private String surname;
}
