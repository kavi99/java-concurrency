package com.thread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Reader implements Runnable {

    private String[] myFileNames = {"txt1", "txt2", "txt3", "txt4","txt5"};
    public static int TOTAL = 0, THREAD = 0;
    private final String PATH = "/Users/ykavi/Desktop/java-odev/src/main/java/com/thread/";

    public void wordCounter(){
        synchronized (this) {
                try {
                    File file = new File(PATH + myFileNames[THREAD] + ".txt");
                    FileInputStream fis = new FileInputStream(file);
                    byte[] bytesArray = new byte[(int) file.length()];
                    fis.read(bytesArray);
                    String s = new String(bytesArray);
                    String[] data = s.split(" ");
                    int wordNumber = 0;
                    for (int i = 0; i < data.length; i++) {
                        wordNumber++;
                    }
                    System.out.println(myFileNames[THREAD] + "'nin kelime sayısı : " + wordNumber +" - "+Thread.currentThread().getName());
                    TOTAL += wordNumber;
                    THREAD++;
                    System.out.println("Toplamda : " + TOTAL);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
    @Override
    public void run() {
        this.wordCounter();
    }
}
