package kz.example.ToDoList.Manager.repository;

import kz.example.ToDoList.Manager.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t " +
            "WHERE t.title ilike concat('%', :search, '%') " +
            "OR t.category.name ilike  concat('%', :search, '%') ")
    List<Task> findTasksBySearch(String search);
}
