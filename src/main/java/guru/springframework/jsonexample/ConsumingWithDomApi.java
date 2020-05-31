package guru.springframework.jsonexample;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Map;

public class ConsumingWithDomApi {
    private static final File BANK_LOAN_FILE = new File("src/main/java/guru/springframework/jsonexample/bank_loan.json");
    public static void main(String args[]) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(BANK_LOAN_FILE);  //representing single node in hierarchy of tree
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        //System.out.println(objectWriter.writeValueAsString(jsonNode));

        validateDates(jsonNode);
        printMemoryConsumption();   //this is just to understand how much memry consumed
    }

    private static void validateDates(JsonNode jsonNode) {
        Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
        while (fields.hasNext()){
            Map.Entry<String, JsonNode> field = fields.next();
            String fieldName = field.getKey();
            JsonNode childNode = field.getValue();
            if (childNode.isTextual() && fieldName.endsWith("Date")){
                System.out.println("Found field name " + fieldName);
                String fieldValue = childNode.textValue();
                try {
                    DateTimeFormatter.ISO_LOCAL_DATE.parse(fieldValue);
                }
                catch(DateTimeException e){
                    System.out.println("Invalid value " + fieldValue);
                }
            }
            validateDates(childNode);
        }

    }

    private static void printMemoryConsumption()
    {
        System.gc();
        final MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        final MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        System.out.printf("Used memory:  %dK%n", heapMemoryUsage.getUsed()/1024);
    }
}
