package guru.springframework.jsonexample;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DomBankApplicationServlet extends HttpServlet {

    private  final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final JsonNode loanApplication = objectMapper.readTree(req.getInputStream());//if we pass curl / http request json file , we can parse it
        double totalIncome = getTotalIncome(loanApplication);
        double amount = getAmount(loanApplication);

        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.println("Total Income:" + totalIncome);
        outputStream.println("Amount = " + amount);

        if(amount <= 3 * totalIncome){
            resp.setStatus(HttpServletResponse.SC_OK);
            outputStream.println("Approved");
        }else{
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
            outputStream.println("Denied");
        }
    }

    private double getAmount(final JsonNode loanApplication) {
        JsonNode loanDetails = loanApplication.get("loanDetails");
        if(loanDetails != null){
            JsonNode amount = loanDetails.get("amount");
            return amount.asDouble();
        }
        return 0;
    }

    private double getTotalIncome(final JsonNode loanApplication) {
        double totalIncome = 0;
        JsonNode jobs = loanApplication.get("jobs");
        if(jobs != null){
           for(int i = 0;i < jobs.size();i++){
               JsonNode job = jobs.get(i);
               totalIncome += job.get("annualIncome").asDouble();
           }
        }
        return totalIncome;
    }

    public static void main(String args[]){
        SimpleJettyService.run(DomBankApplicationServlet.class);
    }

}
