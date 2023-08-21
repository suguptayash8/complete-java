package stream;


import utils.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class FlatMap {

    public static void main(String []args){
        getStatisticWIthFlatMap();
    }

    public static void getStatisticWIthFlatMap(){
        DoubleSummaryStatistics summaryStatistics = Student.mockStudentList().orElse(new ArrayList<>()).stream().
                filter(student -> "Shubham".equals(student.getName())).flatMap(student -> student.getMarks().stream())
                .mapToDouble(mrk-> Double.valueOf(mrk)).summaryStatistics();
        System.out.println(summaryStatistics);
    }

}

