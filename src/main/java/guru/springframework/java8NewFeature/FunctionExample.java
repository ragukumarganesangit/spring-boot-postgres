package guru.springframework.java8NewFeature;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String args[]){

        /*Functions accept one argument and produce a result.
        Default methods can be used to chain multiple functions together (compose, andThen).
         */

        Function<String, Integer> toInteger = Integer::valueOf;   //Implementation is String converted to Integer
        Function<String, String> backToString = toInteger.andThen(String::valueOf); //here again Integer converted to String

        Integer apply1 = toInteger.apply ( "123" );
        String apply2 = backToString.apply ( "123" );
    }
}
