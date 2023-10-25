package com.tms.hibernate.service;

import com.tms.hibernate.config.HibernateConfig;
import com.tms.hibernate.domain.Status;
import com.tms.hibernate.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserService {
    public Integer save(UserEntity user){
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        Integer saved = (Integer) session.save(user);

        transaction.commit();
        session.close();
        return saved;
    }

    public void update(UserEntity user){
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        session.update(user);

        transaction.commit();
        session.close();
    }
    public UserEntity getUserById(Integer userId){
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        UserEntity user = session.find(UserEntity.class, userId);
        System.out.println(user);
        transaction.commit();
        session.close();
        return user;
    }
    public List<UserEntity> getAllUsers(){
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        Query<UserEntity> query = session.createQuery("from UserEntity", UserEntity.class);
        List<UserEntity> list = query.list();
        list.forEach(System.out::println);
        transaction.commit();
        session.close();
        return list;
    }

    public void delete(UserEntity user){
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        session.delete(user);

        transaction.commit();
        session.close();
    }

    public List<UserEntity> findUserWithActiveTasks(){
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        Query<UserEntity> query = session.createQuery( "select u from UserEntity as u inner join u.tasks as t where t.status = ?1 or t.status = ?2 group by u.id", UserEntity.class);
        query.setParameter(1, Status.NEW);
        query.setParameter(2, Status.IN_PROGRESS);
        List<UserEntity> list = query.list();
        list.forEach(System.out::println);
        transaction.commit();
        session.close();
        return list;
    }



}
