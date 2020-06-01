package guru.springframework.java8NewFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ParallelStreamsExample {

    public static void main(String[] args) {
        /*As mentioned above streams can be either sequential or parallel.
        Operations on sequential streams are performed on a single thread while operations on parallel streams are performed concurrent on multiple threads.
         */

        /*First we create a large list of unique elements:*/

        int max = 1000000;
        List<String> values = new ArrayList<> ( max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        //Now we measure the time it takes to sort a stream of this collection.

        //Sequential sort

        long t0 = System.nanoTime();

        long count = values.stream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis( t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));

        // sequential sort took: 899 ms


        //Parallel Sort

        long t2 = System.nanoTime();

        long count1 = values.parallelStream().sorted().count();
        System.out.println(count1);

        long t3 = System.nanoTime();

        long millis1 = TimeUnit.NANOSECONDS.toMillis(t3 - t2);
        System.out.println(String.format("parallel sort took: %d ms", millis1));

        // parallel sort took: 472 ms

        /*As you can see both code snippets are almost identical but the parallel sort is roughly 50% faster.
        All you have to do is change stream() to parallelStream().
         */


    }

}
