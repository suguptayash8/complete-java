package functional.programing;

import java.util.function.Supplier;

public class SupplierInterface {

    public static void main(String[] args){
        Supplier<String> testSupplier = ()-> "random string";
        System.out.print(testSupplier.get());
    }
}
