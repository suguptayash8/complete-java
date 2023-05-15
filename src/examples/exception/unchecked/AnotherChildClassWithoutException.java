package examples.exception.unchecked;

import java.util.Arrays;
import java.util.List;

public class AnotherChildClassWithoutException extends ParentClass {

    @Override
    public void process() {
        List<Integer> nums =  Arrays.asList(3,6,8);
        nums.get(3);
    }


}
