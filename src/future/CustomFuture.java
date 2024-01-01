package future;


import callable.CustomCallable;

import java.util.concurrent.FutureTask;


public class CustomFuture<T> {

    T data;

    private  Boolean isExecutionFinshed = false;

    private CustomCallable<T> customCallable;

    CustomFuture(CustomCallable<T> customCallable){
        this.customCallable = customCallable;
    }

    public void callCallable(){
        synchronized (this){
            this.data =  this.customCallable.call();
            isExecutionFinshed = true;
            notifyAll();
        }
    }


    public T get(){
        synchronized (this){
            if(!isExecutionFinshed){
                notifyAll();
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return data;
        }
    }

}

