package lab2.service.impl;

import lab2.model.Author;
import lab2.model.Book;
import lab2.model.dto.BookDto;
import lab2.model.enumerations.CategoryStatus;
import lab2.repository.AuthorRepository;
import lab2.repository.BookRepository;
import lab2.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @Override
    public Book findByName(String name) {
        return bookRepository.findByName(name).orElseThrow();
    }

    @Override
    public Book save(BookDto bookDto) {
        CategoryStatus cat = CategoryStatus.values()[bookDto.getCategoryId()];
        Author aut = authorRepository.findById(bookDto.getAuthorId()).orElseThrow();
        return bookRepository.save(new Book(bookDto.getName(), cat, aut, bookDto.getAvailableCopies()));
    }


    @Override
    public Book update(BookDto bookDTO) {
        Book oldBook = bookRepository.findById(bookDTO.getId()).orElseThrow();
        Author author = authorRepository.findById(bookDTO.getAuthorId()).orElseThrow();
        CategoryStatus category = CategoryStatus.values()[bookDTO.getCategoryId()];
        oldBook.setAuthor(author);
        oldBook.setAvailableCopies(bookDTO.getAvailableCopies());
        oldBook.setCategory(category);
        oldBook.setName(bookDTO.getName());

        return bookRepository.save(oldBook);
    }

    @Override
    public void markAsTaken(Long id) throws Exception {
        Book book = bookRepository.findById(id).orElseThrow();
        if(book.getAvailableCopies() <= 0)
            throw new Exception("Cannot take book " + book.getName() + " with 0 available copies");
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
