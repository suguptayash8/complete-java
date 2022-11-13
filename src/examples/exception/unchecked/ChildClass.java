package examples.exception.unchecked;

import examples.exception.unchecked.ParentClass;

import java.util.Arrays;
import java.util.List;

public class ChildClass extends ParentClass {

    @Override
    public void process() throws IndexOutOfBoundsException{
        List<Integer> nums =  Arrays.asList(3,6,8);
        nums.get(3);
    }
}
