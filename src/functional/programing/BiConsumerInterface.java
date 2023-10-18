package functional.programing;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class BiConsumerInterface {

    public static void main(String []args){
        BiConsumer<String,String> printName = (firstName, lastName) -> {
            System.out.println(firstName + " " + lastName);
        };
        printName.accept("Suyash", "Gupta");
    }
}
