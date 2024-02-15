package kz.example.ToDoList.Manager.service;

import kz.example.ToDoList.Manager.model.Dto.CategoryDto;
import kz.example.ToDoList.Manager.model.entity.Category;
import kz.example.ToDoList.Manager.mapper.CategoryMapper;
import kz.example.ToDoList.Manager.repository.CategoryRepository;
import kz.example.ToDoList.Manager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TaskRepository taskRepository;
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryMapper.INSTANCE::toDto).toList();
    }

    public CategoryDto createCategory(Category category) {
        Category newCategory = categoryRepository.save(category);
        return CategoryMapper.INSTANCE.toDto(newCategory);
    }

    public CategoryDto deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        categoryRepository.deleteById(id);
        return CategoryMapper.INSTANCE.toDto(category);
    }

    public Category findCategoryById(Long id){
        return categoryRepository.findById(id).orElse(null);
    }

    public void updateCategory(Category newCategory) {
        Category category = categoryRepository.findById(newCategory.getId()).orElse(null);
        if(category == null){
            return;
        }
        newCategory.setTasks(category.getTasks());
        categoryRepository.save(newCategory);
    }
}
