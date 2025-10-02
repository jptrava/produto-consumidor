import java.util.Random;

/**
 * ProducerThread.java
 * Thread T1: Responsável por popular (produzir) valores na lista.
 */
public class ProducerThread extends Thread {
    private final SharedList sharedList;

    public ProducerThread(SharedList sharedList) {
        super("T1_Produtor");
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        Random rand = new Random();
        try {
          
            for (int i = 1; i <= 15; i++) {
                int value = rand.nextInt(100);
                sharedList.produce(value);

                Thread.sleep(rand.nextInt(100) + 50);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(getName() + " foi interrompida.");
        }
        System.out.println("\n*** " + getName() + " terminou de produzir. ***\n");
    }
}
