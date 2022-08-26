package com.godoro.composition.test;

import com.godoro.composition.entity.Employee;
import com.godoro.composition.manager.EmployeeManager;

public class TestEmployeeFind {
    public static void main(String[] args) throws Exception {
        EmployeeManager employeeManager = new EmployeeManager();
        Employee e = employeeManager.find(2);
        System.out.println(e.getEmployeeName());
    }
}
