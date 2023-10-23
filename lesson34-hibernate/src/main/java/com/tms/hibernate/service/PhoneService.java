package com.tms.hibernate.service;

import com.tms.hibernate.config.HibernateConfig;
import com.tms.hibernate.domain.Operator;
import com.tms.hibernate.entity.PersonEntity;
import com.tms.hibernate.entity.PhoneEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;

public class PhoneService {
    public Integer save(PhoneEntity phone){
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        Integer saved = (Integer) session.save(phone);

        transaction.commit();
        session.close();
        return saved;
    }
    public Integer save(PersonEntity person){
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        Integer saved = (Integer) session.save(person);

        transaction.commit();
        session.close();
        return saved;
    }
    public PersonEntity getPersonById(Integer personId){
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        PersonEntity person = session.find(PersonEntity.class, personId);
        System.out.println(person);
        transaction.commit();
        session.close();
        return person;
    }
    public PhoneEntity getPhoneById(Integer phoneId){
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        PhoneEntity phone = session.find(PhoneEntity.class, phoneId);
        System.out.println(phone);
        phone.setOperator(Operator.LIFE);
        System.out.println(phone);
        transaction.commit();
        session.close();
        return phone;
    }
}
