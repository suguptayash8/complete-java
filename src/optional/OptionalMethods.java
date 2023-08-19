package optional;

import java.util.Optional;

public class OptionalMethods {

    public static void main(String [] args){

        /**
         * Empty Optional
         * empty message
         */
        Optional<String> message = Optional.empty();
        if("random".equals(message.orElse("random"))){
            System.out.println("Or Else give optional value if it is there or else it will return value in or Else");
        };


        Optional<String> messageA = Optional.of("present");
        if("present".equals(messageA.orElse("not present"))){
            System.out.println("Printing present value and or else value will be not used");
        }


        /**
         * getting message from supplie
         */
        Optional<String> messageC = Optional.ofNullable(null);
        if("supplier".equals(messageC.orElseGet(()-> "supplier"))){
            System.out.println("Getting message from supplier");
        }


        try {
            Optional<String> messageD = Optional.ofNullable(null);
            if("message".equals(messageD.orElseThrow(()-> new NullPointerException()))){

            }
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }


        /***
         * [1-->2]
         */



    }
}
