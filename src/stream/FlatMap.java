package stream;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class FlatMap {

    public static void main(String []args){
        getStatisticWIthFlatMap();
    }

    public static void getStatisticWIthFlatMap(){
        DoubleSummaryStatistics summaryStatistics = buildMockStudents().stream().
                filter(student -> "3".equals(student.studentId)).flatMap(student -> student.marks.stream())
                .mapToDouble(mrk-> Double.valueOf(mrk)).summaryStatistics();
        System.out.println(summaryStatistics);
    }
   public static List<Student> buildMockStudents(){
       List<Integer> marksOfA = Arrays.asList(100,80,70,50,70,90);
       Student studentA = new Student("1",marksOfA);

       List<Integer> marksOfB = Arrays.asList(100,60,70,60,70,80);
       Student studentB = new Student("2",marksOfB);

       List<Integer> marksOfC = Arrays.asList(100,60,70,60,70,90);
       Student studentC = new Student("3",marksOfC);
       List<Student> students = Arrays.asList(studentA, studentB, studentC);

       return students;
   }

}


class Student {
    String studentId;

    List<Integer> marks;

    public Student(String studentId, List<Integer> marks) {
        this.studentId = studentId;
        this.marks = marks;
    }
}