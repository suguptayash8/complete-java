package examples.exception.unchecked;

import examples.exception.unchecked.ParentClass;

public class AnotherChildClass extends ParentClass {


    @Override
    public void process() throws ArithmeticException{
        int a = 3;
        int c = 3/0;
    }
}
