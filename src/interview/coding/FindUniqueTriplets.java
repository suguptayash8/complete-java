package interview.coding;

import java.util.*;

public class FindUniqueTriplets {

    public static List<List<Integer>> findUniqueTriplets(List<Integer> inp){
        List<List<Integer>> sol = new ArrayList<>();
        Set<Integer> firstPlaceVistied = new HashSet<>();
        for(int i = 0; i < inp.size() - 2; i++ ){
            if(firstPlaceVistied.contains(inp.get(i))){
                continue;
            }

            firstPlaceVistied.add(inp.get(i));
            Set<Integer> secondPlaceVisited = new HashSet<>();
            for(int j =  i+1; j < inp.size()-1; j++){
                if(secondPlaceVisited.contains(inp.get(j))){
                    continue;
                }
                secondPlaceVisited.add(inp.get(j));
                Set<Integer> thirdPlaceVisited = new HashSet<>();
                for(int k = j+ 1; k < inp.size(); k++){
                    if(thirdPlaceVisited.contains(inp.get(k))){
                        continue;
                    }
                    thirdPlaceVisited.add(inp.get(k));
                    sol.add(Arrays.asList(inp.get(i), inp.get(j), inp.get(k)));
                }
            }
        }
        return  sol;
    }
}
