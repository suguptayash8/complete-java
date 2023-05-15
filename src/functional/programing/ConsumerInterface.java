package functional.programing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsumerInterface {

    public static void main(String[] args){
        Consumer<List<String>> splitByHyphen = (List<String> inp)->{
            for(int i = 0; i < inp.size(); i++){

                String[] splitString = inp.get(i).split("-");
                String out = "";
                for (String word: splitString) {
                    out = out + " " + word;
                }

                inp.set(i, out);
            }
        };

        Consumer<List<String>> populateData = (List<String> inp)->{
            /**
             * we can write logic to fetch from data base or rest
             */
            inp.add("IT-SE");
            inp.add("IT-Electronics");
            inp.add("Space-Aerodynamics");
            inp.add("Space-Sateallite");
        };

        Consumer<List<String>> massageData = (List<String> inp)->{

           for(int i = 0; i < inp.size(); i++){
               inp.set(i, inp.get(i)+"-"+"field");
           }
        };

        Consumer<List<String>> logData = (List<String> inp) -> {
            inp.stream().forEach(System.out::println);
        };

        List<String> inp = new ArrayList<>();

        populateData.andThen(massageData).andThen(splitByHyphen).andThen(logData).accept(inp);

    }
}
