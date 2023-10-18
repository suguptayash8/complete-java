package functional.programing;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorInterface {

    public static void main(String[] args){
        UnaryOperator<String> unaryOperator = (str)-> {
            return "random";
        };
        System.out.println(unaryOperator.apply("test"));

        BinaryOperator<String> binaryOperator = (strA, strB)->{
            return strA + " - " + strB;
        };

        System.out.println(binaryOperator.apply("suyash", "gupta"));
    }
}
