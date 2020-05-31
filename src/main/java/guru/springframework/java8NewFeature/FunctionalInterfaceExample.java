package guru.springframework.java8NewFeature;

/*
Functional Interfaces#

How does lambda expressions fit into Javas type system? Each lambda corresponds to a given type, specified by an interface.
A so called functional interface must contain exactly one abstract method declaration.
Each lambda expression of that type will be matched to this abstract method.
Since default methods are not abstract you're free to add default methods to your functional interface.

We can use arbitrary interfaces as lambda expressions as long as the interface only contains one abstract method.
To ensure that your interface meet the requirements, you should add the @FunctionalInterface annotation.
The compiler is aware of this annotation and throws a compiler error as soon as you try to add a second abstract method declaration to the interface.
 */

public class FunctionalInterfaceExample {
    public static void main(String args[]){
        Converter<String, Integer> converter = new Converter<String, Integer> () {
            @Override
            public Integer convert(String from) {
                return Integer.valueOf ( from );
            }
        };

        Integer convert = converter.convert ( "123" );
        System.out.println ( convert );

        //the above can be converted into Lambda

        Converter<String, Integer> converter1 = (from)  -> Integer.valueOf ( from );

        Integer convert1 = converter1.convert ( "123" );
        System.out.println ( convert1 );

    }
}


@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
    //F method3(T from);   you are not allowed to add more than one abstract method
}
