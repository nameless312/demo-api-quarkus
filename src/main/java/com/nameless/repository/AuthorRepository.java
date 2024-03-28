package com.nameless.repository;

import com.nameless.entities.Author;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class AuthorRepository implements PanacheRepositoryBase<Author, UUID>{
}
