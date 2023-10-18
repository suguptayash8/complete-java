package optional;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalMethods {

    public static void main(String [] args){

        /**
         * Empty Optional
         * empty message
         *
         */
        Optional<String> message = Optional.empty();
        if("else".equals(message.orElse("else"))){
            System.out.println("1. Or Else give optional value if it is there or else it will return value in or Else");
        };


        Optional<String> messageA = Optional.of("present");
        if("present".equals(messageA.orElse("not present"))){
            System.out.println("2. Printing present value and or else value will be not used");
        }


        /**
         * getting message from supplier
         */
        Optional<String> messageC = Optional.ofNullable(null);
        if("supplier".equals(messageC.orElseGet(()-> "supplier"))){
            System.out.println("3. Getting message from supplier");
        }




        try {
            Optional<String> messageD = Optional.ofNullable(null);
            if("message".equals(messageD.orElseThrow(()-> new NullPointerException()))){
            }
        }catch (NullPointerException e){
            System.out.println("4. " + e.getMessage());
        }

        Optional<Integer> age = Optional.ofNullable(20);
        age.filter(num -> num > 16 ).ifPresent((num)-> System.out.println("5. " + num));
        age.filter( num -> num > 30).ifPresentOrElse((num)-> System.out.println("6. successfully passed"),
                ()-> System.out.println("7. failed to pass the age criteria"));

        System.out.println("7. " + age.map((num)-> num == 8 ? num + 2: num).filter(num-> num > 10).orElse(-1));

        boolean isOld = age.map((num)-> num > 60 ? true : false).orElse(false);
        if(age.isPresent()){
            age.get();
        }


    }
}
