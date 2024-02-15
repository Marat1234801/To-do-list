package kz.example.ToDoList.Manager.model.entity;

import jakarta.persistence.*;
import kz.example.ToDoList.Manager.model.entity.main.BaseEntity;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "CATEGORIES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category extends BaseEntity {
    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private List<Task> tasks;
}
