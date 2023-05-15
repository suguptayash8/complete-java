package future;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Completable {

    public static void testRunAsync() throws ExecutionException, InterruptedException{
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            List<Integer> random = new ArrayList<>();
            for(int i = 0; i < 1000; i++){
                random.add((int)new Random().nextInt());
            }
            System.out.print(random);
        });

        /**
         * If you want to rum some task in asyncronus then keep below get call commented
         */
        //completableFuture.get();

        /**
         * run async task
         */
        for(int i = 0; i <100; i++){
            System.out.println("Some other async task: " + i);
        }

        /**
         * get response from prev thread
         */
        //completableFuture.get();
    }

    public static void testSupplyAsync() throws ExecutionException, InterruptedException{
        CompletableFuture<List<Integer>> completableFuture = CompletableFuture.supplyAsync(()->{
            List<Integer> random = new ArrayList<>();
            for(int i = 0; i < 1000; i++){
                random.add((int)new Random().nextInt());
            }
            return random;
        });

        /**
         * If you want to rum some task in asyncronus then keep below get call commented
         */
        //completableFuture.get();

        /**
         * run async task
         */
        for(int i = 0; i <100; i++){
            System.out.println("Some other async task: " + i);
        }

        /**
         * get response from prev thread
         */
        System.out.print(completableFuture.get());

    }


    public static void main(String []args) throws ExecutionException, InterruptedException {
        //testRunAsync();
        testSupplyAsync();
    }
}
