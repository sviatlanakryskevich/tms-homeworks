package com.tms.homework.task8;

import com.tms.homework.task8.child.Director;

public class EmployeeService {
    public boolean findEmployee(String name, Director director) {
        Employee[] employeeList = director.employeeList;
        for (int i = 0; i < employeeList.length; i++) {
            Employee employee = employeeList[i];
            if (employee != null && employee.getFirstName().equals(name)) {
                return true;
            } else if (employee != null && employee.getPosition().equals(Position.DIRECTOR)) {
                return findEmployee(name, (Director) employee);
            }
        }
        return false;
    }
}
