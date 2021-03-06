package lab2.web.rest;

import lab2.model.Country;
import lab2.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/countries")
@AllArgsConstructor
public class CountryRestController {
    private final CountryService countryService;

    @GetMapping
    public List<Country> getAll(){
        return countryService.findAll();
    }

    @GetMapping("/search/{name}")
    public Country findByName(@PathVariable String name){
        return countryService.findByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        countryService.deleteById(id);
    }
}
