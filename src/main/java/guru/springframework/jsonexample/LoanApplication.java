package guru.springframework.jsonexample;

import java.util.ArrayList;
import java.util.List;

public class LoanApplication {

    private String name;
    private String purposeOfLoan;
    private LoanDetail loanDetails;
    private List<Job> Jobs = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurposeOfLoan() {
        return purposeOfLoan;
    }

    public void setPurposeOfLoan(String purposeOfLoan) {
        this.purposeOfLoan = purposeOfLoan;
    }

    public LoanDetail getLoanDetails() {
        return loanDetails;
    }

    public void setLoanDetails(LoanDetail loanDetails) {
        this.loanDetails = loanDetails;
    }

    public List<Job> getJobs() {
        return Jobs;
    }

    public void setJobs(List<Job> Jobs) {
        this.Jobs = Jobs;
    }

    @Override
    public String toString() {
        return "LoanApplication{" +
                "name='" + name + '\'' +
                ", purposeOfLoan='" + purposeOfLoan + '\'' +
                ", loanDetails=" + loanDetails +
                ", Jobs=" + Jobs +
                '}';
    }
}
