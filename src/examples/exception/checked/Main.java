package examples.exception.checked;

public class Main {


    public static void main(String [] args){
        ParentClass p = new AnotherChildClassWithDifferentExceptions();
        p.process();
    }
}
