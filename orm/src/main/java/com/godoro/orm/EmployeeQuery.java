package com.godoro.orm;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class EmployeeQuery {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager manager = factory.createEntityManager();

        String jpql = "select e from Employee e";
        TypedQuery<Employee> query = manager.createQuery(jpql,Employee.class);
        List<Employee> employeeList = query.getResultList();
        
        manager.close();
        factory.close();
        // close first use later (improves efficiency) (close when db's job is done, not the end)

        for (Employee employee : employeeList) {
            System.out.println(employee.getEmployeeId()+" "+employee.getEmployeeName()+ " "+ employee.getMonthlySalary());

        }
    }
}
