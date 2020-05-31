package guru.springframework.excercise;

public class RecursiveSumOfString {

    public static void main(String[] args) {
        String listOfString[] = {"Ragu","333","3A","TIENSESTRATT","4020","odoo","-400"};
        int totalStringCount = listOfString.length;
        System.out.println(sumofall(listOfString, totalStringCount,0));

    }

    public static int sumofall(String[] listOfString, int totalStringCount, int sum)
    {
        if (totalStringCount == 0)
            return sum;
        sum = sum + tryParse(listOfString[totalStringCount-1]);
        totalStringCount = totalStringCount - 1;
        return sumofall(listOfString,totalStringCount,sum);

    }


    public static int tryParse(String str) {
        int retVal;
        try {
            retVal = Integer.parseInt(str);
        } catch (NumberFormatException exc) {
            retVal = 0; // or null if that is your preference
        }
        return retVal;
    }
}

