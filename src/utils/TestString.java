package utils;

/**
 * str = "Java is a good language"
 * out = "avaJ is a good egaugnal"
 * vaj
 */
public class TestString {

    public static void main(String[] args){
        System.out.println(alternateRev("Java is a good language and funny"));
    }
    public static String alternateRev(String inp){
        String  sol = "";
        boolean reverse = true;
        String []words = inp.split(" ");
        for(int i = 0; i< words.length; i++){

            if( i % 2 != 0){
                sol = sol + " " + words[i];
                continue;
            }

            String rev  = "";
            for(int j = 0; j < words[i].length(); j++){
                char c = words[i].charAt(j);
                if(c == ' '){
                    reverse = reverse == false ? true :false;
                    rev = rev + c;
                }else if(reverse){
                    rev = c + rev;
                }else{
                    rev = rev + c;
                }
            }

            sol = sol + " " + rev;
        }
        return sol;
    }
}
