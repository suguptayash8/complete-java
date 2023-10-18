package utils;

import java.util.*;
import java.util.stream.Collectors;

public class TripletSum {

    /***
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     *
     * [-4,-1,-1,0,1,2]
     */

    public static void main(String[] args){
        System.out.println(findTriplet(Arrays.asList(-1,0,1,2,-1,-4)));
    }
    public static Set<List<Integer>> findTriplet(List<Integer> nums){
        List<Integer> sortedList = nums.stream().sorted().collect(Collectors.toList());
        Set<List<Integer>> sol = new HashSet<>();
        for(int i = 0; i < sortedList.size()-3; i++){
            int current = sortedList.get(i);
            List<List<Integer>> duplet = findDuplet(sortedList, i+ 1, (0-current));
            duplet.stream().forEach(ls-> {
                if(ls == null || ls.size() <= 0 ){
                    return;
                }
                List<Integer> triplets = new ArrayList<>();
                triplets.addAll(ls);
                triplets.add(current);
                sol.add(triplets);
            });
        }
        return sol;
    }

    public static List<List<Integer>> findDuplet(List<Integer> nums, int start, int target){

        List<List<Integer>> sol = new ArrayList<>();

        int end = nums.size() - 1;
        while(start < end ){
            if(nums.get(start) + nums.get(end) < target){
                start++;
            }else if(nums.get(start) + nums.get(end) > target){
                end--;
            }else if(nums.get(start) + nums.get(end) == target){
                System.out.println("print duplet " + nums.get(start) + " " + nums.get(end));
                 sol.add(Arrays.asList(nums.get(start), (nums.get(end))));
                 start++;
                 end--;
            }
        }
        return sol;
    }
}
