package kz.example.ToDoList.Manager.mapper;

import kz.example.ToDoList.Manager.model.Dto.TaskDto;
import kz.example.ToDoList.Manager.model.entity.Task;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDto toDto(Task entity);
}
