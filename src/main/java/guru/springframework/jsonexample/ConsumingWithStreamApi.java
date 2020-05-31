package guru.springframework.jsonexample;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class ConsumingWithStreamApi {
    private static final File BANK_LOAN_FILE = new File("src/main/java/guru/springframework/jsonexample/bank_loan.json");

    public static void main(String args[]) throws IOException {
        JsonFactory jsonFactory = new JsonFactory();
        try(JsonParser parser = jsonFactory.createParser(BANK_LOAN_FILE)){
            JsonToken token;
            while((token = parser.nextToken()) != null){
                if(token.isScalarValue()){
                    String currentName = parser.getCurrentName();
                    if(currentName != null){
                        String text = parser.getText();
                        System.out.println(currentName + ':' + text);
                    }
                }
            }
        }
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


