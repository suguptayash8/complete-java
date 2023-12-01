package collection.queue;

import java.util.*;
import java.util.concurrent.*;

public class BlockingQueue {

    public static void main(String[] args){
        blockingQueueImpl();
    }
    public static void blockingQueueImpl(){


        Queue<Integer> arrayQ = new ArrayBlockingQueue<>(10);
        //new LinkedBlockingQueue<>();

        ExecutorService es = Executors.newFixedThreadPool(4);
        List tasks = new ArrayList<>();

        TaskAddNumber.setArrayQ(arrayQ);
        tasks.add(new TaskAddNumber());

        TaskAddNumberB.setArrayQ(arrayQ);
        tasks.add(new TaskAddNumberB());

        TaskAddNumberC.setArrayQ(arrayQ);
        tasks.add(new TaskAddNumberC());

        TaskConsumer.setArrayQ(arrayQ);
        tasks.add(new TaskConsumer());

        try {
            List<Future<Boolean>> futureList = es.invokeAll(tasks);
            futureList.stream().forEach(future-> {
                try {
                    future.get();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
            es.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Queue<Integer> linkedQ = new LinkedBlockingQueue<>(10);

    }
}


class TaskAddNumber implements Callable {

    private static Queue<Integer> arrayQ;
    @Override
    public Boolean call() throws Exception {
        for(int i = 0; i < 1000; i++){
            Random random = new Random();
            int num = random.nextInt(1000);
            arrayQ.offer(num);
            System.out.println("Number added to queue: " + num);
        }
        return true;
    }

    public static void setArrayQ(Queue<Integer> arrayQ) {
        TaskAddNumber.arrayQ = arrayQ;
    }
}

class TaskAddNumberB implements Callable{

    private static Queue<Integer> arrayQ;

    @Override
    public Boolean call() throws Exception {

        Random random = new Random();

        for(int i = 0; i < 10000; i++){
            int num = random.nextInt(1000);
            arrayQ.offer(num);
            System.out.println("Number added to queue: " + num);
        }
        return true;
    }

    public static void setArrayQ(Queue<Integer> arrayQ) {
        TaskAddNumberB.arrayQ = arrayQ;
    }
}

class TaskAddNumberC implements Callable{

    private static Queue<Integer> arrayQ;
    @Override
    public Boolean call() throws Exception {
        Random random = new Random();
        for(int i = 0; i < 1000; i++){
            int num = random.nextInt(1000);
            arrayQ.offer(num);
            System.out.println("Number added to queue: " + num);
        }
        return true;
    }

    public static void setArrayQ(Queue<Integer> arrayQ) {
        TaskAddNumberC.arrayQ = arrayQ;
    }
}

class TaskConsumer implements Callable{
    private static Queue<Integer> arrayQ;
    @Override
    public Boolean call() throws Exception {
        while(true){
            if(!arrayQ.isEmpty()){
                System.out.println("number dequed: " + arrayQ.poll());
            }
        }
    }

    public static void setArrayQ(Queue<Integer> arrayQ) {
        TaskConsumer.arrayQ = arrayQ;
    }
}