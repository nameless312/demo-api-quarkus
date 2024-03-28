package com.nameless.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BookDTO {
    private String title;
    private List<AuthorDTO> authors;
    private int year;
    private Long isbn;
    private String description;
    private PublisherDTO publisher;
    private String language;
    private List<GenreDTO> genres;
    private Date publicationDate;
    private int pages;
}
