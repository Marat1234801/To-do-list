package kz.example.ToDoList.Manager.repository;

import kz.example.ToDoList.Manager.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);
}
