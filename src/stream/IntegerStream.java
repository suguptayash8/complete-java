package stream;

import java.util.stream.Stream;

public class IntegerStream {
    public static Stream<Integer> intNumbersStream() {
        return Stream.iterate(0, i -> i + 2)
                .limit(10);
    }

    public static void printSubsequentHighest(){
        intNumbersStream().filter(num-> num > 5 )
                .skip(1l)
                .limit(2l)
                .forEach(num-> System.out.println(num));
    }

    public static void main(String[] args){
        IntegerStream.printSubsequentHighest();
    }
}
