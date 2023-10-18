package functional.programing;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionInterface {

    public static void main(String []args){
        BiFunction<Integer, Integer, Boolean> isDivisible = (intA, intB) -> {
            if(intA % intB == 0){
                return true;
            }else{
                return false;
            }
        };

        System.out.println(isDivisible.apply(27, 9));

        BiFunction<String, String, String> combineStringByHyphen = (strA, strB)->{
            return new StringBuilder(strA).append("-").append(strB).toString();
        };

        Function<String, Boolean> isUpdated = (str)->{
            if(str.contains("-")){
                return true;
            }
            return  false;
        };
        System.out.println(combineStringByHyphen.andThen(isUpdated).apply("first", "second"));
    }
}
