package guru.springframework.java8NewFeature;

import java.util.Objects;
import java.util.function.Predicate;

public class ScopeOfvariableINLambda {

    public static void main(String args[]){
        //Main concept here is varaible used inside to refer from Lambda should be final
        //even if we dont mention it will be considered as final
        //if we try to alter it then we will get compile time error

        final int num = 1;
        Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);

        String convert = stringConverter.convert ( 2 );// 3

        /*But different to anonymous objects the variable num does not have to be declared final. This code is also valid:*/

        int num1 = 1;
        Converter<Integer, String> stringConverter1 =
                (from) -> String.valueOf(from + num1);

        stringConverter.convert(2);     // 3

        /*However num must be implicitly final for the code to compile. The following code does not compile:*/

        int num2 = 1;
        Converter<Integer, String> stringConverter2 =
                (from) -> String.valueOf(from + num2);
        //num2 = 3;    ==> i cannot assing value for this , then error because num2 implicilty refers as final

        //examples of some of new function of java8 with respect to predicate

        Predicate<String> predicate = (s) -> s.length() > 0;

        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
    }

}
