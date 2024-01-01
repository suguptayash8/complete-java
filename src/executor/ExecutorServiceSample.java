package executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceSample {

    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<List> apiDataA = ()->{
            List<Double> data = new ArrayList<>();
            for(int i = 0; i < 1000; i++){
                for (int j = 0; j< 1000; j++){
                    data.add(Math.floor(Math.random()*10));
                }
            }
            return data;
        };

        Callable<List> apiDataB = ()->{
            List<Double> data = new ArrayList<>();
            for(int i = 0; i < 1000; i++){
                for (int j = 0; j< 1000; j++){
                    data.add(Math.floor(Math.random()*10));
                }
            }
            return data;
        };

        List<Callable<List>> callablesTask  = new ArrayList<>();
        callablesTask.add(apiDataA);
        callablesTask.add(apiDataB);

        List<Future<List>> apiFetchedData;
        try {
            apiFetchedData =  executorService.invokeAll(callablesTask);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        apiFetchedData.stream().forEach(d-> {
            try {
                System.out.println(d.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.shutdown();
    }
}
