package utils;

import java.util.Optional;

public class Iterate {
    public static void main(String[] args){
        printNumber(Optional.of(30), Optional.empty());
    }

    public static void printNumber(Optional<Integer> curr, Optional<Integer> max){
        if(curr.orElse(Integer.MAX_VALUE)> max.orElse(-1)){
            return;
        }

        printNumber(Optional.of(curr.get() + 1), max);
        System.out.println(curr);
    }
}
