package guru.springframework.jsonexample;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BindingBankApplicationServlet extends HttpServlet {

    private  final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoanApplication loanApplication = objectMapper.readValue(req.getInputStream(), LoanApplication.class);//if we pass curl / http request json file , we can parse it


        double totalIncome = loanApplication.getJobs().stream().mapToDouble(Job::getAnnualIncome).sum();
        double amount = loanApplication.getLoanDetails().getAmount();

        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.println("Total Income:" + totalIncome);
        outputStream.println("Amount = " + amount);

        if(amount <= 3 * totalIncome){
            resp.setStatus(HttpServletResponse.SC_OK);
            outputStream.println("Approved");
        }else{
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
            outputStream.println("Denied!!!!");
        }
    }


    public static void main(String args[]){
        SimpleJettyService.run(BindingBankApplicationServlet.class);
    }

}
