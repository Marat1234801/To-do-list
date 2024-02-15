package kz.example.ToDoList.Manager.mapper;

import kz.example.ToDoList.Manager.mapper.Impl.TaskRequestMapperImpl;
import kz.example.ToDoList.Manager.model.entity.Task;
import kz.example.ToDoList.Manager.model.request.TaskRequest;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true))
public interface TaskRequestMapper {
    TaskRequestMapper INSTANCE = new TaskRequestMapperImpl();

    Task mapDtoToEntity(TaskRequest dto);
}
