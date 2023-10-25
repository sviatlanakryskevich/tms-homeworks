package com.tms.hibernate.service;

import com.tms.hibernate.config.HibernateConfig;
import com.tms.hibernate.entity.TaskEntity;
import com.tms.hibernate.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    public void deleteByUser(UserEntity user) {
        List<TaskEntity> tasksByUser = getTasksByUser(user);
        for (TaskEntity taskEntity : tasksByUser) {
            delete(taskEntity);
        }
    }
    public List<TaskEntity> getTasksByUser(UserEntity user){
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        List<TaskEntity> tasks = user.getTasks();
        System.out.println(tasks);
        transaction.commit();
        session.close();
        return tasks;
    }

}
