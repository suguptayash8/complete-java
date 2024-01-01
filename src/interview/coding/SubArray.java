package interview.coding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * input = {1,4,5,2,3,6,7,2,5,6}
 * output = 5, 9,7,5,9,13,
 */
public class SubArray {

    public static void main(String[] args){
        System.out.println(fundSumInSubArray(Arrays.asList(1,4,5,2,3,6,7,2,5,6), 3));
        //getOccurence(Arrays.asList(1,4,5,2,3,6,7,2,5,6));
    }

    public static List<Integer> fundSumInSubArray(List<Integer> nums, int subArrSize){
        if(Objects.isNull(nums) || nums.isEmpty() ){
            return null;
        }

        List<Integer> sol = new ArrayList<>();

        int sum = 0;

        for(int i = 0; i< subArrSize & i<nums.size(); i++){
            sum = sum + nums.get(i);
        }
        sol.add(sum);

        for(int i = subArrSize; i<nums.size(); i++){
            int remove = 0;
            remove = nums.get(i-subArrSize);
            sum = sum + nums.get(i) - remove;
            sol.add(sum);
        }
        return sol;
    }

    public static void getOccurence(List<Integer> inp){
        Map<Integer, Integer> numFreq =  inp.stream()
                .collect(Collectors.toMap((num)-> num, (num)-> 1, (exist, curr)-> exist+ curr));
        numFreq.keySet().stream().forEach(num-> {
            System.out.println("Occurence for " + num + ": " + numFreq.get(num));
        });
    }
}

/**
 *
 *
 * type Query{
 *     getProductByCategory(category): Product
 *     getProductByName(name): Product
 * }
 *
 * type Product {
 *
 * }
 *
 * query{
 *     product{
 *         category
 *     }
 * }
 *
 * query{
 *  *     product{
 *  *         name
 *  *     }
 *  * }
 *
 *   query{
 *  *  *     product{
 *  *  *         name
 *               fieldsA
 *               fieldsB
 *  *  *     }
 *  *  * }
 *
 * @Query
 *
 *
 */