package com.tms.hibernate.domain;

import com.tms.hibernate.config.HibernateConfig;
import com.tms.hibernate.entity.PersonEntity;
import com.tms.hibernate.entity.PhoneEntity;
import com.tms.hibernate.service.PhoneService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hibernate.boot.model.process.spi.MetadataBuildingProcess.build;

public class Main {
    public static void main(String[] args) {
        PhoneService service = new PhoneService();
        PersonEntity person = PersonEntity.builder()
                .name("Ivan")
                .birthday(LocalDate.of(1995,4, 11))
                .isCitizen(true)
                .build();
        Integer savedPerson = service.save(person);
        PhoneEntity phone1 = PhoneEntity.builder()
                .number("+37533 378-47-33")
                .operator(Operator.MTC)
                .person(person)
                .build();
        Integer savedPhone1 = service.save(phone1);
        PhoneEntity phone2 = PhoneEntity.builder()
                .number("+37529 567-40-21")
                .operator(Operator.A1)
                .person(person)
                .build();
        Integer savedPhone2 = service.save(phone2);



        PhoneEntity phoneById1 = service.getPhoneById(savedPhone1);
        PhoneEntity phoneById2 = service.getPhoneById(savedPhone2);
        PersonEntity personById = service.getPersonById(savedPerson);
    }
}
