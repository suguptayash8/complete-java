package utils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array arr of 4 digits, find the latest 24-hour time that can be made using each digit exactly once.
 * 24-hour times are formatted as “HH:MM”, where HH is between 00 and 23, and MM is between 00 and 59. The earliest 24-hour time is 00:00, and the latest is 23:59.
 * Return the latest 24-hour time in “HH:MM” format. If no valid time can be made, return an empty string.
 * Example 1:
 * Input: A =  [6,6]
 * Output: “23:41”
 * Explanation: The valid 24-hour times are “12:34", “12:43”, “13:24", “13:42”, “14:23", “14:32”, “21:34", “21:43”, “23:14", and “23:41”. Of these times, “23:41" is the latest.
 * Example 2:
 * Input: A = [5,5,5,5]
 * Output: “”
 * Explanation: There are no valid 24-hour times as “55:55" is not valid.
 * Example 3:
 * Input: A = [0,0,0,0]
 * Output: “00:00”
 * Example 4:
 * Input: A = [0,0,1,0]
 * Output: “10:00"
 *
 * Constraints:
 * arr.length == 4
 * 0 <= arr[i] <= 9
 *
 * 23:59
 * hours 0 to 23
 * minutes 00 to 59
 * 00:00
 * [2,8,5,5]
 * 0-2
 * 0-9
 * 0-5
 * 0-9
 */
public class MaxTime {

    public static void main(String[] args){
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        findMaxTime(nums);
    }
    public static void findMaxTime(List<Integer> inp){
        List<Integer> invalid = inp.stream().filter(ele -> ele > 5).collect(Collectors.toList());
        if(invalid.size() >= 2){
            return;
        }

        System.out.println(buildTime(inp));

    }

    public static String buildTime(List<Integer> inp){
        /**
         * [1,2,3,4]
         * [1,1,1,1]
         */

        Map<Integer, List<Integer>> hoursValue = new HashMap<>();
        hoursValue.put(2, Arrays.asList(0,1,2,3));
        hoursValue.put(1, Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        hoursValue.put(0, Arrays.asList(0,1,2,3,4,5,6,7,8,9));

        String sol = "";


        List<Integer> validHours = hoursValue.keySet()
                .stream().sorted().filter( key -> inp.contains(key))
                .collect(Collectors.toList());

        if(validHours.size() <= 0 ){
            return sol;
        }
//[1,2]
        for(int i  = validHours.size()-1;  i > 0; i--){
            Integer hrs =  hoursValue.get(validHours.get(i)).stream().sorted(Comparator.reverseOrder()).filter(ele -> inp.contains(ele))
                    .findFirst().orElse(-1);
            if(hrs > 0){
                inp.remove(Integer.valueOf(validHours.get(i)));
                inp.remove(Integer.valueOf(hrs));
                sol = validHours.get(i) + "" + hrs;
                break;
            }
        }

        List<Integer> mins = Arrays.asList(0,1,2,3,4,5);

        int min = mins.stream().sorted(Comparator.reverseOrder()).filter((ele)-> inp.contains(ele)).findFirst().orElse(-1);

        if(min > 0){
            inp.remove(Integer.valueOf(min));
            sol = sol + ":" +  min + "" + inp.stream().findFirst().get();
        }

        return sol;
    }
}
