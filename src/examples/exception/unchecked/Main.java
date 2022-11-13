package examples.exception.unchecked;

import examples.exception.checked.AnotherChildClass;
import examples.exception.checked.ChildClass;
import examples.exception.checked.ParentClass;

public class Main {


    public static void main(String [] args){
        ParentClass p = new AnotherChildClass();

        try{
            p.process();
        }catch (ArithmeticException e){

        }


        ParentClass pchildClass = new ChildClass();
        try {
            pchildClass.process();
        }catch (IndexOutOfBoundsException e){
        }

    }
}
