package com.godoro.composition;

public class Employee {
    private long employeeid;
    private String employeeName;
    private double monthlySalary;
    private Department department;
    public Employee() {
    }

    public Employee(long employeeid, String employeeName, double monthlySalary) {
        this.employeeid = employeeid;
        this.employeeName = employeeName;
        this.monthlySalary = monthlySalary;
    }

    public long getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(long employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

}
