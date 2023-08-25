package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Student {
    String name;
    List<Integer> marks;

    Student(String name, List<Integer> marks){
        this.name  = name;
        this.marks = marks;
    }

    public static Optional<List<Student>> mockStudentList(){
        List<Integer> marksOfA = Arrays.asList(60, 80, 90, 95, 70, 71);
        Student A = new Student("Shubham", marksOfA);

        List<Integer> marksOfB = Arrays.asList(65, 85, 95, 95, 70, 78);
        Student B = new Student("Shubham", marksOfB);

        List<Integer> marksOfC = Arrays.asList(55, 75, 85, 85, 60, 68);
        Student C = new Student("Kamal", marksOfC);

        List<Integer> marksOfD = Arrays.asList(55, 65, 75, 55, 60, 68);
        Student D = new Student("Satyam",  marksOfD);

        List<Integer> marksOfE = Arrays.asList(85, 95, 95, 55, 80, 98);
        Student E = new Student("Satyam", marksOfE);

        List<Integer> marksOfF = Arrays.asList(75, 75, 75, 65, 70, 78);
        Student F = new Student("Ajay", marksOfF);

        return Optional.of(Arrays.asList(A,B,C,D,E,F));

        //return Optional.empty();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", totalMarks=" + this.getMarks().stream().reduce(0, (a,b) -> a+b) +
                '}';
    }
}
