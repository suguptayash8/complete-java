package examples.exception.checked;

import java.util.Arrays;
import java.util.List;

public class ParentClass {

    public void process() {
        List<Integer> nums =  Arrays.asList(3,6,8);
        nums.get(3);
    }
}
