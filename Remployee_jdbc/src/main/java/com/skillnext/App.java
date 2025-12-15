package com.skillnext;

public class App {
    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAO();

        // Example: Insert employee
        Employee emp = new Employee();
        emp.setName("John");
        emp.setEmail("john@example.com");
        emp.setSalary(50000);

        dao.addEmployee(emp);

        System.out.println("Employee inserted!");

        // Example: Fetch all employees
        System.out.println(dao.getAllEmployees());
    }
}

