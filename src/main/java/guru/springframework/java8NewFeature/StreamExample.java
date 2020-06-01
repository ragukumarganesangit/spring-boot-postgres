package guru.springframework.java8NewFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

    /*A java.util.Stream represents a sequence of elements on which one or more operations can be performed.
    Stream operations are either intermediate or terminal. While terminal operations return a result of a certain type, intermediate operations return the stream itself so you can chain multiple method calls in a row.
    Streams are created on a source, e.g. a java.util.Collection like lists or sets (maps are not supported).
    Stream operations can either be executed sequential or parallel.
    Let's first look how sequential streams work. First we create a sample source in form of a list of strings: */

    public static void main(String[] args) {


        List<String> stringCollection = new ArrayList<> ();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        List<String> listStartWithA = stringCollection
                .stream ()
                .filter ( (s) -> s.startsWith ( "a" ) ).collect ( Collectors.toList () );

        System.out.println ( listStartWithA );

        stringCollection
                .stream ()
                .filter ( (s) -> s.startsWith ( "b" ) ).forEach ( System.out::println );


        //sorted
        /*Sorted is an intermediate operation which returns a sorted view of the stream.
         The elements are sorted in natural order unless you pass a custom Comparator.
         */


        stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        // "aaa1", "aaa2"

        /*Keep in mind that sorted does only create a sorted view of the stream without manipulating the ordering of the backed collection.
        The ordering of stringCollection is untouched:
         */

        System.out.println(stringCollection);
        // ddd2, aaa2, bbb1, aaa1, bbb3, ccc, bbb2, ddd1

        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);


        // "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"


        stringCollection
                .stream()
                .map(SubString::manipulateString)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

        //Match Option

        /*Various matching operations can be used to check whether a certain predicate matches the stream.
        All of those operations are terminal and return a boolean result.
         */

        boolean anyStartsWithA =
                stringCollection
                        .stream()
                        .anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStartsWithA);      // true

        boolean allStartsWithA =
                stringCollection
                        .stream()
                        .allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ =
                stringCollection
                        .stream()
                        .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true


        //Count Option

        /*Count is a terminal operation returning the number of elements in the stream as a long.*/

        long startsWithB =
                stringCollection
                        .stream()
                        .filter((s) -> s.startsWith("b"))
                        .count();

        System.out.println(startsWithB);    // 3


        //Reduce option

        /*This terminal operation performs a reduction on the elements of the stream with the given function.
        The result is an Optional holding the reduced value.
         */

        Optional<String> reduced =
                stringCollection
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);
// "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"


    }

}


