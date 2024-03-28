package com.nameless.repository;

import com.nameless.entities.Genre;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class GenreRepository implements PanacheRepositoryBase<Genre, UUID>{
}
