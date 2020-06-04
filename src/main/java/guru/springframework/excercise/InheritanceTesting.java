package guru.springframework.excercise;

public class InheritanceTesting {

    public static void main(String[] args) {
        String name = "2222";
        int num = 33333;
        String s = String.valueOf ( num );
        Person obj1 = new Person ("ragu");
        System.out.println ( "--------" );
        Person obj2 = new ExtendedPerson ("ramya");
        System.out.println ( "--------" );
        ExtendedPerson obj3 = new ExtendedPerson ("Rafdfdf");

        Integer a = Integer.MAX_VALUE;
        Integer b = Integer.MIN_VALUE;
        System.out.println ( a + ":" + b );


    }

}
