package lab2.web.rest;

import lab2.model.dto.CategoryDto;
import lab2.model.enumerations.CategoryStatus;
import lab2.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoryRestController {
    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryStatus> findAll() {
        return this.categoryService.listCategories();
    }
}
