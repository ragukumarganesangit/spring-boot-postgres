package guru.springframework.java8NewFeature;

import guru.springframework.java8NewFeature.MethodReferenceExample.Person;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionExample {
    public static void main(String args[]){

        //in built Functional Interfaces .In all this we can use Lambda expression
        //Function
        //Supplier
        //Consumer
        //Comparator
        //Predicate


        /*Functions accept one argument and produce a result.
        Default methods can be used to chain multiple functions together (compose, andThen).
         */

        Function<String, Integer> toInteger = Integer::valueOf;   //Implementation is String converted to Integer
        Function<String, String> backToString = toInteger.andThen(String::valueOf); //here again Integer converted to String

        Integer apply1 = toInteger.apply ( "123" );
        String apply2 = backToString.apply ( "123" );


        /*Suppliers produce a result of a given generic type. Unlike Functions, Suppliers don't accept arguments.*/

        Supplier<Person> personSupplier = Person::new;
        Person person = personSupplier.get ();
        System.out.println ( person );

        /*Consumers represents operations to be performed on a single input argument.*/

        Consumer<Person> greeter = (x) -> {
            x.setFirstName ( "ragu" );
            x.setLastName ( "ganesan" );};

        greeter.accept ( person );
        System.out.println ( person );

        /*Comparators are well known from older versions of Java. Java 8 adds various default methods to the interface.*/

        Comparator<Integer> comparator = (x,y) -> {
            if (x==y) return 0;
            if (x > y) return -1;
            return 1;
        };

        List<Integer> listOfNumbers = Arrays.asList ( 56, 67, 44, 564 );
        Collections.sort( listOfNumbers,comparator);
        System.out.println ( listOfNumbers );

        //examples of some of new function of java8 with respect to predicate

        Predicate<String> predicate = (s) -> s.length() > 0;

        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
    }
}
