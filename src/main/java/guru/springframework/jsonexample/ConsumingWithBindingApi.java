package guru.springframework.jsonexample;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Map;

public class ConsumingWithBindingApi {
    private static final File BANK_LOAN_FILE = new File("src/main/java/guru/springframework/jsonexample/bank_loan.json");
    public static void main(String args[]) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final LoanApplication loanApplication = objectMapper.readValue(BANK_LOAN_FILE, LoanApplication.class);
        System.out.println(loanApplication);
    }

}
