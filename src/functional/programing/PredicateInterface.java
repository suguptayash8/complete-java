package functional.programing;

import java.util.function.Predicate;

public class PredicateInterface {

    public static void main(String []args){
        Predicate<Integer> isEven = (num)-> {
            if(num % 2 == 0){
                return true;
            }
            return false;
        };
        //System.out.println("isEven " +  isEven.test(24));
        //System.out.println("isEven " +  isEven.test(25));

        Predicate<Integer> isOldAge = (num)-> {
            if(num > 60){
                return true;
            }
            return false;
        };
        //System.out.println("isOldAge " +  isOldAge.test(24));
        //System.out.println("isOldAge " +  isOldAge.test(64));


        Predicate isEvenAndOld = isEven.and(isOldAge);
        //System.out.println("isEvenAndOld " +  isEvenAndOld.test(73));
        //System.out.println("isEvenAndOld " +  isEvenAndOld.test(74));


        Predicate<Integer> isOddAndOldAge = isEven.negate().and(isOldAge);
        //System.out.println("isOddAndOldAge " +  isOddAndOldAge.test(73));
        //System.out.println("isOddAndOldAge " +  isOddAndOldAge.test(74));


        //System.out.println("isEvenOrOldAge " + isEven.or(isOldAge).test(23));
        //System.out.println("isYoungAndEven " + isEven.and(isOldAge.negate()).test(28));

    }

}
