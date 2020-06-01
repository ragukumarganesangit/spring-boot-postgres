package guru.springframework.java8NewFeature;

import java.util.Optional;

public class OptionalExample {

    /*Optionals are not functional interfaces, instead it's a nifty utility to prevent NullPointerException.
    Optional is a simple container for a value which may be null or non-null.
    Think of a method which may return a non-null result but sometimes return nothing. Instead of returning null you return an Optional in Java 8.
     */

    public static void main(String[] args) {

        Integer i = null;
        Integer j =  Optional.ofNullable ( i ).orElse ( 34 );
        System.out.println ( j );
    }

}
