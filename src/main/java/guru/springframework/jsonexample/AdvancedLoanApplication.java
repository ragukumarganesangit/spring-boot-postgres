package guru.springframework.jsonexample;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class AdvancedLoanApplication {

    @JsonProperty("name")
    private String applicantName;
    private String purposeOfLoan;
    private AdvancedLoanDetail loanDetails;
    private List<Job> Jobs = new ArrayList<>();

    public String getName() {
        return applicantName;
    }

    public void setName(String name) {
        this.applicantName = name;
    }

    public String getPurposeOfLoan() {
        return purposeOfLoan;
    }

    public void setPurposeOfLoan(String purposeOfLoan) {
        this.purposeOfLoan = purposeOfLoan;
    }

    public AdvancedLoanDetail getLoanDetails() {
        return loanDetails;
    }

    public void setLoanDetails(AdvancedLoanDetail loanDetails) {
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
                "name='" + applicantName + '\'' +
                ", purposeOfLoan='" + purposeOfLoan + '\'' +
                ", loanDetails=" + loanDetails +
                ", Jobs=" + Jobs +
                '}';
    }
}
