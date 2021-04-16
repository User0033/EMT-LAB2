package lab2.web.rest;

import lab2.model.Author;
import lab2.model.dto.AuthorDto;
import lab2.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
@AllArgsConstructor
public class AuthorRestController {
    private final AuthorService authorService;

    @GetMapping()
    public List<Author> getAll(){
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable Long id){
        return authorService.findById(id);
    }

    @PostMapping("/add")
    public Author create(@RequestBody AuthorDto authorDto){
        return authorService.save(authorDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        authorService.deleteById(id);
    }
}
