public class TransactionBuffer {
    private final int[] buffer = new int[5];
    private int count = 0;
    private int in = 0;
    private int out = 0;

    public synchronized void put(int amount) throws InterruptedException {
        while (count == buffer.length) {
            wait();
        }

        buffer[in] = amount;
        in = (in + 1) % buffer.length;
        count++;

        System.out.println("Produced transaction: " + amount);

        notifyAll();
    }

    public synchronized int take() throws InterruptedException {
        while (count == 0) {
            wait();
        }

        int amount = buffer[out];
        out = (out + 1) % buffer.length;
        count--;

        notifyAll();

        return amount;
    }
}