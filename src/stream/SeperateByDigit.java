package stream;

import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SeperateByDigit {
    public static void main(String[] args){
        String inp  = "abc";
        String sol =
                inp.chars().mapToObj(c -> {
                    if(Character.isDigit((char) c)){
                        return (char) c + ",";
                    }else{
                        return  String.valueOf((char) c);
                    }
                }).collect(Collectors.joining());

        String str ="SEG2SEG3SEG5";
        AtomicReference<Integer> lastindex = new AtomicReference<>(0);
        String sub = IntStream.range(0, str.length()).
                filter(index -> Character.isDigit(str.charAt(index)))
                .mapToObj(pos->{
                    String s = str.substring(lastindex.get(),pos+1);
                    lastindex.set(pos+1);
                    return s;
                }).collect(Collectors.joining(","));

        System.out.println(sub);
    }
}
