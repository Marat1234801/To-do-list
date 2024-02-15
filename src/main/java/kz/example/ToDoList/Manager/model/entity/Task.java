package kz.example.ToDoList.Manager.model.entity;

import jakarta.persistence.*;
import kz.example.ToDoList.Manager.model.entity.main.BaseEntity;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TASKS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task extends BaseEntity {
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "deadline", nullable = false)

    private LocalDateTime deadline;

    @Column(name = "is_done", nullable = false)
    private Boolean isDone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;
}
