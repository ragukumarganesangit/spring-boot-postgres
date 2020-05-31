package guru.springframework.jsonexample;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AdvancedConsumingWithBindingApi {
    private static final File BANK_LOAN_FILE = new File("src/main/java/guru/springframework/jsonexample/bank_loan.json");
    public static void main(String args[]) throws IOException {
        //final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        //here if you see registermodule is added to hanlde LOcalDate deserialization from the string
        //if  we dont have registermodule , then it will abend

        //instead of using the default deserializer , we can customize it like below
        LocalDateDeserializer localDateDeserializer = new LocalDateDeserializer(DateTimeFormatter.ISO_LOCAL_DATE);
        final SimpleModule module = new SimpleModule().addDeserializer(LocalDate.class, localDateDeserializer);
        final ObjectMapper objectMapper = new ObjectMapper().registerModule(module);
        final AdvancedLoanApplication loanApplication = objectMapper.readValue(BANK_LOAN_FILE, AdvancedLoanApplication.class);
        System.out.println(loanApplication);
        printMemoryConsumption();   //this is just to understand how much memry consumed
    }

    private static void printMemoryConsumption()
    {
        System.gc();
        final MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        final MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        System.out.printf("Used memory:  %dK%n", heapMemoryUsage.getUsed()/1024);
    }

}
