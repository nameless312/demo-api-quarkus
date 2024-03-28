package com.nameless.repository;

import com.nameless.entities.Publisher;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class PublisherRepository implements PanacheRepositoryBase<Publisher, UUID>{
}
