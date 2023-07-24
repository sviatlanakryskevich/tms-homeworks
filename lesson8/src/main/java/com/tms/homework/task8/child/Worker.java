package com.tms.homework.task8.child;

import com.tms.homework.task8.Employee;
import com.tms.homework.task8.Position;

public class Worker extends Employee {
    public Worker(String firstName, String secondName, int seniority) {
        super(firstName, secondName, seniority, Position.WORKER);
    }



}
