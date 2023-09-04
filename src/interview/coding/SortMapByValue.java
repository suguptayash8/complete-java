package interview.coding;

import utils.MockMapData;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByValue {


    public static void main(String []args){
        Map<String, Integer> sortedMapByValue = sortMapByValueDesc(MockMapData.getBooksCount().orElse(new HashMap<>()));
        sortedMapByValue.entrySet().stream().forEach(System.out::println);
    }

    public static Map<String , Integer> sortMapByValueDesc(Map<String, Integer> booksCount){

        List<Map.Entry<String,Integer>> sortedEnterySet = booksCount.entrySet()
                .stream()
                .sorted((entryA, entryB)->{ return entryB.getValue() > entryA.getValue() ? 1 : -1;})
                .collect(Collectors.toList());

        final Map<String, Integer> sortedBooksByValue = new LinkedHashMap<>();

        sortedEnterySet.stream().forEach((entry)-> {
            sortedBooksByValue.put(entry.getKey(), entry.getValue());
        });

        return sortedBooksByValue;
    }
}
