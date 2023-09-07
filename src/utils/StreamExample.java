package utils;

import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExample {
    /**
     * "suyash gupta"
     */

    public static void main(String[] args){
        System.out.println(freqRepeatedCharacter(Optional.of("Suyash Gupta")));
    }

    public static String freqRepeatedCharacter(Optional<String> input){
        Function<String, String> getKey = (str)->{
            return str;
        };

        Function<String, Integer> getValue = (str)->{
            return 1;
        };

        BinaryOperator<Integer> addValue = (existiing, replacing)->{
            return  existiing + replacing;
        };

        String maxChar = input.map((inp)->{
            Map.Entry<String, Integer> max = inp.chars().mapToObj((ch)-> String.valueOf(ch))
                    .collect(Collectors.toMap(getKey, getValue,addValue))
                    .entrySet().stream().sorted((entryA, entryB)-> {
                        return entryB.getValue() > entryA.getValue() ? 1: -1;
                    }).findFirst().get();

            return max.getKey();

        }).orElse("");

        return maxChar;
    }
}
