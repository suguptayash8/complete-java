package utils;

public class EvenOdd {

    private Integer num = 0;

    private Integer maxNum;

    EvenOdd(Integer maxNum){
        this.maxNum = maxNum;
    }


    public void printEven(){
       synchronized (this){
           while(this.num < maxNum){
               if(num % 2  != 0 ){
                   try {
                       wait();
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
               }
               System.out.println("{" + "\n" +
                            "threadName: " + Thread.currentThread().getName()  + "\n" +
                       "number: " + this.num + "\n"
                       +"}"
                            );

               num++;
               notifyAll();
           }
       }
    }

    public void printOdd(){
        synchronized (this){
            while(this.num < maxNum){
                if(num % 2  == 0 ){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("{" + "\n" +
                        "threadName: " + Thread.currentThread().getName()  + "\n" +
                        "number: " + this.num + "\n"
                        +"}"
                );

                num++;
                notifyAll();
            }
        }
    }

    public static  void main(String args[]){

        EvenOdd evenOdd = new EvenOdd(100);

        Runnable r1 = ()->{
            evenOdd.printEven();
        };

        Runnable r2 = ()->{
            evenOdd.printOdd();
        };

        Thread evenThread = new Thread(r1);
        evenThread.setName("Even-Thread");

        Thread oddThread = new Thread(r2);
        oddThread.setName("Odd -Thread");

        evenThread.start();
        oddThread.start();;
    }
}

