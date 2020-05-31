package guru.springframework.jsonexample;

import java.util.List;

import static java.util.stream.Collectors.joining;

//This is manaul process of serailizing java object to JSON .There is better way to do than this bug code

public class ProducingWithStringFormats {
    public static void main(String args[]){
        LoanApplication loanApplication = ExampleLoan.LOAN_APPLICATION;
        System.out.println(loanApplication);
        System.out.println();
        System.out.println(toJsonString(loanApplication));
    }

    private static String toJsonString(final LoanApplication loanApplication){
        return String.format("{\n" +
                "  \"name\": \"%s\",\n" +
                "  \"purposeOfLoan\": \"%s\",\n" +
                "  \"loanDetails\": %s" +
                "  \"jobs\": %s" +
                "}\n",
                loanApplication.getName(),
                loanApplication.getPurposeOfLoan(),
                toJsonString(loanApplication.getLoanDetails()),
                toJsonString(loanApplication.getJobs())
                );
    }

    private static CharSequence toJsonString(final LoanDetail loanDetail){
        return String.format("{\n" +
                        "  \"amount\": \"%g\",\n" +
                        "  \"startDate\": \"%s\",\n" +
                        "  \"endDate\": \"%s\",\n" +
                        "}\n",
                loanDetail.getAmount(),
                loanDetail.getStartDate(),
                loanDetail.getEndDate()
        );
    }

    private static CharSequence toJsonString(final List<Job> jobs){
        return jobs.stream().map(x -> String.format("{\n" +
                        "  \"title\": \"%s\",\n" +
                        "  \"annualIncome\": %g,\n" +
                        "  \"yearsActive\": %s,\n" +
                        "}",
                x.getTitle(),
                x.getAnnualIncome(),
                x.getYearsActive())).collect(joining(",\n","[\n","\n]\n"));
    }
}
