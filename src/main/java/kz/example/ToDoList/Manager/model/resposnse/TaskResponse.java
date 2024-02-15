package kz.example.ToDoList.Manager.model.resposnse;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskResponse {
    private Long id;
    private String title;
    private LocalDateTime deadline;
    private Boolean isDone;
    private String categoryName;
}
