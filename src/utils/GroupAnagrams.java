package utils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * List<String> wordList = Arrays.asList("face", "caffe", "cafe", "milk", "limk", "abc");
 */
public class GroupAnagrams {

    public static void main(String[] args){
        groupAnagram(Arrays.asList("face", "caffe", "cafe", "milk", "limk", "abc"));
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
