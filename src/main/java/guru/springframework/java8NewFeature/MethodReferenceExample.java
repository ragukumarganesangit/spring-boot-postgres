package guru.springframework.java8NewFeature;


public class MethodReferenceExample {

    public static void main(String args[]) {
        ConverterExample<String, Integer> converter = new ConverterExample<String, Integer> () {
            @Override
            public Integer convert(String from) {
                return Integer.valueOf ( from );
            }
        };

        Integer convert = converter.convert ( "123" );
        System.out.println ( convert );

        //the above can be converted into Lambda

        ConverterExample<String, Integer> converter1 = (from) -> Integer.valueOf ( from );

        Integer convert1 = converter1.convert ( "123" );
        System.out.println ( convert1 );

        //this example starts here. the above code further written with method referecne

        ConverterExample<String, Integer> converter2 = Integer::valueOf;
        Integer convert2 = converter2.convert ( "123" );
        System.out.println ( convert2 );

        /*Java 8 enables you to pass references of methods or constructors via the :: keyword.
        The above example shows how to reference a static method. But we can also reference object methods:
         */

        Something something = new Something ();
        Converter<String, String> converter3 = something::startsWith;   //here imp thing to note is we can refer anymethod for this interface implementation
        // but it should match with parameter type and return type
        String converted = converter3.convert ( "Java" );
        System.out.println ( converted );    // "J"

        /*Let's see how the :: keyword works for constructors.*/
        /*define person class*/
        /*Next we specify a person factory interface to be used for creating new persons:*/

        /*Instead of implementing the factory manually, we glue everything together via constructor references:*/

        PersonFactory<Person> person = Person::new;  //if we use new then its constructor method reference .
        // Once we call create method in the interface , then correct constructor will be called.
        Person person1 = person.create ( "ragu", "ganesan" );
        System.out.println ( person1 );

        /*We create a reference to the Person constructor via Person::new.
        The Java compiler automatically chooses the right constructor by matching the signature of PersonFactory.create.
         */
    }

    @FunctionalInterface
    interface ConverterExample<F, T> {

        T convert(F from);
        //F method3(T from);   you are not allowed to add more than one abstract method
    }


     static  class Something {

        String startsWith(String s) {
            return String.valueOf ( s.charAt ( 0 ) );
        }
    }


     static class Person {

        String firstName;
        String lastName;

        Person() {
        }

        Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

         public String getFirstName() {
             return firstName;
         }

         public void setFirstName(String firstName) {
             this.firstName = firstName;
         }

         public String getLastName() {
             return lastName;
         }

         public void setLastName(String lastName) {
             this.lastName = lastName;
         }

         @Override
         public String toString() {
             return "Person{" +
                     "firstName='" + firstName + '\'' +
                     ", lastName='" + lastName + '\'' +
                     '}';
         }
     }

    interface PersonFactory<P extends Person> {

        P create(String firstName, String lastName);
    }
}
