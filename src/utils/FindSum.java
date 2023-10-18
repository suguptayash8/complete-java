package utils;

/**
 * Given two numbers as strings. The numbers may be very large (may not fit in long long int), the task is to find sum of these two numbers.
 *
 * Examples:
 *Given two numbers as strings. The numbers may be very large (may not fit in long long int), the task is to find sum of these two numbers.
 *
 * Examples:
 *
 * Input: str1 = "1,689",
 *
 *        str2 =   "99"
 *
 * Output: 3377733333332222
 */
public class FindSum {

    public static void main(String []args){
        System.out.println(sumStrings("33,33311111111111",  "4,4422222221111"));
    }

    /**
     * 1) both are null
     * 2) either is null
     * 3) empty strings
     * 4) test with 0
     * 5) positive numbers
     * 6) number ending with 9s
     * 7) string having decimal separators
     * @param inpA
     * @param inpB
     * @return
     *
     * Input: str1 = "33,33311111111111",
     * str2 =   “4,4422222221111"
     */
    public static String sumStrings(String inpA, String inpB){


        String sol = "";
        int carry = 0;
        int i,j;
        for(i = inpA.length() -1, j = inpB.length() -1; i >= 0 && j >= 0; i--,j--){
            if(!Character.isDigit(inpA.charAt(i))){
                i--;
            }
            if(!Character.isDigit(inpB.charAt(j))){
                j--;
            }
            int numA = Integer.parseInt(String.valueOf(inpA.charAt(i)));
            int numB = Integer.parseInt(String.valueOf(inpB.charAt(j)));
            int sum = numA + numB + carry;
            int digit = sum % 10;
            carry = sum/10;
            sol = String.valueOf(digit) + sol;
        }

        while(i >= 0) {
            if(!Character.isDigit(inpA.charAt(i))){
                i--;
            }

            int numA = Integer.parseInt(String.valueOf(inpA.charAt(i)));
            int sum = numA + carry;
            int digit = sum % 10;
            carry = sum / 10;
            sol = String.valueOf(digit) + sol;
            i--;
        }

            while (j >= 0){
                if(!Character.isDigit(inpB.charAt(j))){
                    j--;
                }
                int numB = Integer.parseInt(String.valueOf(inpB.charAt(i)));
                int sum = numB + carry;
                int digit = sum % 10;
                carry = sum/10;
                sol = String.valueOf(digit) + sol;
                j--;
            }
            if(carry > 0){
                sol = carry + sol;
            }
            return sol;
    }
}
