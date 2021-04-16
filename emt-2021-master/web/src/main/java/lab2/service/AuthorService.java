package lab2.service;

import lab2.model.Author;
import lab2.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Author save(AuthorDto authorDto);
    Author findById(Long id);

    List<Author> findAll();

    void deleteById(Long id);
}
