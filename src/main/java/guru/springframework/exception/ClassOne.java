package guru.springframework.exception;

import java.util.concurrent.Callable;

public class ClassOne {

    public static void main(String[] args) {
        try {
            calculateSum();
            ClassTwo.test ();
        }
        catch(Exception e){
            System.out.println ( "inside catch block of main method" );
            e.printStackTrace ();
        }
    }

    static void calculateSum(){
        ClassTwo obj1 = new ClassTwo ();
        int i = obj1.needAsistacne ( 1 );
        int j = i + 3;
        System.out.println ( j );
    }

    static class NestedClass {

    }
}
