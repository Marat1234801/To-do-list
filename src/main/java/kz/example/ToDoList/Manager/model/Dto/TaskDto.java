package kz.example.ToDoList.Manager.model.Dto;

import kz.example.ToDoList.Manager.model.entity.Category;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto {
    private Long id;
    private String title;
    private LocalDateTime deadline;
    private Boolean isDone;
    private Category category;
}
