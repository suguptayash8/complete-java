package utils;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A -> B ->C -> D -> E
 *               D <-
 * fastPointer - C, E, E, E
 * slowPointer -B, C, D, E
 *
 * startP - A, B, C, D
 * currtP - E, D, E, D
 */
public class CyclicLinkedList {

    /**
     * caat, tcaa
     *
     *
     *
     * @param inpA
     * @param inpB
     */
    public static boolean isAnagram(String inpA, String inpB){

        if(inpA.length() != inpB.length()){
            return false;
        }

        Map<String, Integer> charFreq = inpA.chars().mapToObj((ch)-> String.valueOf((char)ch))
                .collect(Collectors.toMap((str)-> str, (str)-> 1, (existing, replacing) -> existing + replacing));

        inpB.chars().mapToObj((ch)-> String.valueOf((char)ch)).forEach((str)->{
            if(charFreq.get(str) != null){
                charFreq.put(str, charFreq.get(str) -1);
            }
        });

        List<Integer> con = charFreq.values().stream().filter((val)-> val > 0).collect(Collectors.toList());

        if(con.size() > 0){
            return false;
        }
        return true;
    }
}
