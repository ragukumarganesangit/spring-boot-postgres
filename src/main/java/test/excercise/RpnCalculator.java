package test.excercise;

import java.util.Scanner;
import java.util.Stack;

public class RpnCalculator {

    private static boolean wrongExpression = false;
    private static boolean squareRootCheckOn = false;
    private static boolean stackConatinsDecimal = false;
    private static String stackDecimalString;
    private static int count = 0;
    private static double temp  = 0;
    private static int beforeDecimalPointCount = 0;
    private static StringBuilder squareRoot = new StringBuilder (  );

    public static void main(String[] args) {

        Scanner myObj = new Scanner( System.in);  // Create a Scanner object
        System.out.println("Enter expression to evaluate:");
        String expressionToParse = myObj.nextLine().replaceAll ( "\\s+","" );
        if(expressionToParse.isEmpty ()) {
            System.out.println ( "Enter Valid String!!!" );
            return;
        }
        Stack<Double> stack = new Stack<> ();
        StringBuilder decimalValue = new StringBuilder (  );

        int decimalCount = 0;
        System.out.println("String to Parse: " + expressionToParse);
        parseGivenExpression ( expressionToParse, stack, decimalValue, decimalCount );

        if(wrongExpression == false) {
            Double result = stack.pop ();
            outputPrinting ( stack, result );
        }

    }

    public static void outputPrinting(Stack<Double> stack, Double result) {
        if (stack.size () > 0) {
            System.out.println ("*****************************");
            System.out.print ( "Final Result:");
            Object[] objects = stack.toArray ();
            for (int j = 0; j < objects.length; j++){
                double temp = ((Number) objects[j]).doubleValue ();
                if(Math.abs(temp-Math.floor(temp)) < 0.001){
                    int temp1 = (int) temp;
                    System.out.print(temp1);
                }
                else
                    System.out.print(objects[j]);
            }

            if (stackConatinsDecimal == true){
                System.out.printf ( "%.0f", result);
                System.out.printf (stackDecimalString);
            }else System.out.printf ( "%.2f", result);
            System.out.println();
            System.out.println ("\n*****************************");
        } else {
            System.out.println ("*****************************");
            System.out.println ( "Final Result:" + result );
            if (stackConatinsDecimal == true){
                System.out.printf (stackDecimalString);
                System.out.println();
            }
            System.out.println ("*****************************");
        }
    }

    public static void parseGivenExpression(String expressionToParse, Stack<Double> stack, StringBuilder decimalValue,
            int decimalCount) {
        double firstElement;
        double secondElement;
        for(int i=0;i< expressionToParse.length ();i++)
        {
            if(wrongExpression == true){
                return;
            }
            char c = expressionToParse.charAt ( i );
            if(c == 's' || c == 'q' || c == 'r' || c == 't' || c == 'S' || c == 'Q' || c == 'R' || c == 'T' ) {
                if(squareRootCheckOn = false){
                    squareRootCheckOn = true;
                }
                checkForSquareRoot ( c );
                continue;
            }
            else
            {
                if  (squareRootCheckOn == true){
                    squareRootCheckOn = false;
                    String s1 = squareRoot.toString ().toUpperCase ();
                    if(s1.equals ( "SQRT" )){
                        c = 's';
                        i--;
                        if (squareRoot.length () > 0) squareRoot.delete ( 0,squareRoot.length () );
                    }
                    else{
                        System.out.println("Invalid String " +s1);
                        wrongExpression = true;
                        return;
                    }
                }
            }

            if(Character.isDigit ( c ))
            {
                stack.push(Double.parseDouble ( Character.toString ( c ) ));
                beforeDecimalPointCount++;
                if (stackConatinsDecimal == true) {
                    double  temp = stack.pop();
                    int temp1 = (int) temp;
                    decimalValue.append ( temp1 );
                    decimalCount++;
                }
            }
            else{
                if (c == '.'){
                    if(decimalValue.length () > 0)
                       decimalValue.delete ( 0,decimalValue.length () );
                    stackConatinsDecimal = true;
                    while (beforeDecimalPointCount > 0){
                        double  temp = stack.pop();
                        int temp1 = (int) temp;
                        decimalValue.append (temp1);
                        decimalCount++;
                        beforeDecimalPointCount--;
                    }
                    decimalValue.append ( c );
                    decimalCount++;
                    continue;
                }
                else{
                    if (stackConatinsDecimal == true)
                    {
                        String extarctFirstElemet = decimalValue.substring ( 0, decimalCount-1 );
                        String extractSecondElement = decimalValue.substring ( decimalCount-1 );
                        firstElement =  Double.parseDouble ( extarctFirstElemet );
                        secondElement =  Double.parseDouble ( extractSecondElement );
                        stackConatinsDecimal = false;
                        decimalCount = 0;
                    }
                    else
                    {
                        if(stack.size () == 0) {
                            if(c == 's') System.out.println ( "Square root comes in but no digits in stack!!!" );
                            else  System.out.println("Invalid Operator:" + c + " so cannot be processed");
                            wrongExpression = true;
                            return;
                        }
                        firstElement = stack.pop();
                        if(stack.size () == 0 || c == 's' )
                        {
                            if(c == 's'){
                                temp = Math.sqrt ( firstElement );
                                secondElement = 0;
                            }
                            else {
                                System.out.printf ( "Only one digit left to process.Wrong Expression!!! %.2f%c", firstElement, c );
                                wrongExpression = true;
                                return;
                            }
                        }
                        else
                            secondElement = stack.pop();
                    }
                }

                processOperator ( stack, firstElement, secondElement, c );

            }
        }

        if(stackConatinsDecimal == true)
            stackDecimalString = decimalValue.substring ( 0, decimalCount);
        if  (squareRootCheckOn == true){
            postProcessingOfSquareRoot ( stack );
        }
    }

    public static void postProcessingOfSquareRoot(Stack<Double> stack) {
        double firstElement;
        double secondElement;
        if(squareRoot.toString ().toUpperCase ().equals ( "SQRT" )){
            if(stack.size () == 0){
                System.out.println ( "Square root comes in but no digits in stack!!!" );
                wrongExpression = true;
                return;
            }
            firstElement = stack.pop();
            temp = Math.sqrt ( firstElement );
            secondElement = 0;
            processOperator ( stack, firstElement, secondElement, 's' );

        }
        else{
            System.out.println ( "Invalid String " + squareRoot.toString ().toUpperCase () );
            wrongExpression = true;
            return;
        }
    }

    public static void processOperator(Stack<Double> stack, double firstElement, double secondElement, char c) {
        switch(c)
        {
            case '+':
                temp = secondElement + firstElement;
                break;
            case '-':
                temp = secondElement - firstElement;
                break;
            case '/':
                temp = secondElement / firstElement;
                break;
            case '*':
                temp = secondElement * firstElement;
                break;
            case 's':
                break;
            default:
                System.out.println("Invalid Operator:" + c + " so cannot be processed");
                wrongExpression = true;
                return;
        }
        temp = Math.floor(temp * 100) / 100;
        stack.push(temp);
        count++;
        beforeDecimalPointCount = 0;
        System.out.println("After computation of " + count + " operator " + c + " is " + temp);
    }

    public static void checkForSquareRoot(char c){
        squareRootCheckOn = true;
        squareRoot.append ( c );
    }

}
