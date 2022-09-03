package com.godoro.orm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeInsert {
    public static void main(String[] args) {
        Employee employee = new Employee(0,"Adnan şenses", 2116);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        manager.persist(employee);

        manager.getTransaction().commit();
        manager.close();
        factory.close();
        System.out.println("Özdeşlik: " + employee.getEmployeeId());
    }
}
