package guru.springframework.exception;

public class ClassTwo {

    static int i;
    int j;
    public static int needAsistacne(int a){
        ClassThree obj1 = new ClassThree ();
        int b = obj1.fetchValue ( a);
        return b;
    }

    static {
        i = 10;
        System.out.println ( "static block called" );
    }

    static void test(){
        System.out.println ( "test method called!!!" );
    }


}
