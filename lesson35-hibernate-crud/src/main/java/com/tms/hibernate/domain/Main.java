package com.tms.hibernate.domain;

import com.tms.hibernate.config.HibernateConfig;
import com.tms.hibernate.entity.TaskEntity;
import com.tms.hibernate.entity.UserEntity;
import com.tms.hibernate.service.TaskService;
import com.tms.hibernate.service.UserService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService service = new UserService();
        TaskService taskService = new TaskService();
        TaskEntity task1 = TaskEntity.builder()
                .header("fix problem")
                .description("fix problem in ... ")
                .status(Status.IN_PROGRESS)
                .build();



        TaskEntity task2 = TaskEntity.builder()
                .header("help with authorization")
                .description("help with authorization in... ")
                .status(Status.NEW)
                .build();

        TaskEntity task3 = TaskEntity.builder()
                .header("fill form")
                .description("fill form in main page... ")
                .status(Status.NEW)
                .build();

        TaskEntity task4 = TaskEntity.builder()
                .header("write email")
                .description("write email in... ")
                .status(Status.IN_PROGRESS)
                .build();


        UserEntity user1 = UserEntity.builder()
                .name("Ivan")
                .role(Role.SUPPORT)
                .birthday(LocalDate.of(1987, 8, 30))
                .isMan(true)
                .build();

        UserEntity user2 = UserEntity.builder()
                .name("Anna")
                .role(Role.USER)
                .birthday(LocalDate.of(1994, 11, 18))
                .isMan(false)
                .build();

        user1.addTask(task1);
        user1.addTask(task2);
        user2.addTask(task3);
        user2.addTask(task4);

        Integer savedUser1 = service.save(user1);
        Integer savedUser2 = service.save(user2);
        Integer savedTask1 = taskService.save(task1);
        Integer savedTask2 = taskService.save(task2);
        Integer savedTask3 = taskService.save(task3);
        Integer savedTask4 = taskService.save(task4);


        TaskEntity taskById1 = taskService.getTaskById(savedTask1);
        taskById1.setStatus(Status.DONE);
        taskService.update(taskById1);

        TaskEntity taskById3 = taskService.getTaskById(savedTask3);
        taskById3.setStatus(Status.IN_PROGRESS);
        taskService.update(taskById3);

        List<UserEntity> userWithActiveTasks = service.findUserWithActiveTasks();
        List<UserEntity> allUsers = service.getAllUsers();
        for (UserEntity user : allUsers) {
            taskService.deleteByUser(user);
            service.delete(user);
        }

    }
}
