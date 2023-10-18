package functional.programing;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class BiPredicateInterface {
    public static void main(String[] args){
        BiPredicate<String, String> containsStr = (strA, strB)->{
            if(strA.contains(strB)){
                return true;
            }
            return false;
        };

        BiPredicate<String, String> greaterLength = (strA, strB)->{
            if(strA.length() > strB.length()){
                return true;
            }
            return false;
        };

        System.out.println(containsStr.and(greaterLength).test("Anand", "and"));
    }
}
