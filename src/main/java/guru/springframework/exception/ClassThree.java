package guru.springframework.exception;

import static guru.springframework.exception.ErrorCode.LE1454;

public class ClassThree {
    public int fetchValue(int a){
        if (a == 0 ){
            throw new FunctionalException ( LE1454 ); //intention to check how exception goes back
        }
      return 200;  //just some test value
    }

}
