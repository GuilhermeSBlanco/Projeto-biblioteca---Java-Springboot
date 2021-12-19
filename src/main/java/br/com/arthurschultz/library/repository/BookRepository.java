package br.com.arthurschultz.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.arthurschultz.library.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
    
}
