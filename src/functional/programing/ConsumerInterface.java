package functional.programing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsumerInterface {

    public static void main(String[] args){
        consumerInterface();
        consumerInterfaceChain();
    }

    public static void consumerInterface(){
        Consumer<String> printData = (str)->{
            System.out.println("\n" + "Inside " + new Object(){}.getClass().getEnclosingMethod().getName());
            System.out.println(str);
        };

        printData.accept("print this string, inside: "
                + new Object(){}.getClass().getEnclosingMethod().getName());
    }

    public static void consumerInterfaceChain(){
        Consumer<List<String>> populateRestData = (inp)->{
            /**
             * lets say you fetch data from rest
             */
            List<String> restData = Arrays.
                    asList("item: laptop", "item-mobile", "item-smartwatch");
            inp.addAll(restData);
        };

        Consumer<List<String>> printData = (inp)->{
            System.out.println( "\n" + "inside " + new Object(){}.getClass().getEnclosingMethod().getName());
            inp.stream().forEach(System.out::println);
        };

        populateRestData.andThen(printData).accept(new ArrayList<>());
    }
}
