package br.com.arthurschultz.library.util;

import br.com.arthurschultz.library.model.dto.bookDTO;
import br.com.arthurschultz.library.model.Book;

public class BookMapper {

    private BookMapper() {}

    public static bookDTO fromBook(Book book) {
        return new bookDTO(book.getId(), book.getNome(), book.getAutor(), book.getGenero());
    }

    public static Book toBook(bookDTO dto) {
        return new Book(dto.getId(), dto.getNome(), dto.getAutor(), dto.getGenero());
    }
    
}
