package functional.programing;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionInterface {

    public static void main (String[] args){

        Function<List<String>, List<String>> processData = (List<String> inp) -> {
            return inp.stream().map(str->{
                String[] splitWrds = str.split("-");
                String response = "";
                for(String word: splitWrds){
                    response = response + word;
                }
                return response;
            }).collect(Collectors.toList());
        };

        Function<List<String>, List<String >> buildData = (List<String> inp)-> {
            inp.add("IT-SE");
            inp.add("IT-Electronics");
            inp.add("Space-Aerodynamics");
            inp.add("Space-Sateallite");
            return inp;
        };

        Function<List<String>, List<String>> preProcessData = (List<String> inp)-> {
            return inp.stream().map(str->str + "-" + "field").collect(Collectors.toList());
        };


        List<String> inp = new ArrayList<>();
        List<String> resp = preProcessData.compose(buildData).andThen(preProcessData).apply(inp);
        resp.stream().forEach(System.out::println);
    }
}
