package kz.example.ToDoList.Manager.repository;

import kz.example.ToDoList.Manager.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
