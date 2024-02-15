package kz.example.ToDoList.Manager.controller;

import kz.example.ToDoList.Manager.model.Dto.CategoryDto;
import kz.example.ToDoList.Manager.model.entity.Category;
import kz.example.ToDoList.Manager.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
    final private CategoryService categoryService;

    @GetMapping
    private List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/add-category")
    private CategoryDto createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @DeleteMapping("/delete-category/{id}")
    private CategoryDto deleteCategory(@PathVariable Long id) {
        return categoryService.deleteCategory(id);
    }
}
