package com.nameless.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID authorId;
    private String name;
    private String surname;
    @JsonIgnore
    @ManyToMany(mappedBy = "authors")
    public List<Book> books;
}
