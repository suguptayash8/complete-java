package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 *
 */
public class HighestEmployee {

    public static void main(String[] args){
        Employee e1 = new Employee(1, 70000);
        Employee e2 = new Employee(2, 50000);
        Employee e3 = new Employee(3, 90000);
        Employee e4 = new Employee(4, 200000);
        Employee e5 = new Employee(5, 30000);
        Employee e6 = new Employee(6, 40000);

        Employee emp = findThirdHisghest(Arrays.asList(e1, e2, e3, e4, e5, e6));
        System.out.println(emp);
    }
    public static Employee findThirdHisghest(List<Employee> employeeList ){
        Optional<Employee> emp = employeeList.stream().sorted((empA, empB)-> {
            return empA.getSalary() < empB.getSalary() ? 1 : -1;
        }).skip(2).findFirst();
        return emp.orElse(null);
    }
}


class  Employee {
    private int id;
    private int Salary;

    public Employee(int id, int salary) {
        this.id = id;
        Salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", Salary=" + Salary +
                '}';
    }
}