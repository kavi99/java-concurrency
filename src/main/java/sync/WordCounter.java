package sync;

public class WordCounter implements Counter {
    int count = 0;

    @Override
    public synchronized void increase() {
        count++;
    }

    @Override
    public int get() {
        return count;
    }
}
