package br.com.arthurschultz.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.arthurschultz.library.repository.BookRepository;
import br.com.arthurschultz.library.model.Book;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepo;

    public Book insertOrUpdate(Book book) {
        return bookRepo.save(book);
    }

    public List<Book> findAll() {
        return bookRepo.findAll();
    } 

    public Optional<Book> findById(int id) {
        return bookRepo.findById(id);
    }

    public boolean Delete(int id) {
        var book = this.findById(id);

        if (book.isPresent()) {
            bookRepo.deleteById(id);
            book = findById(id);
        }
        
        book = this.findById(id);
        return book.isEmpty();
    }
}
