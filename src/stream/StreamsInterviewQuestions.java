package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class StreamsInterviewQuestions {
    public static void main(String[] args) {
        StreamsInterviewQuestions streamsTest = new StreamsInterviewQuestions();
        streamsTest.solution();
    }

 

    private void solution() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("AAA",111,"D1",1000));
        employees.add(new Employee("BBB",222,null,2000));
        employees.add(new Employee("CCC",333,"D2",3000));
        employees.add(new Employee("DDD",444,"D3",4000));
        employees.add(new Employee("EEE",555,"D2",5000));
        employees.add(new Employee("FFF",666,"D2",6000));

 

        System.out.println(employees);
        //TODO print employee names belongs to dept "D2" -  using streams functions

        employees.stream().filter(employee -> "D2".equals(employee.getDeptno()))
                .forEach(employee -> System.out.println(employee.getName()));

 


        //TODO Print the sum of all employees salaries using streams -  expected to print 21000
        int sum = employees.stream().map(employee -> employee.getSalary()).reduce(0, (acc, curr)-> acc + curr);
        System.out.println(sum);
 


        //TODO Given a sentence find the word that has the highest length using Streams. expected to print "Welcome"
        String  input = " Welcome to Java world";

        String largest = Arrays.stream(input.split(" ")).sorted((wordA, wordB)-> wordA.length() < wordB.length() ? +1 : -1).findFirst().get();

        System.out.println(largest);
 

 

        //TODO Should print most repeated number from the array, using streams or Java 7 features... 
        // number 5 repeated most of the (3)times, Should print 5 and not 3
        int arr[] = {5, 7, 5, 7, 5, 2};

         Map<Integer, Integer> freqMap =  Arrays.stream(arr).boxed().collect(Collectors.toMap(num -> num, num -> 1, (old, curr) -> old + curr));
         Optional<Map.Entry<Integer, Integer>> maxFreq = freqMap.entrySet().stream().max((setA, setB)-> setA.getValue() > setB.getValue() ? 1 : -1);
         System.out.println(maxFreq.orElse(new AbstractMap.SimpleEntry<>(-1, -1)).getKey());

        /*Map<Integer, List<Integer>> numCount = Arrays.stream(arr).map(obj-> Integer.valueOf(obj))
                .collect(Collectors.groupingBy(num -> num));*/


        List<String> inp = Arrays.asList("Eat", "eTa", "Tan", "ate", "nat", "bat");

        List<List<String>> sol =
                inp.stream().collect(Collectors.groupingBy((wrd) -> {
                    String word = wrd.toLowerCase();
                    char[] ar = word.toCharArray();
                    Arrays.sort(ar);
                    String str = "";
                    for (char c : ar) {
                        str = str + c;
                    }

                    return str;
                })).values().stream().sorted((listA, listB) -> listA.size() < listB.size() ? 1 : -1).collect(Collectors.toList());


        /**
         * Remove same continous elements from list by stream
         *
         *
         */

        List<Integer> nums = Arrays.asList(1,1,1,2,1);

        List<Integer> solun = new ArrayList<>();

        IntStream.range(0, inp.size()).forEach((index) -> {
            if(sol.size() <= 0 || solun.get(solun.size()-1) != nums.get(index)){
                solun.add(nums.get(index));
            }
        });

        System.out.println(solun);

        //Optional example
        Optional<List<Employee>> emps = Optional.ofNullable(employees);
        if(emps.isEmpty()){
            throw new RuntimeException();
        }else{
            processEmp(employees);
        }

 


    }
    private void processEmp(List<Employee> employees) {

    }
 private class Employee {

 

        private String name;
        private int id;
        private String deptno;
        private int salary;
        private List<String> addresses;


     public Employee(String name, int id, String deptno, int salary) {
         this.name = name;
         this.id = id;
         this.deptno = deptno;
         this.salary = salary;
     }

     @Override
        public String toString() {
            return name + "::" + id + "::" + deptno + "::" + salary;
        }

 

        public String getName() {
            return name;
        }

 

        public int getId() {
            return id;
        }

 

        public String getDeptno() {
            return deptno;
        }

 

        public int getSalary() {
            return salary;
        }

 

    }
}

 