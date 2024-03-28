package com.nameless;

import com.nameless.dto.BookDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

import java.util.List;

@Path("/books")
public class BookController {
    @Inject
    BookService bookService;

    @GET
    public List<BookDTO> getAllBooks(@QueryParam("page") int page,
                                     @QueryParam("size") int size) {
        return bookService.getAllBooks(page, size);
    }

}
