package threads;

public class OddEvenPrint {
    private Integer num = 0;
    private Integer maxNum;
    OddEvenPrint(int maxNum){
        this.maxNum = maxNum;
    }

    public void printEven(){
       synchronized (this){
           while (num <= maxNum) {
               if(num % 2 != 0){
                   try {
                       wait();
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
               }
               System.out.println("{ " + "\n" +
                       "threadName: " + Thread.currentThread().getName() + " \n"+
                       "num: " + num + "\n" +
                       "}");
               num++;
               notifyAll();
           }
       }
    }
    public void printOdd(){
        synchronized (this){
            while (num <= maxNum) {
                if(num %2 != 1){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("{ " + "\n" +
                        "threadName: " + Thread.currentThread().getName() + " \n"+
                        "num: " + num + "\n" +
                        "}"
                );
                num++;
                notifyAll();
            }
        }
    }

    public static void main(String[] args){

        OddEvenPrint oddEvenPrint = new OddEvenPrint(100);

        Runnable even = ()->{
            oddEvenPrint.printEven();
        };

        Runnable odd = ()->{
            oddEvenPrint.printOdd();
        };

        Thread evenThread = new Thread(even);
        evenThread.setName(":::even-thread:::");

        Thread oddThread = new Thread(odd);
        oddThread.setName(":::odd-thread:::");

        evenThread.start();
        oddThread.start();
    }
}
