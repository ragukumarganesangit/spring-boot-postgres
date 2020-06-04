package guru.springframework.exception;

public enum ErrorCode {
    LE1454("LE1454", "Credit amount to high"),
    CO2022("CO2022", "The term is too long for the loan amount entered"),
    LL1259("LL1259", "ThirdPartyClient seems not to have an active contract"),
    AKC322("AKC322", "Percentage too large");

    private String title;
    private String code;

    ErrorCode(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }
}
