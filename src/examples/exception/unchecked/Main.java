package examples.exception.unchecked;

import examples.exception.checked.AnotherChildClassWithDifferentExceptions;
import examples.exception.checked.ChildClass;
import examples.exception.checked.ParentClass;

public class Main {


    public static void main(String [] args){
        ParentClass p = new AnotherChildClassWithDifferentExceptions();

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
