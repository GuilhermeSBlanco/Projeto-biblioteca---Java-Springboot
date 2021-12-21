package br.com.arthurschultz.library.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import br.com.arthurschultz.library.model.dto.bookDTO;
import br.com.arthurschultz.library.service.BookService;
import br.com.arthurschultz.library.util.BookMapper;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService service;
    
    @GetMapping
    public String formInsert(Model model) {
        bookDTO book = new bookDTO();
        model.addAttribute("objBook", book);
        return "pages/register";
    }

    @PostMapping
    public String Insert(@ModelAttribute bookDTO bookDto) {
        var book = service.insertOrUpdate(BookMapper.toBook(bookDto));
        
        if (book.getId() != 0) {
            return "pages/success";
        } else {
            return "pages/error";
        }

        
    }
}
