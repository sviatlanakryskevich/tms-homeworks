package com.tms.hibernate.entity;

import com.tms.hibernate.domain.Operator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "phones")
public class PhoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 1024)
    private String number;
    @Enumerated(EnumType.STRING)
    private Operator operator;

    @ManyToOne
    private PersonEntity person;
}
