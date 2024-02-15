package kz.example.ToDoList.Manager.mapper.Impl;

import kz.example.ToDoList.Manager.mapper.TaskResponseMapper;
import kz.example.ToDoList.Manager.model.entity.Task;
import kz.example.ToDoList.Manager.model.resposnse.TaskResponse;


public class TaskResponseMapperImpl implements TaskResponseMapper {
    @Override
    public TaskResponse toDto(Task entity) {
        if (entity == null) {
            return null;
        }

        TaskResponse taskResponse = new TaskResponse();

        taskResponse.setId(entity.getId());
        taskResponse.setTitle(entity.getTitle());
        taskResponse.setDeadline(entity.getDeadline());
        taskResponse.setIsDone(entity.getIsDone());
        taskResponse.setCategoryName(entity.getCategory().getName());
        return taskResponse;
    }

}

