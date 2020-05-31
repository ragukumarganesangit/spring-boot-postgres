package guru.springframework.excercise;

public class SumInListOfString {
    public static void main(String[] args) {
        String listOfString[] = {"Ragu","333","3A","TIENSESTRAAT","4020","odoo","-400"};
        int sumofall  = 0;
        for(String current:listOfString) {
            sumofall = sumofall + tryParse(current);
        }
        System.out.println("Sum of Integers are:" + sumofall);
    }
    //focussed only on integer types.But not on floating point
    public static int tryParse(String str) {
        int retVal;
        try {
            retVal = Integer.parseInt(str);
        } catch (NumberFormatException exp1) {
            retVal = 0;
        }
        return retVal;
    }

}
