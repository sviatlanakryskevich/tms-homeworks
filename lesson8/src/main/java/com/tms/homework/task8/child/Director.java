package com.tms.homework.task8.child;

import com.tms.homework.task8.Employee;
import com.tms.homework.task8.Position;

import java.util.Arrays;

public class Director extends Employee {
    public Employee[] employeeList = new Employee[5];

    public Director(String firstName, String secondName, int seniority) {
        super(firstName, secondName, seniority, Position.DIRECTOR);
    }

    public void addEmployee(Employee employee) {
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] == null) {
                employeeList[i] = employee;
                break;
            }
        }
    }

    @Override
    public int calculateSalary() {
        int salary = super.calculateSalary();
        if (employeeList != null && employeeList.length > 0) {
            salary = salary * employeeList.length;
        }
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + "; EmployeeList: " + Arrays.toString(employeeList);
    }
}
