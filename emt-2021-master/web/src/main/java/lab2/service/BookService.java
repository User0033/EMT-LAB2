package lab2.service;

import lab2.model.Book;
import lab2.model.dto.BookDto;


import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Book findById(Long id);

    Book findByName(String name);

    Book save(BookDto bookDTO);

    Book update(BookDto book);

    void markAsTaken(Long id) throws Exception;

    void deleteById(Long id);

}
