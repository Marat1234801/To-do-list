package kz.example.ToDoList.Manager.mapper;

import kz.example.ToDoList.Manager.mapper.Impl.TaskResponseMapperImpl;
import kz.example.ToDoList.Manager.model.entity.Task;
import kz.example.ToDoList.Manager.model.resposnse.TaskResponse;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true))
public interface TaskResponseMapper {
    TaskResponseMapper INSTANCE = new TaskResponseMapperImpl();

    TaskResponse toDto(Task entity);

}
