package guru.springframework.collection;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class collectionExample {

    public static void main(String[] args) {

        Product sony = new Product ("sony tv", 4500);
        Product samsung = new Product ("samsun tv", 8999);
        Product nokia = new Product ("nokia tv", 3333);
        Product iphone = new Product ("iphone tv", 7687);

        //collection example
        Collection<Product> products = new ArrayList<> (  );
        products.add ( sony );
        products.add(samsung);
        products.add(nokia);

        //we can use iterator to loop through the collection or just simple for loop as below

        final Iterator<Product>  iterator = products.iterator ();

        while(iterator.hasNext ()){
            Product next = iterator.next ();
            System.out.println ( next );
        }
        System.out.println ( "-------------------" );
        for(Product current: products){
            Product product = current;
            System.out.println ( product );
        }

        System.out.println ( "-------------------" );

        //List example . two way of implementation Arraylist and linkedlist

        List<Product> listOfProduct = new ArrayList<> (  );
        listOfProduct.add ( sony );
        listOfProduct.add ( samsung );
        listOfProduct.add ( nokia );
        Product product = listOfProduct.get ( 0 );
        List<Product> products1 = listOfProduct.subList ( 0, 2 );
        System.out.println ( product );
        System.out.println ( listOfProduct );
        System.out.println ( products1 );
        
        //adding or removing a lot linked list is best

        System.out.println ( "--------SET EXAMPLE-----------" );
        //Set example . Implementation is hashset for anyorder and treeset for sorting
        
        Set<Product> setOfProducts = new HashSet<> (  );
        setOfProducts.addAll ( listOfProduct );
        Iterator<Product> iterator1 = setOfProducts.iterator ();
        while(iterator1.hasNext () ){
            System.out.println(iterator1.next ());
        }
        System.out.println ( "-------------------" );
        setOfProducts.remove ( sony );
        iterator1 = setOfProducts.iterator ();
        while(iterator1.hasNext () ){
            System.out.println(iterator1.next ());
        }

        //how manytimes we add it in  set  , only unique elements retained
        setOfProducts.add ( nokia );
        setOfProducts.add ( nokia );
        setOfProducts.add ( nokia );
        setOfProducts.add ( nokia );
        setOfProducts.add ( nokia );
        setOfProducts.add ( nokia );
        System.out.println ( "-------------------" + setOfProducts.size () );

        iterator1 = setOfProducts.iterator ();
        while(iterator1.hasNext () ){
            System.out.println(iterator1.next ());
        }

        //for treeset implementation , we need sorting method like comparator

        System.out.println ( "--------Treeset example-----------");
        Comparator<Product> productComparator = new Comparator<Product> () {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.getPrice () > o2.getPrice ()) return -1;
                if(o1.getPrice () < o2.getPrice ()) return 1;
                return 0;
            }
        };


        SortedSet sortedSet = new TreeSet (  productComparator);
        sortedSet.addAll ( listOfProduct );
        Iterator iterator2 = sortedSet.iterator ();
        while(iterator2.hasNext () ){
            System.out.println(iterator2.next ());
        }
        System.out.println ( "-------------------");
        System.out.println (sortedSet.first ());

        System.out.println ( "--------Map example-----------");

        Map<Integer , Product> mapOfProduct = new HashMap<> (  );
        mapOfProduct.put ( 1,sony );
        mapOfProduct.put ( 2,samsung );
        mapOfProduct.put(3,nokia);

        System.out.println (mapOfProduct.get(2));
        System.out.println (mapOfProduct.getOrDefault ( 4,iphone ));

        //to process map like iterator we can use entryset
        Set<Entry<Integer, Product>> entries = mapOfProduct.entrySet ();

        for(Map.Entry<Integer,Product> current : entries){
            System.out.println(current.getKey () + "---> " + current.getValue ());
        }

        System.out.println ( "--------Stream example-----------");

        Collection<Product> streamExample =  mapOfProduct.values ();
        for(Product current: streamExample){
            System.out.println ( current );
        }

        System.out.println ( "---------------------------------");

        List<Product> subList = streamExample.stream ().filter ( x -> x.getName ().startsWith ( "s" ) ).collect ( Collectors.toList () );
        for(Product current: subList){
            System.out.println ( current );
        }

        //Treemap - balanced binary tree, EnumMap also present
    }

}
