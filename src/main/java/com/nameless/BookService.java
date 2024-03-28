package com.nameless;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.nameless.dto.AuthorDTO;
import com.nameless.dto.BookDTO;
import com.nameless.dto.GenreDTO;
import com.nameless.dto.PublisherDTO;
import com.nameless.entities.Author;
import com.nameless.entities.Book;
import com.nameless.entities.Genre;
import com.nameless.entities.Publisher;
import com.nameless.repository.BookRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class BookService {

    @Inject
    BookRepository bookRepository;
    private final ObjectMapper objectMapper;

    public BookService() {
        objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }

    public List<BookDTO> getAllBooks(int page, int size) {
        List<Book> books = bookRepository.findAll().page(page, size).list();
        return books.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public BookDTO toDTO(Book book) {
        return objectMapper.convertValue(book, BookDTO.class);
    }

    public Book toEntity(BookDTO bookDTO) {
        return objectMapper.convertValue(bookDTO, Book.class);
    }

    // Custom mapping method for nested DTOs
    private List<AuthorDTO> mapAuthors(List<Author> authors) {
        return authors.stream()
                .map(author -> objectMapper.convertValue(author, AuthorDTO.class))
                .collect(Collectors.toList());
    }

    // Custom mapping method for nested DTO
    private PublisherDTO mapPublisher(Publisher publisher) {
        return objectMapper.convertValue(publisher, PublisherDTO.class);
    }

    // Custom mapping method for nested DTOs
    private List<GenreDTO> mapGenres(List<Genre> genres) {
        return genres.stream()
                .map(genre -> objectMapper.convertValue(genre, GenreDTO.class))
                .collect(Collectors.toList());
    }
}
