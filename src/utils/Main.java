package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {

    /**
     * Input: pid = [1,3,10,5], ppid = [3,0,5,3], kill = 5
     * @param args
     */
    public static void main(String[]args){
        int[] input = {1,2,3};

        //System.out.println("Sum: " + calculateSumOfElementsInAnIntArrayRecursively(input));

        int []sol = unixProcessesToKill(new int[]{1,3,10,5}, new int[]{3,0,5,3}, 3);

        Arrays.stream(sol).map(Obj-> Integer.valueOf(Obj)).forEach(System.out::println);
    }
    public static int calculateSumOfElementsInAnIntArrayRecursively(int[] input) {
        return recursiveSummnation(input, 0);

    }


    public static int recursiveSummnation(int[] inp, int index){
        if(index >= inp.length){
            return 0;
        }

        return  inp[index] + recursiveSummnation(inp, ++index);
    }

    public static int[] unixProcessesToKill(int[] pids, int[] ppids, int kill){
        List<Integer> traversedElment = populateChildProcess(pids, ppids, kill);
        List<Integer> sol = new ArrayList<>();


        int i = 0;
        if(traversedElment.size() <=0 ){
            return null;
        }

        while( i < traversedElment.size()){
            sol.add(traversedElment.get(i));
            traversedElment.addAll(populateChildProcess(pids, ppids, traversedElment.get(i)));
            i++;
        }

        sol.add(kill);

        return  sol.stream().mapToInt((num)-> (int)num.intValue()).toArray();

     }

     public static List<Integer> populateChildProcess(int[] pids, int []ppids, int kill){

         List<Integer> traversedElment = new ArrayList<>();

         for(int i = 0; i < ppids.length; i++){
             if(ppids[i] == kill){
                 traversedElment.add(pids[i]);
             }
         }

         return traversedElment;
     }
}