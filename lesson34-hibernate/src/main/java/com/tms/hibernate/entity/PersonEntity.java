package com.tms.hibernate.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "persons")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 1024)
    private String name;
    private LocalDate birthday;
    private boolean isCitizen;

    @OneToMany(mappedBy = "person")
    @ToString.Exclude
    private List<PhoneEntity> phones;

}
