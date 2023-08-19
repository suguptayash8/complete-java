package utils;

public class Pallindrome {

    /**
     * "madam", "radar", "abba".
     * @param args
     */
    public static void main(String[] args){
        System.out.println(checkPalindromeString("abba"));
        System.out.println(checkPalindromeString("madam"));
        System.out.println(checkPalindromeString("radar"));
        System.out.println(checkPalindromeString("radal"));
    }

    public static boolean checkPalindromeString(String input) {

       for(int i =0, j = input.length() -1; i <j; i++, j--){
           if(input.charAt(i) != input.charAt(j)){
               return false;
           }
       }

       return true;



    }
}
