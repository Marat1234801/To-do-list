package kz.example.ToDoList.Manager.service;

import kz.example.ToDoList.Manager.model.entity.User;
import kz.example.ToDoList.Manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getCurrentUser(){
        var currentUser = SecurityContextHolder.getContext().getAuthentication();
        return (User) currentUser.getPrincipal();
    }
    public void createUser(User newUser, String rePassword) {
        User user = userRepository.findUserByUsername(newUser.getUsername());
        if(user != null) {
            return;
        }
        if(!newUser.getPassword().equals(rePassword)){
            return;
        }
        newUser.setPassword(passwordEncoder.encode(rePassword));
        userRepository.save(newUser);
    }
}
