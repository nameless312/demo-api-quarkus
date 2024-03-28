package com.nameless.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Publisher {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID publisherId;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String website;
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "publisher")
    public List<Book> book;
}
