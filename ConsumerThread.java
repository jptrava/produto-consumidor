import java.util.Random;

/**
 * ConsumerThread.java
 * Thread T2: Responsável por consumir e imprimir valores da lista.
 */
public class ConsumerThread extends Thread {
    private final SharedList sharedList;

    public ConsumerThread(SharedList sharedList) {
        super("T2_Consumidor");
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        Random rand = new Random();
        try {
        
            for (int i = 1; i <= 15; i++) {
                sharedList.consume();

                // Simula tempo de trabalho após consumir o item
                Thread.sleep(rand.nextInt(300) + 100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(getName() + " foi interrompida.");
        }
        System.out.println("\n*** " + getName() + " terminou de consumir. ***\n");
    }
}
