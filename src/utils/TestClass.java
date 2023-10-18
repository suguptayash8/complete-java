package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TestClass {


    private static Map<String, String> pairs = new HashMap<>();

    public static void main(String[] args){
        System.out.println(checkBalanceParenthesis("{{}([]){}[]}"));
    }

    /**
     * {{}([]){}[]}
     */

    public static boolean checkBalanceParenthesis(String inp){

        if(inp == null){
            return false;
        }

        buildPairs();

        Stack<String> parenStack = new Stack<>();
        for(int i = 0; i< inp.length(); i++){
            String ch = String.valueOf(inp.charAt(i));
            if(pairs.values().contains(ch)){
                parenStack.add(ch);
            }else if(pairs.keySet().contains(ch)){
                String popedCh = parenStack.pop();
                if(!popedCh.equals(pairs.get(ch))){
                    return false;
                }
            }
        }

        if(parenStack.isEmpty()){
            return true;
        }

        return false;

    }

    public static void buildPairs(){
        pairs.put("}", "{");
        pairs.put(")", "(" );
        pairs.put("]", "[");
    }
    /**
     *
     * [hotel_id, hotel_name]
     *
     * [customer_id, customerName, hotel_id]
     *
     *select count(customer_id), hotel_id from customer
     *  where hotel_id in (select hotel_id from hotel where hotel_name = '')
     *
     *   group by hotel_name
     *
     *   customer join hotel on
     *
     *   print the count of customer for all hotel_id
     *
     *   select count(customer_id) from customer group by hotel_id;
     *
     *   select count(customer.customer_d), hotel.hotel_name  from customer join hotel
     *   on customer.hotel_id = hotel.hotel_id group by hotel.hotel_id;
     */
}
