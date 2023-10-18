package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/**
 * television
 */
public class LongestSubstring {

    public static void main(String[] args){

    }

    public static String longestSubStr(String inp){

        String subStr = "";
        String sol = "";
        int lastIndex = inp.length()-1;

        for(int i = 0, j=0; j <=lastIndex  && i <=lastIndex ; j++){
            String ch = String.valueOf(inp.charAt(j));
            if(subStr.contains(ch)){
               getWindowStartIndex(inp, ch, j-1);
            }
            subStr = subStr + String.valueOf(inp.charAt(j));
        }
        return "";
    }

    public static int getWindowStartIndex(String inp, String ch, int end){
        while( end >= 0  && !String.valueOf(inp.charAt(end)).equals(ch)){
            end--;
        }
        return end;
    }

    /**
     * [13:26] Parv Gupta
     *
     * ["eat", "tea", "tan", "ate", "nat", "bat"]
     *
     * [13:26] Parv Gupta
     *"aet aet
     * [["eat","tea","ate"],["tan","nat"],["bat"]]
     * @param inp
     */
    public static void groupAnagrams(List<String> inp){

        Function<String, String> getKey = (wrd)-> {
            return  wrd.chars().mapToObj((ch)-> String.valueOf((char)ch))
                    .sorted().collect(Collectors.joining());
        };

        Function<String, List<String>> getValue = (wrd) -> {
            List<String> sol = new ArrayList<>();
            sol.add(wrd);
            return sol;
        };

        BinaryOperator<List<String>> merge = (existing, rep)-> {
            existing.addAll(rep);
            return existing;
        };

        Map<String, List<String>> sol = inp.stream().collect(Collectors.toMap(getKey, getValue, merge));
        System.out.println(sol);
    }
/**
 *  * [prod_id, prod_name, sold_price]
 * select prod_id, sum(sold_price) as SUM_PER_PRODUCT
 * from product
 * group by prod_id order by SUM_PER_PRODUCT desc limit 5;
 *
 * output []
 *   11           A          23
 */
}
