package lab2.web.rest;

import lab2.model.Book;
import lab2.model.dto.BookDto;
import lab2.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id){
        return bookService.findById(id);
    }

    @PostMapping("/add")
    public Book create(@RequestBody BookDto bookDto){
        return this.bookService.save(bookDto);
    }

    @PostMapping("/edit")
    public Book update(@RequestBody BookDto bookDto){
        return this.bookService.update(bookDto);
    }

    @PostMapping("/mark-taken/{id}")
    public void markAsTaken(@PathVariable Long id) throws Exception {
        bookService.markAsTaken(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        this.bookService.deleteById(id);
    }
}
