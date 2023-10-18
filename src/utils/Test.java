package utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public static int differentTeams(String skills) {
        String constraint = "bcmpz";
        Map<String, Integer> freqMap = skills.chars().mapToObj(ch-> String.valueOf(ch))
                .collect(Collectors.toMap(str-> str, str->1, (existing, replacing)-> existing + replacing));

        System.out.println(freqMap);
        List<Map.Entry<String, Integer>> sortFreq = freqMap.entrySet().stream()
                .sorted((entryA, entryB) ->  {
                    return entryA.getValue() > entryB.getValue() ? 1 : -1;
                }).collect(Collectors.toList());


        String allSkil = freqMap.keySet().stream().sorted().collect(Collectors.joining());
        System.out.println(allSkil);
        /*if(!allSkil.contains(constraint)){
            return 0;
        }*/

        return sortFreq.get(0).getValue();
    }

    public static void main(String []args){
       System.out.println(differentTeams("mppzbmbpzcbmpbmczcz"));
    }
}
