package utils;

/**
 * W   A   S   I
 * A M R I H R N   2 * (rows  - i) - 1
 * L   T   I   G
 *
 * WALMARTISHIRING
 * WASIAMRIHRNLTIg
 * Rows : 3
 *
 * W     A
 * A  M  R
 * L     T
 *
 * W      T         I
 * A   R  I     R   N
 * L A    S  I      G
 * M      H
 * WTIARIRNLASIGMH
 */
public class StringTest {

    public static void main(String []args){
        generateZigZag("WALMARTISHIRING", 3);
    }
    public static void generateZigZag(String inp, int rows){
        String sol = "";
        for(int i = 1; i <= rows; i++ ){
            int counter = 0;
            for(int j = 1; j < inp.length(); j++){
                counter ++;
                int index = i-1;
                int evenDelta = 2 * (rows  - i) - 1;
                evenDelta = evenDelta < 0 ? 0 : evenDelta;
                int oddDelta =  2* i -1;
                oddDelta = oddDelta < 0 ? 0 : oddDelta;

                if( i == 1){
                    if( j == index || counter % (evenDelta + 1) == 0){
                        sol = sol + inp.charAt(j);
                    }
                }else {
                    if(counter % 2 == 0){
                        if( counter % (oddDelta + 1) == 0 ){
                            sol = sol + inp.charAt(j);
                        }
                    }else {
                        if( j == index || counter % (evenDelta + 1) == 0){
                            sol = sol + inp.charAt(j);
                        }
                    }
                }
            }
        }

        System.out.println(sol);
    }
}
