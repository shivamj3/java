class Employee {
    final int employeeID;               // Employee ID cannot be changed once assigned
    String name;   // Employee's name
    String employeetype;
    double baseSalary;                  
    static final double TAX_RATE = 0.02; // Tax rate as a constant

    // Constructor 
    public Employee(int employeeID, String employeetype,String name, double baseSalary) {
        this.employeeID = employeeID;
        this.name = name;
        this.baseSalary = baseSalary;
       this.employeetype=employeetype;
    }

    // Method to generate payslip
    public void generatePayslip(double totalSalary) {
        double taxDeduction = totalSalary * TAX_RATE; // Calculate tax deduction
        System.out.println("Employee ID: " + employeeID);
         System.out.println("Employee type: " + employeetype);
        System.out.println("Name: " + name);
        System.out.println("Total Salary after Tax: " + (totalSalary - taxDeduction)); // Display total salary after tax
        System.out.println("---------------");
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        // Array of employees with different types and base salaries
        Employee[] employees = {
            new Employee(101,"full-time", "TRUMP", 100000),    // Full-time
            new Employee(102,"part-time", "BIDEN", 50000),     // Part-time
            new Employee(103,"Contract" ,"BUSH", 25000)     // Contract
        };

        //  payroll for each employee using a loop
        for (Employee i : employees) {
            double totalSalary;
            if (i.baseSalary == 100000) {
                totalSalary =i.baseSalary * 1.25;  // 25% additional for full-time
            } else if (i.baseSalary == 50000) {
                totalSalary = i.baseSalary * 1.15;  // 15% additional for part-time
            } else {
                totalSalary = i.baseSalary * 1.05;  // 5% additional for contract
            }

            // Generating payslip for each employee
          i.generatePayslip(totalSalary);
        }
    }
}