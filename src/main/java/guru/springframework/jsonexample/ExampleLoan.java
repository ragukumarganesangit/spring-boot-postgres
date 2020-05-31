package guru.springframework.jsonexample;

import java.util.ArrayList;
import java.util.List;

public class ExampleLoan {
    public static final LoanApplication LOAN_APPLICATION;

    static{
        final LoanDetail loandetails = new LoanDetail();
        loandetails.setAmount(new Double(333));
        loandetails.setStartDate("2018-01-30");
        loandetails.setEndDate("2019-01-30");

        List<Job> jobs = new ArrayList<>();

        Job job = new Job();
        job.setTitle("Freelance Developer");
        job.setAnnualIncome(new Double(3444));
        job.setYearsActive(2);

        jobs.add(job);

        job = new Job();
        job.setTitle("KBC Developer");
        job.setAnnualIncome(new Double(844444));
        job.setYearsActive(5);

        jobs.add(job);

        LOAN_APPLICATION = new LoanApplication();

        LOAN_APPLICATION.setName("Ragu");
        LOAN_APPLICATION.setPurposeOfLoan("To build extenstion my house");
        LOAN_APPLICATION.setJobs(jobs);
        LOAN_APPLICATION.setLoanDetails(loandetails);

    }

}
