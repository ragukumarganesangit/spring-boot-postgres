package guru.springframework.excercise;

import java.io.*;

public class BinaryFileResizing {
    private static final String INPUT_FILE_NAME = "data.bin";
    public static void main(String args[]){
        try {
            File InFile = new File(INPUT_FILE_NAME);
            InFile.delete();  //just added to always recreate the file for testing different count
            if (!InFile.exists()){    //just creating sample file to demonstrate our goal
                fileCreation(INPUT_FILE_NAME, InFile);
            }
            System.out.println("Total File size before resizing:" + InFile.length() );
            System.out.println("Entering Resizing process");
            File outFile;
            outFile = File.createTempFile("swap", "buffer");

            InputStream inputStream = new FileInputStream(INPUT_FILE_NAME);
            OutputStream outputStream = new FileOutputStream(outFile);

            byte[] bytes = new byte[6];
            int byteCount = 0;
            int offset = 0;
            int length = 6;
            while (true) {
                int numberOfBytesRead = inputStream.readNBytes(bytes, offset, length);  //used readNBytes to read more bytes than reading one byte a time 
                if(numberOfBytesRead == 0) break;
                byteCount = byteCount + numberOfBytesRead;
                inputStream.skip(1);      //skipped every 7th byte 
                if(numberOfBytesRead == 6)
                  outputStream.write(bytes);
                else {
                    int counterToWriteOnlyReadBytes = 0;
                    while (counterToWriteOnlyReadBytes < numberOfBytesRead){
                        outputStream.write(bytes[counterToWriteOnlyReadBytes]);
                        counterToWriteOnlyReadBytes++;
                        numberOfBytesRead--;
                        if(numberOfBytesRead==0) break;
                    }
                }
            }
            InFile.delete();
            outFile.renameTo(InFile);
            System.out.println("Total File size after resizing:" + InFile.length());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void fileCreation(String inputFileName, File inFile) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(inputFileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream))
        {
            int loopCount = 0;
            while(true) {
                loopCount++;
                objectOutputStream.writeInt(2048);
                if(loopCount > 10000) break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File created with sample binary data!!!");
    }
}
