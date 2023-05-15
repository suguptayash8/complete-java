package examples.exception.unchecked;

import java.util.Arrays;
import java.util.List;

/**
 * Problem 1:  If The SuperClass doesn’t declare an exception
 *
 * Case 1: If SuperClass doesn’t declare any exception and subclass declare checked exception
 * output: compilation fails
 *
 * Case 2: If SuperClass doesn’t declare any exception and SubClass declare Unchecked exception
 * output: run successfully
 *
 * Problem 2: If The SuperClass declares an exception
 * Now dwelling onto the next problem associated with that is if The SuperClass declares an exception. In this problem 3 cases will arise as follows:
 *
 * Case 1: If SuperClass declares an exception and SubClass declares exceptions other than the child exception of the SuperClass declared Exception.
 * output: compile failed
 *
 * Case 2: If SuperClass declares an exception and SubClass declares a child exception of the SuperClass declared Exception.
 * output: ran successfully
 *
 * Case 3: If SuperClass declares an exception and SubClass declares without exception.
 * outputL run successfully
 */
public class ParentClass {
    public void process() throws RuntimeException{
        List<Integer> nums =  Arrays.asList(3,6,8);
        nums.get(3);
    }

    public void processDataWithoutException(){
        List<Integer> nums =  Arrays.asList(3,6,8);
        nums.get(3);
    }
}
