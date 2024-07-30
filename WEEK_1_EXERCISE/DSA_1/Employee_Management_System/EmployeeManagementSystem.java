package DSA_1.Employee_Management_System;

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int size) {
        employees = new Employee[size];
        count = 0;
    }

    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count++] = employee;
        } else {
            System.out.println("Employee array is full. Cannot add more employees.");
        }
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(int employeeId) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < count - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[count - 1] = null;
            count--;
        } else {
            System.out.println("Employee not found.");
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem(5);

        Employee e1 = new Employee(1, "John Doe", "Manager", 75000);
        Employee e2 = new Employee(2, "Jane Smith", "Developer", 60000);
        Employee e3 = new Employee(3, "Emily Davis", "Designer", 55000);

        system.addEmployee(e1);
        system.addEmployee(e2);
        system.addEmployee(e3);

        System.out.println("All Employees:");
        system.traverseEmployees();

        System.out.println("\nSearch for employee with ID 2:");
        System.out.println(system.searchEmployee(2));

        System.out.println("\nDeleting employee with ID 1:");
        system.deleteEmployee(1);

        System.out.println("\nAll Employees after deletion:");
        system.traverseEmployees();
    }
}
