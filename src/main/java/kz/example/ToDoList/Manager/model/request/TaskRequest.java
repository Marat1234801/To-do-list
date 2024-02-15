package kz.example.ToDoList.Manager.model.request;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskRequest {
    private Long id;
    private String title;
    private LocalDateTime deadline;
    private Boolean isDone;
    private Long categoryId;
}
