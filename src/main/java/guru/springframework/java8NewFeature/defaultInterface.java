package guru.springframework.java8NewFeature;

//Java 8 enables us to add non-abstract method implementations to interfaces by utilizing the default keyword. This feature is also known as Extension Methods

public class defaultInterface implements Formula  {

    @Override
    public double calculate(int a) {
        return 0;
    }


    //here if you see we implemented only calculate .for sqrt we use the default implementation.
}


interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
