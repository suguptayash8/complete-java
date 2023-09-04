package interview.ignore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * List<Employee> from that get department wise head count and employee name in desc order
 *
 * {departmentName:,
 * headCount:
 * empName: desc
 * }
 */
public class CodinProb {

    public static void main(String[]args){
        Employee e1 = new Employee("nameA", "A", "depA");
        Employee e2 = new Employee("nameB", "B", "depA");
        Employee e3 = new Employee("nameC", "C", "depB");
        Employee e4 = new Employee("nameD", "D", "depA");
        Employee e5 = new Employee("nameE", "E", "depC");

        List<Employee> employeeList = Arrays.asList(e1, e2, e3, e4, e5);

        Map<String, Integer> employeCount =  employeeList.stream()
                .collect(Collectors.toMap(emp-> emp.department, emp -> 1, (curr, val) -> curr + val));

        //System.out.println(employeCount);

        //employeeList.stream().sorted((empA, empB)-> empB.name.compareTo(empA.name)).forEach(System.out::println);

        employeeList.stream().collect(Collectors.groupingBy(employee -> employee.department))
                .entrySet().stream().map(stringListEntry -> {
                    return "departmentName: " + stringListEntry.getKey() +
                            " employeCount: " + stringListEntry.getValue().size() +
                            " employees: " + stringListEntry.getValue().stream().sorted((empA, empB)-> empB.name.compareTo(empA.name))
                            .map(employee -> employee.name).collect(Collectors.toList()) + "\n";
                }).forEach(System.out::println);
        int []nums = {-2,1,-3,4,-1,2,1,-5,4};
        //largestSumSubArray(nums).stream().forEach(System.out::println);


    }

    /**
     * nput: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * nput: nums = [-2,-1,-3,4,-1,2,1,-5,4]
     *
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     */
    public static List<Integer> largestSumSubArray(int[] nums){
        List<Integer> sol = new ArrayList<>();

        int i = 0, j = 0;
        while( i < nums.length){
            int maxSum = 0;
            List<Integer> localSol = new ArrayList<>();
            if(nums[i] > 0){
                int sum = 0;
                j = i;
                while (maxSum > 0 && j < nums.length){
                    sum = sum + nums[j];
                    j++;
                    localSol.add(nums[j]);

                    if(sum > maxSum){
                        sol.clear();
                        sol.addAll(localSol);
                    }
                }
                i = j + 1;
            }
        }
        return sol;
    }
}


class Employee {
    String name;
    String id;

    String department;

    public Employee(String name, String id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}