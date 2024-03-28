package com.nameless.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Genre {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID genreId;
    private String name;
    private String description;
    @JsonIgnore
    @ManyToMany(mappedBy = "genres")
    public List<Book> books;
}
