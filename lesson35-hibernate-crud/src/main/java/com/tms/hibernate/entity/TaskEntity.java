package com.tms.hibernate.entity;

import com.tms.hibernate.domain.Status;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String header;
    @Column(length = 1024)
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @ToString.Exclude
    private UserEntity user;
}
