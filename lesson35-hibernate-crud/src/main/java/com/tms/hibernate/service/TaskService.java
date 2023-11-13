package com.tms.hibernate.service;

import com.tms.hibernate.config.HibernateConfig;
import com.tms.hibernate.domain.Status;
import com.tms.hibernate.entity.TaskEntity;
import com.tms.hibernate.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TaskService {
    public Integer save(TaskEntity task){
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        Integer saved = (Integer) session.save(task);

        transaction.commit();
        session.close();
        return saved;
    }
    public void update(TaskEntity task){
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        session.update(task);

        transaction.commit();
        session.close();
    }
    public TaskEntity getTaskById(Integer taskId){
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        TaskEntity task = session.find(TaskEntity.class, taskId);
        System.out.println(task);
        transaction.commit();
        session.close();
        return task;
    }
    public void delete(TaskEntity task){
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        session.delete(task);

        transaction.commit();
        session.close();
    }

    public void deleteByUser(Integer userId) {
        List<TaskEntity> tasksByUser = getTasksByUser(userId);
        for (TaskEntity taskEntity : tasksByUser) {
            delete(taskEntity);
        }
    }
    public List<TaskEntity> getTasksByUser(Integer userId){
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();
        Query<TaskEntity> query = session.createQuery( "select t from TaskEntity as t where user.id = ?1", TaskEntity.class);
        query.setParameter(1, userId);
        List<TaskEntity> tasks = query.list();
        System.out.println(tasks);
        transaction.commit();
        session.close();
        return tasks;
    }

}
