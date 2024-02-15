package kz.example.ToDoList.Manager.controller;

import kz.example.ToDoList.Manager.model.Dto.TaskDto;
import kz.example.ToDoList.Manager.model.entity.Task;
import kz.example.ToDoList.Manager.model.request.TaskRequest;
import kz.example.ToDoList.Manager.model.resposnse.TaskResponse;
import kz.example.ToDoList.Manager.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    private List<TaskResponse> getTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/add-task")
    private TaskResponse addTask(@RequestBody TaskRequest task) {
        return taskService.addTask(task);
    }

    @DeleteMapping("/delete/{id}")
    private TaskResponse deleteTask(@PathVariable Long id) {
        return taskService.deleteTask(id);
    }

    @GetMapping("/{id}")
    private TaskResponse findTaskById(@PathVariable Long id) {
        return taskService.findTaskById(id);
    }

    @GetMapping("/search/{search}")
    private List<TaskResponse> searchTaskByTitle(@PathVariable String search) {
        return taskService.findTaskByTitle(search);
    }
}
