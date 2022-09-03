package com.godoro.orm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeUpdate {
    public static void main(String[] args) {

        long employeeId=1;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Employee employee = manager.find(Employee.class, employeeId);
        employee.setEmployeeName("Taşkın Sabah");
        employee.setMonthlySalary(25442);

        manager.merge(employee);
        
        manager.getTransaction().commit();
        manager.close();
        factory.close();
        // close first use later (improves efficiency) (close when db's job is done, not the end)
        System.out.println(employee.getEmployeeId()+" "+employee.getEmployeeName()+ " "+ employee.getMonthlySalary());

    }
}
