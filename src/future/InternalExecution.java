package future;

import callable.CustomCallable;
import callable.CustomCallableImpl;

import java.util.List;

public class InternalExecution {

    public static void main(String[] args){

        CustomCallableImpl customCallableImpl = new CustomCallableImpl();

        CustomFuture<List> customFuture = new CustomFuture<>(customCallableImpl);
        Runnable r1 = ()-> {
            customFuture.callCallable();
        };

        Thread t1 = new Thread(r1);
        t1.start();

        List<Double> data = customFuture.get();
        data.stream().forEach(System.out::println);
    }
}
