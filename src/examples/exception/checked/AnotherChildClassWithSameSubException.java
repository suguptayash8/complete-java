package examples.exception.checked;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AnotherChildClassWithSameSubException extends ParentClass{

    public void processDataWithException() throws FileNotFoundException {
        List<Integer> nums =  Arrays.asList(3,6,8);
        nums.get(3);
    }
}
