package com.godoro.composition.test;

import java.util.List;

import com.godoro.composition.entity.Employee;
import com.godoro.composition.manager.EmployeeManager;

public class TestEmployeeList {
    public static void main(String[] args) throws Exception {
        EmployeeManager employeeManager = new EmployeeManager();
        List<Employee> employeeList = employeeManager.list();
        for (Employee employee : employeeList) {
            System.out.println(employee.getEmployeeid() + " "
            +employee.getEmployeeName()+ " "
            +employee.getMonthlySalary());
        }
    }
    
}
