package lab2.service.impl;

import lab2.model.Author;
import lab2.model.Country;
import lab2.model.dto.AuthorDto;
import lab2.repository.AuthorRepository;
import lab2.repository.CountryRepository;
import lab2.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author  save(AuthorDto authorDto) {
        Country country = countryRepository.findByName(authorDto.getCountry()).orElseThrow();
        return authorRepository.save(new Author(authorDto.getName(), authorDto.getSurname(), country));
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
