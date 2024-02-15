package kz.example.ToDoList.Manager.mapper.Impl;

import kz.example.ToDoList.Manager.mapper.TaskRequestMapper;
import kz.example.ToDoList.Manager.model.entity.Task;
import kz.example.ToDoList.Manager.model.request.TaskRequest;


public class TaskRequestMapperImpl implements TaskRequestMapper {

    @Override
    public Task mapDtoToEntity(TaskRequest dto) {
        if (dto == null) {
            return null;
        }
        Task task = new Task();

        task.setTitle(dto.getTitle());
        task.setDeadline(dto.getDeadline());
        task.setIsDone(dto.getIsDone());
        return task;
    }
}

