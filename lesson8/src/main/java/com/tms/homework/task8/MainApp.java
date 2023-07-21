package com.tms.homework.task8;

import com.tms.homework.task8.child.Director;
import com.tms.homework.task8.child.Worker;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        Worker worker1 = new Worker("name1", "secondName1", 5);
        Worker worker2 = new Worker("name2", "secondName2", 8);
        Worker worker3 = new Worker("name3", "secondName3", 2);
        Director director1 = new Director("name4", "secondName4", 15);
        Employee[] employees = {worker1, worker2, worker3, director1};
        for(Employee employee : employees){
            System.out.println(employee.toString());
        }
        director1.addEmployee(worker1);
        director1.addEmployee(worker2);
        System.out.println(director1.toString());
        Director director2 = new Director("name5", "secondName5", 7);
        director2.addEmployee(worker3);
        director1.addEmployee(director2);
        System.out.println(director1.toString());
        EmployeeService service = new EmployeeService();
        System.out.println(service.findEmployee("name3", director1));
        System.out.println(service.findEmployee("name6", director1));
    }
}
