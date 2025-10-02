import java.util.LinkedList;
import java.util.Queue;

public class SharedList {
    private final Queue<Integer> list = new LinkedList<>();
    private final int MAX_SIZE = 5; 

    public synchronized void produce(int value) throws InterruptedException {
        // Região Crítica: Checagem e modificação da lista. Protegida por 'synchronized'.
        // O 'while' garante que a thread sempre recheque a condição após ser notificada .
        while (list.size() == MAX_SIZE) {
            System.out.println("-> Produtor esperando (T1): Lista Cheia (" + list.size() + ")");
            // Libera o lock e espera.
            wait();
        }

        list.add(value);
        System.out.println("Produzido: " + value + " | Tamanho atual: " + list.size());

        // Notifica T2 que há um item disponível.
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (list.isEmpty()) {
            System.out.println("<- Consumidor esperando (T2): Lista Vazia");
            // Libera o lock e espera.
            wait();
        }

        int value = list.poll();
        System.out.println("Consumido:  " + value + " | Tamanho atual: " + list.size());

        // Notifica T1 que há espaço disponível.
        notifyAll();

        return value;
    }
}
