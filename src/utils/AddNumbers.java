package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * "123456"
 * "000999" --- 999
 * "124455"
 *
 * Input: str1 = "33,33311111111111",
 * str2 =   “4,4422222221111"
 */
public class AddNumbers {

    public static void main(String[] args){
        //System.out.println(addNumbers( "999", "123456" ));
        //identifyDuplicates(Arrays.asList(1,12,3,14,15,18,9,22,24,13,7,12,15));
        identifyNumberStartWithOne(Arrays.asList(1,12,3,14,15,18,9,22,24,13,7,12,15));
    }

    /**
     * 1,12,3,14,15,18,9,22,24,13,7,12,15
     * @param nums
     */
    public static void identifyDuplicates(List<Integer> nums){
        Map<Integer, Integer> freq = nums.stream().collect(Collectors.toMap((num)-> num, (num)-> 1, (exist, curr)-> exist+curr));
        List<Integer> duplicates = freq.entrySet().stream().filter(entry-> entry.getValue() > 1).map(entry-> entry.getKey()).collect(Collectors.toList());
        duplicates.stream().forEach(System.out::println);
    }

    public static void identifyNumberStartWithOne(List<Integer> nums){
        List<String> numWithOne= nums.stream()
                .map(num -> String.valueOf(num))
                .filter(str-> str.length() >= 1 && str.charAt(0) == '1').collect(Collectors.toList());
        numWithOne.stream().forEach(System.out::println);
    }
    public static String addNumbers(String inpA, String inpB){
        int lenA = inpA.length();
        int lenB = inpB.length();

        int i = lenA -1 , j = lenB -1;

        String sol = "";
        boolean isCarry = false;

        while (i >= 0 && j >= 0){
            int a = Integer.parseInt(String.valueOf(inpA.charAt(i)));
            int b = Integer.parseInt(String.valueOf(inpB.charAt(j)));
            int sum = a+b;
            if(isCarry){
                sum += 1;
            }
            int digit = sum % 10;
            isCarry = sum / 10 == 1 ? true: false;
            sol = digit + sol;
            i--; j--;
        }

        if( j >= 0){
            sol = addRemaining(inpB, sol, j, isCarry);
        }

        if( i >= 0){
            sol =addRemaining(inpA, sol, i, isCarry);
        }

        return sol;
    }

    public static String addRemaining(String inp, String sol, int counter, boolean isCarry){
        while(counter >= 0){
            int b = Integer.parseInt(String.valueOf(inp.charAt(counter)));
            int sum = b;
            if(isCarry){
                sum = b+1;
            }
            int digit = sum % 10;
            isCarry = sum / 10 == 1 ? true: false;

            sol = digit + sol;
            counter--;
        }

        return sol;
    }
}
