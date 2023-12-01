package functional.programing;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionInterface {

    public static void main (String[] args){

        funcInt();
        funcIntChaining();
        funcIntCompoChaining();
    }

    public static void funcInt(){
        Function<String, Integer> testFunc = (str)-> {
            return str.length();
        };

        System.out.println(testFunc.apply("some string "));
    }

    public static void funcIntChaining(){
        Function<String, Integer> testFunc = (str)-> {
            return str.length();
        };

        Function<Integer, String> oddOrEven = (len)-> {
            return len % 2 == 0 ? "even": "odd";
        };
        System.out.println(testFunc.andThen(oddOrEven).apply("random String"));
    }

    public static void funcIntCompoChaining(){

        Function<String, String> addPreString = (str)-> {
            return "test" + " " + str;
        };

        Function<String, Integer> testFunc = (str)-> {
            return str.length();
        };

        Function<Integer, String> oddOrEven = (len)-> {
            return len % 2 == 0 ? "even": "odd";
        };
        System.out.println(testFunc.compose(addPreString).andThen(oddOrEven).apply("my string"));
    }
}
