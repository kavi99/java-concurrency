package sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WordCounterDemo {

    public static void main(String[] args) {

       final String[] myFileNames = {"txt1", "txt2", "txt3", "txt4","txt5"};
       final Counter counter = new WordCounter();
       final ExecutorService executorService = Executors.newCachedThreadPool();

        for (String file:myFileNames
             ) {
            executorService.submit(new Operation(file,counter));
        }

        executorService.shutdown();

        System.out.println("Toplam kelime sayısı : " + counter.get());
    }

}
