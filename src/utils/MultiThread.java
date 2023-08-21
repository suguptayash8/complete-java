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

