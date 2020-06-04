package guru.springframework.excercise;

public class ExtendedPerson  extends Person{

    private String name;

    public ExtendedPerson(){
        super();
        System.out.println ( "ExtendedPerson Object" );
    }

    public ExtendedPerson(String name) {
        this.name = name;
        System.out.println ( "ExtendedPerson Object argument constrcutor" );
    }

    public String additionalMethodExtended(){
        return "Ramyafggggg";
    }

}
