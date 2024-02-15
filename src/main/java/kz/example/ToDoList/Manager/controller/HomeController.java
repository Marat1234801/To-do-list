package kz.example.ToDoList.Manager.controller;

import kz.example.ToDoList.Manager.model.Dto.CategoryDto;
import kz.example.ToDoList.Manager.model.entity.Category;
import kz.example.ToDoList.Manager.model.entity.Task;
import kz.example.ToDoList.Manager.model.entity.User;
import kz.example.ToDoList.Manager.service.CategoryService;
import kz.example.ToDoList.Manager.service.TaskService;
import kz.example.ToDoList.Manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    TaskService taskService;
    @Autowired
    UserService userService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/")
    public String mainPage() {
        return "home";
    }

    @GetMapping("/add-task")
    public String addTaskForm(Model model) {
        List<CategoryDto> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("now", LocalDateTime.now());
        return "add-task";
    }

    @PostMapping("/add-task")
    public String addTask(Task task) {
        task.setIsDone(false);
        taskService.addTask(task);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String findTaskById(@PathVariable Long id, Model model) {
        Task taskDto = taskService.getTaskById(id);
        List<CategoryDto> categories = categoryService.getAllCategories();
        if (taskDto == null)
            return "redirect:/";
        model.addAttribute("task", taskDto);
        model.addAttribute("categories", categories);
        return "task";
    }

    @PostMapping("/edit-task")
    public String editTask(Task task) {
        taskService.updateTask(task);
        return "redirect:/";
    }

    @GetMapping("/list-categories")
    public String categoriesPage() {
        return "categories";
    }

    @GetMapping("/add-category")
    public String addCategoryForm() {
        return "add-category";
    }

    @PostMapping("/add-category")
    public String addCategory(Category category) {
        categoryService.createCategory(category);
        return "redirect:/list-categories";
    }

    @GetMapping("/list-categories/{id}")
    public String categoryPage(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.findCategoryById(id));
        return "category";
    }

    @PostMapping("/edit-category")
    public String editCategory(Category category) {
        categoryService.updateCategory(category);
        return "redirect:/list-categories";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping("/register")
    public String createUser(User user, @RequestParam String rePassword) {
        userService.createUser(user, rePassword);
        return "redirect:/login";
    }
}
