package generics;

import utils.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @param <T>
 *
 *     1. Generics is used for type safety in Java
 *     2. Generics are checked in compile time
 *     3. Class level generics
 *     4. Method level generics
 *     5. wild cards in generics
 */
public class GenericsInJava<T extends Thread&Callable> {
    T variable=null;

    List<T> threads;

    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public GenericsInJava(List<T> threads) {
        this.threads = threads;
    }

    public void processThread(){

        String type = threads.stream().findAny().map((thread)-> {
            if(thread instanceof Callable<?>){
                return "callable";
            }else {
                return "runnable";
            }
        }).orElse("empty");

        if("callable".equals(type)){
            threads.stream().forEach((thread)-> {
                Future obj = executorService.submit((Callable<?>) thread);
            });
        }else if("runnable".equals(type)){
            threads.stream().forEach((thread) -> {
                executorService.submit((Runnable) thread);
            });
        }
    }

    public static void main(String[] args){
        TypeSafety.showTypeSafetyExample();
        CustomNode<Integer> students = new CustomNode<>();
    }
}



class MyNode {
    String data;
    MyNode prevNodeRef;
    MyNode nextNodeRef;

}


class CustomNode<T> {
    T data;

    CustomNode prevNodeRef;

    CustomNode nextNodeRef;

    Integer length;

    /**
     * Method generics
     * @param num
     * @return
     * @param <K>
     */
    public <K extends Number> K getDataLength(K num){
        return num;
    }

    /**
     * wildcard
     *
     */


    public void lowerBoundWildCard(List<? extends Number> num){
        System.out.println(num.stream().findFirst().get() instanceof Integer);

    }

    public void UpperBoundWildCard(List<? super Integer> num){
    }

}

class TypeSafety {

    public static void showTypeSafetyExample(){
        List sample = new ArrayList();
        sample.add("string");

        //Integer num = (Integer) sample.get(0);
    }

    public static void checkedInCompileTime(){
        List<String> sample = new ArrayList<>();
        //sample.add(5);
    }
}