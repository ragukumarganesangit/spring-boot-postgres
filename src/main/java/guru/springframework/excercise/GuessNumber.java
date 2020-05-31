package guru.springframework.excercise;

import java.util.Random;

public class GuessNumber {
    private static final int MAXIMUM_RANGE = 1000000;
    private static final int MAXIMUM_ALLOWED_GUESS= 50;
    private static final int GREATER_VALUE = 1;
    private static final int LESSER_VALUE = -1;

    public static void main(String args[]){
        guessRandomNumber();
    }

    private static void guessRandomNumber() {
        Random randomGenerator = new Random();
        int randomNumber = 0;
        while(true){   //to have range from 1 to 1000000
            randomNumber = randomGenerator.nextInt(MAXIMUM_RANGE + 1);
            if(randomNumber != 0) break;
        }
        System.out.print("Random number is " + randomNumber + "\n");
        short guess = 1;
        int guessedNumber = MAXIMUM_RANGE / 2;
        int temp = guessedNumber;
        int verifyOutput;

        //Binary search
        while(guess <= MAXIMUM_ALLOWED_GUESS ){
            verifyOutput = verify(guessedNumber, randomNumber);
            temp = temp < 2 ? temp * 2 : temp / 2;

            if(verifyOutput == GREATER_VALUE){
                guessedNumber = guessedNumber - temp;
            }
            else if(verifyOutput == LESSER_VALUE) {
                guessedNumber = guessedNumber + temp;
            }
            else { //  VALUE MATCHED 0 outcome
                System.out.print("Number is guessed at " + guess + "th times and the number is " + guessedNumber);
                break;
            }
            guess += 1;
        }
    }

    public static int verify(int guessedNumber, int randomNumber){
        if(guessedNumber > randomNumber)
            return 1;
        else if(guessedNumber < randomNumber)
            return -1;
        else
            return 0;
    }
}
