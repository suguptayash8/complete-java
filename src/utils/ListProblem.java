package utils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 *  [1,1,1,2,1]
 *
 *  [1,3,3,4,1,1,2,1]
 *  1,3,4,1,2,1
 */
public class ListProblem {

    public static void main(String[] args){
        List<Integer> inp = Arrays.asList(1,1,1,2,1);

        List<Integer> sol = new ArrayList<>();

        IntStream.range(0, inp.size()).forEach((index) -> {
            if(sol.size() <= 0 || sol.get(sol.size()-1) != inp.get(index)){
                sol.add(inp.get(index));
            }
        });

        System.out.println(sol);
    }
}
