package collection.queue;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/***
 * offer: add the element, no error if space is full
 * poll: retrives the head or first element and removing it, no error if q is empty
 * peek : retrives the head or first element inserted without removing it, no error if q is empty
 *
 */
public class UndersrstandQueue {

    public static void main(String[] args){
        //System.out.println(priorityQueueImplementation(3));
        //deQueueImplementation();
    }


    public static void linkedListImplementation(){
        Queue<String> testQueue = new LinkedList<>();
        testQueue.offer("elementA");
        testQueue.offer("elementB");
        testQueue.offer("elementC");

        while (!testQueue.isEmpty()){
            System.out.println(testQueue.peek());
            testQueue.poll();
        }

    }

    public static int priorityQueueImplementation(int k){
        int []arr = {11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };
        List<Integer> nums = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Queue<Integer> testQueue = new PriorityQueue<>();

        nums.stream().forEach(num->{
            testQueue.offer(num);
            //System.out.println(testQueue.peek());

            if(testQueue.size() > k ){
                testQueue.poll();
            }
        });

        return testQueue.poll();
    }

    public static void deQueueImplementation(){

        Deque<String> queueStack = new ArrayDeque<>();

        queueStack.offerFirst("elemntA");
        queueStack.offerFirst("elementB");
        queueStack.offerFirst("elementC");

        queueStack.offerLast("elementD");
        queueStack.offerLast("elementE");
        queueStack.offerLast("elementF");

        System.out.println(queueStack.peekFirst());
        System.out.println(queueStack.peekLast());
        System.out.println(queueStack.peek());

    }
}

