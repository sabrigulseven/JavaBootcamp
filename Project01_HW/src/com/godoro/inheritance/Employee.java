package com.godoro.inheritance;

public class Employee extends Person {

    private long employeeId;
    private double monthlySalary;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public Employee(long employeeId, String firstName, String lastName, double monthlySalary) {
        super(firstName, lastName);
        this.employeeId = employeeId;
        this.monthlySalary = monthlySalary;
    }
    public Employee() {

    }
    
	@Override
	public String getGreeting() {
		return "Merhaba";
	}    
}
