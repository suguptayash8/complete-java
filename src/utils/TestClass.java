package utils;

public class TestClass {

    /***
     *
     * @param numA
     * @param numB
     *
     * 2345679
     * 0034457
     * @return
     */
    public static String addNumbers(String numA, String numB){

        if( numA == null && numB == null){
            return null;
        }

        String sol = "";
        boolean carry = false;

        int pointerA = numA.length() - 1,
                pointerB = numB.length() - 1;

        while(pointerA >= 0 && pointerB >= 0){
            int sumDigit = Integer.parseInt(String.valueOf(numA.charAt(pointerA))) +
                    Integer.parseInt(String.valueOf(numB.charAt(pointerB)));

            if(carry){
                sumDigit++;
                carry = false;
            }

            if(sumDigit > 10){
                carry = true;
                sumDigit = sumDigit - 10;
            }

            sol =  sumDigit + sol;
            pointerA--;
            pointerB--;
        }

        while(pointerA >= 0 ){

            int sumDigit = Integer.parseInt(String.valueOf(numA.charAt(pointerA)));

            if(carry){
                sumDigit++;
                carry = false;
            }
            sol = sumDigit + sol;
            pointerA--;
        }


    while(pointerB >= 0 ){
        int sumDigit = Integer.parseInt(String.valueOf(numB.charAt(pointerB)));
        if(carry){
            sumDigit++;
            carry = false;
        }
        sol = String.valueOf( sumDigit) + sol;
        pointerB--;
    }

    if(carry){
        sol = "1" + sol;
    }
    return sol;
 }

 public static void main(String[] args){
       System.out.println(addNumbers("10", "5"));
 }
}
