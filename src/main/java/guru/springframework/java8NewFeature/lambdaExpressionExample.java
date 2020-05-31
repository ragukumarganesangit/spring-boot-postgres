package guru.springframework.java8NewFeature;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class lambdaExpressionExample {

    public static void main(String args[]){
        List<String> names = Arrays.asList( "peter", "anna", "mike", "zen", "arun", "xenia");
        System.out.println(names);
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        System.out.println(names);


        //the above can be rewritten using lambda expression


        List<String> names1 = Arrays.asList( "peter", "anna", "mike", "zen", "arun", "xenia");
        Collections.sort(names1, ( a,  b) ->  b.compareTo(a));

        System.out.println(names1);


    }

}
