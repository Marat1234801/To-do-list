package kz.example.ToDoList.Manager.service;

import kz.example.ToDoList.Manager.mapper.TaskRequestMapper;
import kz.example.ToDoList.Manager.mapper.TaskResponseMapper;
import kz.example.ToDoList.Manager.mapper.TaskResponseMapperImpl;
import kz.example.ToDoList.Manager.model.entity.Category;
import kz.example.ToDoList.Manager.model.entity.Task;
import kz.example.ToDoList.Manager.model.request.TaskRequest;
import kz.example.ToDoList.Manager.model.resposnse.TaskResponse;
import kz.example.ToDoList.Manager.repository.CategoryRepository;
import kz.example.ToDoList.Manager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<TaskResponse> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks
                .stream()
                .map(TaskResponseMapper.INSTANCE::toDto)
                .toList();
    }

    public TaskResponse addTask(TaskRequest taskRequest) {
        Category category = categoryRepository.findById(taskRequest.getCategoryId()).orElse(null);
        if (category == null) {
            return null;
        }
        Task task = TaskRequestMapper.INSTANCE.mapDtoToEntity(taskRequest);
        task.setCategory(category);
        taskRepository.save(task);
        return TaskResponseMapper.INSTANCE.toDto(task);
    }

    public void addTask(Task task) {
        if (task.getCategory() == null) {
            return;
        }
        taskRepository.save(task);
    }

    public TaskResponse deleteTask(Long id) {
        if (findTaskById(id) == null) {
            return null;
        }
        TaskResponse taskResponse = findTaskById(id);
        taskRepository.deleteById(id);
        return taskResponse;
    }

    public TaskResponse findTaskById(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) {
            return null;
        }
        return TaskResponseMapperImpl.INSTANCE.toDto(task);
    }

    public Task getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        return task;
    }

    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    public List<TaskResponse> findTaskByTitle(String search) {
        List<Task> tasks = taskRepository.findTasksBySearch(search);
        return tasks.stream().map(TaskResponseMapper.INSTANCE::toDto).toList();
    }
}
