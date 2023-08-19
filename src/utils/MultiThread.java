package utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MultiThread {
    public static void main(String[] args){
        A a = new A(); A b = new A();
        Runnable t1 = ()-> {
            a.methodA();
        };
        Runnable t2 = ()-> {
            b.methodA();
        };
        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);
        th1.start();
        th2.start();

        //approach1
        //Collections.sort(Student.mockStudentList());

        //approach2
        Student.mockStudentList().stream().sorted((stdA, stdB) -> {
            return stdA.name.compareTo(stdB.name) != 0 ? stdA.name.compareTo(stdB.name)
                    : stdB.totalMarks > stdA.totalMarks ? 1 : -1;
        }).collect(Collectors.toList());
    }
}
class A {
    public synchronized void methodA(){
        for(int i = 0; i < 100 ; i ++){
            System.out.println(i + Thread.currentThread().getId());
        }
    }
}

class B {
    public void methodA() throws ArrayIndexOutOfBoundsException {
        //print
    }
};
class C extends B {
    public void methodA()  throws RuntimeException {
        //print
    }
}

class Student {
    String name;
    Integer totalMarks;

    Student(String name, Integer totalMarks){
        this.name  = name;
        this.totalMarks = totalMarks;
    }

    static List<Student> mockStudentList(){
        Student A = new Student("Shubham", 100);
        Student B = new Student("Shubham", 90);
        Student C = new Student("kamal", 70);
        Student D = new Student("sharukh",  60);
        Student E = new Student("sharukh", 50);
        Student F = new Student("Ajay", 70);
        return Arrays.asList(A,B,C,D,E,F);
    }
}