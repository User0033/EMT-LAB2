package lab2.service.impl;

import lab2.model.enumerations.CategoryStatus;
import lab2.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    public CategoryServiceImpl() {

    }

    @Override
    public List<CategoryStatus> listCategories() {
        return List.of(CategoryStatus.values());
    }

}
