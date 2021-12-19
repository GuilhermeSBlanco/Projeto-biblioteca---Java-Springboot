package br.com.arthurschultz.library.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.arthurschultz.library.model.Book;
import br.com.arthurschultz.library.model.dto.bookDTO;
import br.com.arthurschultz.library.service.BookService;
import br.com.arthurschultz.library.util.BookMapper;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")

public class APIBookController {
    @Autowired
    private BookService service;
    
    @PostMapping
    public ResponseEntity<bookDTO> insert(@RequestBody bookDTO book) {
        var isSuccess = service.insertOrUpdate(BookMapper.toBook(book));

        if(isSuccess != null) {
            return new ResponseEntity<>(BookMapper.fromBook(isSuccess), HttpStatus.CREATED);
        }

        return new ResponseEntity<>(new bookDTO(), HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<bookDTO>> findAll() {
        return new ResponseEntity<>(
                service.findAll().stream().map(
                        (obj) -> BookMapper.fromBook(obj)).collect(Collectors.toList()),
                HttpStatus.OK);
    }
}
