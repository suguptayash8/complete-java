package functional.programing;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionInterface {

    public static void main(String []args){
        biFuncInt();
        biFuncIntChain();
    }

    public static void biFuncInt(){
        BiFunction<Integer, Integer, Boolean> isDivisible = (intA, intB) -> {
            if(intA % intB == 0){
                return true;
            }else{
                return false;
            }
        };

        System.out.println(isDivisible.apply(18,6));
    }

    public static void biFuncIntChain(){
        BiFunction<Integer, Integer, String> anyalyzeInvestment = (investedValue, currValue) -> {
            if(currValue > investedValue){
                return "profit";
            }
            return "loss";
        };

        Function<String, String> giveAdvice = (str) -> {
            if("profit".equals(str)){
                return "over all you are making profit";
            }else if("loss".equals(str)){
                return "over all you are in loss";
            }
            return "no investment to show";
        };

        System.out.println(anyalyzeInvestment.andThen(giveAdvice).apply(38475, 764593));
    }
}
