package guru.springframework.excercise;

public class OutputIntegers {
    public static void main(String[] args) {
        //call method outputintegers
        outputintegers();
    }

    public static void outputintegers()
    {
        boolean multipleOfThree = false;
        boolean multipleOfSeven = false;
        for(int i=1;i<=99;i++) {
            if (i % 3 == 0 ) {
                multipleOfThree = true;
            }
            if(i % 7 == 0 ) {
                multipleOfSeven = true;
            }
            if (multipleOfThree && multipleOfSeven)
            {
                System.out.println("OpenSource");
            }
            else if (multipleOfThree)
            {
                System.out.println("Open");
            }
            else if (multipleOfSeven)
            {
                System.out.println("Source");
            }
            else
                System.out.println(i);

            multipleOfThree = false;
            multipleOfSeven = false;
        }
    }
}
