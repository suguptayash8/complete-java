package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringArray {

    public static void streamOnArray(String[] args){

        Arrays.stream(args);

        List<Integer> nums = new ArrayList<>();
        int total = nums.stream().skip(1).reduce(0, (curr, sum)-> curr+sum);
    }
}
