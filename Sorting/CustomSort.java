package Sorting;
import java.util.*;

class Employee implements Comparable<Employee> {
    private int salary;
    private String name;
    private int age;

    public Employee(int salary, String name,int age) {
        this.salary = salary;
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Employee employee){
        if(age == employee.age){
           return salary - employee.salary;
        }
        return age - employee.age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", name='" + name +  
                ", age='" + age + 
                '}';
    }
}

public class CustomSort {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(200000, "John Doe",23));
        employees.add(new Employee(100000, "Jane Smith",23));
        employees.add(new Employee(400000, "Alice Johnson",45));

        System.out.println("Before sorting:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Collections.sort(employees); // Sorting using the natural order defined in compareTo

        System.out.println("\nAfter sorting:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
