package guru.springframework.exception;

public class FunctionalException extends RuntimeException {

    private static final String FUNCTIONAL_ERROR = "Functional error %S ";
    private final ErrorCode errorCode;
    private final String title;

    public FunctionalException(ErrorCode errorCode) {
        super(String.format(FUNCTIONAL_ERROR, errorCode.toString()));
        this.errorCode = errorCode;
        this.title = (errorCode.getCode() + ": " + errorCode.getTitle());
    }

    public FunctionalException(ErrorCode errorCode, String message) {
        super(String.format(FUNCTIONAL_ERROR, errorCode.toString()));
        this.errorCode = errorCode;
        this.title = message;
    }

    public static String getFunctionalError() {
        return FUNCTIONAL_ERROR;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getTitle() {
        return title;
    }
}
