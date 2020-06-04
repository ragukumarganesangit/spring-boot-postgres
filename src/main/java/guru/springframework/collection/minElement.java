package guru.springframework.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class minElement  {

    public static void main(String[] args) {
        Product sony = new Product ("sony tv", 4500);
        Product samsung = new Product ("samsun tv", 78);
        Product nokia = new Product ("nokia tv", 3333);
        Product iphone = new Product ("iphone tv", 7687);

        List<Product> listOfProduct = new ArrayList<> (  );
        listOfProduct.add ( sony );
        listOfProduct.add ( samsung );
        listOfProduct.add ( nokia );
        Comparator<Product> comparator = new Comparator<Product> () {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice () < o2.getPrice ()) return -1;
                if (o1.getPrice () > o2.getPrice ()) return 1;
                return 0;
            }
        };
        Product lowestPriceProduct = listOfProduct.get ( 0 );
        for (int i=1;i<listOfProduct.size ();i++){
            if(comparator.compare ( lowestPriceProduct,listOfProduct.get(i) ) > 0 ){
                lowestPriceProduct = listOfProduct.get(i);
            }
        }
        System.out.println ( "Lowest Price Product is : " + lowestPriceProduct);
    }

}
