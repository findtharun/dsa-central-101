package Sorting;

import java.util.*;

class Employee {
    public int salary;
    public String name;
    public int age;

    public Employee(int salary, String name, int age) {
        this.salary = salary;
        this.name = name;
        this.age = age;
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

// We are using Comparator Object
public class ComparatorSort {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(2, "John Doe", 23));
        employees.add(new Employee(1, "Jane Smith", 23));
        employees.add(new Employee(4, "Alice Johnson", 45));

        // Approach 1 : Using Comparator Object
        Comparator<Employee> com = new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                if (e1.age == e2.age) {
                    return e1.salary - e2.salary;
                }
                return e1.age - e2.age;
            }
        };

        Collections.sort(employees, com);
        System.out.println(employees);
    };
    // Approach 2 : We can use Lambda Function as well
    // Collections.sort(inputList, (a, b) -> (getSum(a) - getSum(b)));
}
