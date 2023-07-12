package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordsSol {

    /**
     * Input: word = "batsandcows", words = {"bat", "bats", "and", "sand", "cows", "cow"}
     *
     *
     *                               "batsandcows"
     *
     *
     */

    public static List<String> makeSenetence(String word, String []words){
        Set<String> wordInWords = new HashSet<>();
        int minWindSize = -1, maxWinSize = -1;

        for(String wd : words){
            wordInWords.add(wd);

            if(minWindSize == -1 || maxWinSize == -1){
                minWindSize = wd.length();
                maxWinSize = wd.length();
            }

            int curWordLength = wd.length();

            if(curWordLength < minWindSize){
                minWindSize = curWordLength;
            }

            if(curWordLength > maxWinSize){
                maxWinSize = curWordLength;
            }
        }
        List<String> sol = new ArrayList<>();
        String senetnce = "";
        List<String> wordsInWindow = createWindow(word, 0, minWindSize, maxWinSize);

        int start = 0;
        for(String wrdInWind: wordsInWindow){
            if(wordInWords.contains(wrdInWind)){
                senetnce = senetnce + " " + wrdInWind;
                start = wrdInWind.length();
                createWindow(word, start, minWindSize, maxWinSize);
            }
        }

        return sol;
    }

    private static List<String> createWindow(String word, int start, int min, int max){
        List<String> wordsInWindow = new ArrayList<>();


        String wordMatch = "";

        for(int i = start; i < word.length(); i++){
            wordMatch = wordMatch + word.charAt(i);

            if(wordMatch.length() == min){
                wordsInWindow.add(wordMatch);
            } else if (wordMatch.length() <= max) {
                wordsInWindow.add(wordMatch);
            }else{
                break;
            }
        }


        return wordsInWindow;
    }
}
