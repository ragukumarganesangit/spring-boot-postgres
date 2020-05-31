package guru.springframework.jsonexample;

//This is better way to serailize java object to json

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;

public class ProducingWithBindingApi {
    public static void main(String args[]) throws IOException {
        LoanApplication loanApplication = ExampleLoan.LOAN_APPLICATION;
        System.out.println(loanApplication);
        System.out.println();
        toJsonString(loanApplication);
    }

    private static void toJsonString(final LoanApplication loanApplication) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(System.out, loanApplication);
    }
}
