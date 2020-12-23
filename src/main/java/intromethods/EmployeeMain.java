package intromethods;

public class EmployeeMain {

    public static void main(String[] args) {

        Employee employee = new Employee("John Doe", 1980, 300000);

        System.out.println(employee.getName());
        System.out.println(employee.getHiringYear());
        System.out.println(employee.getSalary());
        System.out.println(employee);

        employee.setName("dr. John Doe");
        System.out.println(employee.getName());

        employee.raiseSalary(100000);
        System.out.println(employee.getSalary());

        System.out.println(employee);
    }
}
