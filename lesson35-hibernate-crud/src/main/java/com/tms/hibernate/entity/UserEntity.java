package com.tms.hibernate.entity;

import com.tms.hibernate.domain.Role;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Role role;
    private LocalDate birthday;
    private boolean isMan;

    @OneToMany(mappedBy = "user")
    private List<TaskEntity> tasks;

    public void addTask(TaskEntity task){
        if(tasks == null){
            tasks = new ArrayList<>();
        }
        tasks.add(task);
        task.setUser(this);
    }
}
