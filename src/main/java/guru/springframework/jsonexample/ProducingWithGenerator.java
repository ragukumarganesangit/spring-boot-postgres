package guru.springframework.jsonexample;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;

import java.io.IOException;

//This is another way of serializing java object to json using Generator API

public class ProducingWithGenerator {
    public static void main(String args[]) throws IOException {
        LoanApplication loanApplication = ExampleLoan.LOAN_APPLICATION;
        System.out.println(loanApplication);
        System.out.println();
        toJsonString(loanApplication);   //
    }

    private static void toJsonString(final LoanApplication loanApplication) throws IOException {
        JsonFactory jsonFactory = new JsonFactory();
        JsonGenerator generator = jsonFactory.createGenerator(System.out);  //generator wraps to underlying output
        generator.setPrettyPrinter(new DefaultPrettyPrinter());
        generator.writeStartObject();
        generator.writeStringField("name", loanApplication.getName());
        generator.writeStringField("purposeOfLoan",loanApplication.getPurposeOfLoan());
        generator.writeFieldName("loanDetails");
        generator.writeStartObject();
        generator.writeNumberField("amount", loanApplication.getLoanDetails().getAmount());
        generator.writeStringField("startDate", loanApplication.getLoanDetails().getStartDate());
        generator.writeStringField("endDate", loanApplication.getLoanDetails().getEndDate());
        generator.writeEndObject();
        generator.writeFieldName("jobs");
        generator.writeStartArray();
        for (final Job current: loanApplication.getJobs()){
            generator.writeStartObject();
            generator.writeStringField("title", current.getTitle());
            generator.writeNumberField("annualIncome", current.getAnnualIncome());
            generator.writeNumberField("yearsActive", current.getYearsActive());
            generator.writeEndObject();
        }

        generator.writeEndArray();
        generator.writeEndObject();
        generator.flush();
    }
}
