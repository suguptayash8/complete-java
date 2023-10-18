package utils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**i =1
 *
 * 1,2,3,4,5,7,8,9,10
 *
 * 1 2 3
 */
public class TestJava {

    public static void main(String []args){
        //System.out.println(findMissingNum("1,2,3,4,5,7,8,9,10"));
        System.out.println(findLongestSubString("amiaflicnm"));
    }

    public static int findMissingNum(String inp){
        String[] nums =  inp.split(",");
        int seqSum = Arrays.stream(nums).mapToInt((str)-> Integer.parseInt(str)).sum();
        int actualSum = IntStream.range(1,11).sum();
         return actualSum - seqSum;
    }

    /**
     * amiaflicnm
     */

    public static String findLongestSubString(String inp){
        String sol = "";
        List<String> subStr = new ArrayList<>();
        int len = inp.length();
        for(int j = 0; j < len; j++){
            String ch = String.valueOf(inp.charAt(j));
            if(!subStr.contains(ch)){
                subStr.add(ch);
            }else{
                if(subStr.stream().collect(Collectors.joining()).length() > sol.length()){
                    sol = subStr.stream().collect(Collectors.joining());
                }
                subStr = nextWindow(subStr, ch);
                subStr.add(ch);
            }
        }

        if(subStr.stream().collect(Collectors.joining()).length() > sol.length()){
            sol = subStr.stream().collect(Collectors.joining());
        }
        return sol;
    }

    public static List<String> nextWindow(List<String> inp, String ch){
        int index = inp.lastIndexOf(ch);
        int i = 0;
        while(i <= index){
            inp.remove(0);
            i++;
        }
        return inp;
    }
}
