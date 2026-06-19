public class Exercise4_EmployeeManagement {
    static class Employee {
        int employeeId;
        String name;
        String position;
        double salary;

        Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return employeeId + " - " + name + " - " + position + " - Rs." + salary;
        }
    }

    private final Employee[] employees;
    private int size;

    public Exercise4_EmployeeManagement(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public boolean addEmployee(Employee employee) {
        if (size == employees.length) {
            return false;
        }
        employees[size] = employee;
        size++;
        return true;
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public boolean deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void main(String[] args) {
        Exercise4_EmployeeManagement system = new Exercise4_EmployeeManagement(5);
        system.addEmployee(new Employee(1, "Asha", "Developer", 65000));
        system.addEmployee(new Employee(2, "Vikram", "Tester", 52000));
        system.addEmployee(new Employee(3, "Neha", "Manager", 85000));

        System.out.println("Employees:");
        system.traverseEmployees();
        System.out.println("Search ID 2: " + system.searchEmployee(2));
        System.out.println("Delete ID 1: " + system.deleteEmployee(1));
        system.traverseEmployees();

        System.out.println("\nComplexity:");
        System.out.println("Add is O(1) when space is available. Search, traverse, and delete are O(n).");
    }
}
