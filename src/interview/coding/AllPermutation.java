package interview.coding;

import java.util.*;
public class AllPermutation {

    /**
     *shishirsastra@gmail.com
     * shishirsastra@gmail.com
     *           ABC
     *
     *       ABC  BAC    CBA
     *
     *
     *  ABC   ACB
     *
     * ABC ACB
     *
     * @return
     */

    public static void main(String[] args){
        findAllPermutations("ABC").stream().forEach(System.out::println);
    }

    public static List<String> findAllPermutations(String inp){
        return findAllPermutations(inp.toCharArray(), 0);
    }
    public static List<String> findAllPermutations(char[] inp, int start){
        List<String> sol = new ArrayList<>();

        if(start == inp.length-1){
            String perm = "";
            for(char c: inp){
                perm = perm + c;
            }

            sol.add(perm);
            return  sol;
        }

        for(int i = start; i < inp.length; i++){
            char[] swapped = swapChar(inp, start, i);
            sol.addAll(findAllPermutations(swapped, start + 1));
        }
        return sol;
    }

    private static char[] swapChar(char[] inp, int i, int j){
        String copy = String.valueOf(inp);
        char []swapp = copy.toCharArray();
        char tmp = swapp[i];
        swapp[i] = swapp[j];
        swapp[j] = tmp;
        return swapp;
    }
}
