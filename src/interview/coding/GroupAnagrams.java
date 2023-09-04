package interview.coding;


import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * List<String> wordList = Arrays.asList("face", "caffe", "cafe", "milk", "limk", "abc");
 */
public class GroupAnagrams {

    public static void main(String[] args){
        //output: [[face, cafe], [milk, limk], [abc, bac, cab]]
        groupByAnagrams(Arrays.asList("Face", "Cafe", "Milk", "Limk", "abc", "bac", "cab"));

        //face --> acef
        //cafe --> acef
    }



    public static void groupByAnagrams(List<String> words){


        Function<String, String> mapKey = (wrd) -> {
            return wrd.toLowerCase().chars().mapToObj((ch)-> String.valueOf(ch)).sorted().collect(Collectors.joining());
        };

        Function<String, List<String>> mapValue = (wrd) -> {
            List <String> wrds = new ArrayList<>();
            wrds.add(wrd);
            return wrds;
        };

        BinaryOperator<List<String>> merge = (existing, replacing)-> {
            existing.addAll(replacing);
            return existing;
        };

        Map<String, List<String>> groupedAnagrams = words.stream().collect(Collectors.toMap(mapKey, mapValue, merge));
        groupedAnagrams.values().stream().forEach(System.out::println);
    }

    public static void groupAnagram(List<String> words){
        HashMap<String, List<String>> groupedAnagrams = new HashMap<>();
        words.stream().forEach((wordA) -> {
            String sortedWord = wordA.toLowerCase().chars().mapToObj((ch)->String.valueOf(ch)).sorted().collect(Collectors.joining());
            if(groupedAnagrams.get(sortedWord) == null){
                List<String> ans = new ArrayList<>();
                ans.add(wordA);
                groupedAnagrams.put(sortedWord, ans);
            }else{
                groupedAnagrams.get(sortedWord).add(wordA);
            }
        });
        groupedAnagrams.values().stream().forEach(System.out::println);
    }
}
