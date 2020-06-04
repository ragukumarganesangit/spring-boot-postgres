package guru.springframework.excercise;

public  class Person {

    private String name;

    public Person(){
        System.out.println ( "Person Object" );
    }

    public Person(String name) {
        this.name = name;
        System.out.println ( "Person Object argument constructor" );
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String additionakMethod(){
        return "Ragudsdsd";
    }

}
