package com.godoro.orm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeDelete {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager manager = factory.createEntityManager();
        long employeeId=1;
        Employee employee = manager.find(Employee.class, employeeId);
        
        manager.getTransaction().begin();
        manager.remove(employee);
        manager.getTransaction().commit();

        manager.close();
        factory.close();
        // close first use later (improves efficiency) (close when db's job is done, not the end)
        System.out.println(employee.getEmployeeId()+" "+employee.getEmployeeName()+ " "+ employee.getMonthlySalary());
    }
}
