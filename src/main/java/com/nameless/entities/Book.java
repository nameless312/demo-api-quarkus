package com.nameless.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Book {
    private String title;
    @ManyToMany
    private List<Author> authors;
    private int year;
    @Id
    private Long isbn;
    private String description;
    @ManyToOne
    private Publisher publisher;
    private String language;
    @ManyToMany
    private List<Genre> genres;
    private Date publicationDate;
    private int pages;
}
