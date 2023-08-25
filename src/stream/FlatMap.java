package stream;


import utils.Student;

import java.util.*;

public class FlatMap {

    public static void main(String []args){
        //getStatisticWIthFlatMap();
        System.out.println( "1. " +getTotalMarks(Optional.of("Ajay")));
        System.out.println( "2. " +getTotalMarks(Optional.empty()));
        getTotalMarks(Optional.empty());

        System.out.println( "3. " + getTotalMarksByString(null));
        System.out.println( "4. " + getTotalMarksByString("Kamal"));


        System.out.println( "5. " + getTotalMarksByString("Shubham"));


    }

    public static int getTotalMarks(Optional<String> name){
        return name.map((nam) -> {
            return Student.mockStudentList().orElse(new ArrayList<>()).stream()
                    .filter(student -> student.getName().equals(nam))
                    .flatMap((student -> student.getMarks().stream()))
                    .reduce(0, (numA, numB)-> numA + numB);
        }).orElse(-1);
    }

    public static int getTotalMarksByString(String name){
        if(name == null){
           return -1;
        }

        return Student.mockStudentList().orElse(new ArrayList<>()).stream()
                .filter(student -> student.getName().equals(name))
                .flatMap((student -> student.getMarks().stream()))
                .reduce(0, (numA, numB)-> numA + numB);
    }
    public static void getStatisticWIthFlatMap(){
        DoubleSummaryStatistics summaryStatistics = Student.mockStudentList().orElse(new ArrayList<>()).stream().
                filter(student -> "Shubham".equals(student.getName())).flatMap(student -> student.getMarks().stream())
                .mapToDouble(mrk-> Double.valueOf(mrk)).summaryStatistics();
        System.out.println(summaryStatistics);
    }

}

