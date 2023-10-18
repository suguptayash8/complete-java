package utils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * [14:15] S T, Shruthi
 *
 * Word count program. Word count program
 *
 * [14:16] S T, Shruthi
 *
 * Word ->2, count -> 2, program -> 2
 *
 * [14:16] S T, Shruthi
 *
 * Print most occurred and least occurred words
 */
public class WordOccurence {

    public static void main(String[] args){
        //printWordCount(" some text text example of some text");
        mergeSortedArray(Arrays.asList(6, 9, 10, 17,25), Arrays.asList(8, 9, 21, 23, 31));
    }

    public  static void printWordCount(String inp){
        String []words = inp.split(" ");

        Map<String, Integer> freqMap = Arrays.stream(words)
                .collect(Collectors.toMap((wrd)-> wrd, (wrd)-> 1, (existing, replacing)-> existing + replacing));

        List<Map.Entry<String, Integer>> sortedFreqMap = freqMap.entrySet().stream()
                .sorted((entryA, entryB) -> entryA.getValue() > entryB.getValue() ? 1 : -1).collect(Collectors.toList());

        System.out.println("Most occured word is " + sortedFreqMap.get(sortedFreqMap.size() -1).getKey());
        System.out.println("Least occured word is " + sortedFreqMap.get(0).getKey());
    }

    /**
     * [5,10,13,16,25]
     * [6,8,11,17,19]
     * @param inpA
     * @param inpB
     */
    public static void mergeSortedArray(List<Integer> inpA, List<Integer> inpB){

        List<Integer> sol = new ArrayList<>();
        int pointerA = 0, pointerB = 0;

        while (pointerA <  inpA.size() && pointerB < inpB.size()){
            if(inpA.get(pointerA) > inpB.get(pointerB)){
                sol.add(inpB.get(pointerB));
                pointerB++;
            }else if(inpA.get(pointerA) < inpB.get(pointerB)){
                sol.add(inpA.get(pointerA));
                pointerA++;
            }else if(inpA.get(pointerA) == inpB.get(pointerB)){
                sol.add(inpB.get(pointerB));
                sol.add(inpA.get(pointerA));
                pointerB++;
                pointerA++;
            }
        }

        while (pointerA < inpA.size()){
            sol.add(inpA.get(pointerA));
            pointerA++;
        }

        while (pointerB < inpB.size()){
            sol.add(inpB.get(pointerB));
            pointerB++;
        }

        sol.stream().forEach(System.out::println);

    }
}
