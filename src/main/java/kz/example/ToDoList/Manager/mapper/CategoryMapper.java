package kz.example.ToDoList.Manager.mapper;

import kz.example.ToDoList.Manager.model.Dto.CategoryDto;
import kz.example.ToDoList.Manager.model.entity.Category;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto toDto(Category entity);
}
