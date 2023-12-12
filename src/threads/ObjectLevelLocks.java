package threads;

public class ObjectLevelLocks {
    public void methodA(){
        synchronized (this){
            for(int i = 0; i < 100; i++){
                System.out.println(i);
            }
        }
    }
    public void methodB(){
        synchronized (ObjectLevelLocks.class){
            for(int i = 0; i < 100; i++){
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args){
        ObjectLevelLocks objA = new ObjectLevelLocks();
        ObjectLevelLocks objB = new ObjectLevelLocks();

        Runnable r1 = ()->{ objA.methodA();};
        Runnable r2 = ()->{ objB.methodA(); };
        Runnable r3 = ()->{ objA.methodB(); };
        Runnable r4 = ()->{ objB.methodB(); };
        Runnable r5 = ()-> { objA.methodA(); };

        /**
         *  which of the following is correct
         *
         *  threads r1 and r2 will not run in parallel : incorrect , will run in parallel
         *  threads r1 and r3 will not run in parallel : incorrect , locks are different
         *  threads r1 and r5 will run one after another i.e. synchronously, correct
         *  threads r3 and r4 will run one after another i.e. synchronously, correct
         */
    }
}
