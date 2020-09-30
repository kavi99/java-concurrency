package sync;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Operation implements Runnable {
    private final String fileName;
    private final Counter counter;
    private final String PATH = "/Users/ykavi/Desktop/java-odev/src/main/java/sync/";

    public Operation(String fileName, Counter counter) {
        this.fileName = fileName;
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            File file = new File(PATH + fileName + ".txt");
            FileInputStream fis = new FileInputStream(file);
            byte[] bytesArray = new byte[(int) file.length()];
            fis.read(bytesArray);
            String s = new String(bytesArray);
            String[] data = s.split(" ");
            int wordNumber = 0;
            for (int i = 0; i < data.length; i++) {
                wordNumber++;
                counter.increase();
            }
            System.out.println(fileName + "'nin kelime sayısı : " + wordNumber);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
