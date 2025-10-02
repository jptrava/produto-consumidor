/**
 * Main.java
 * Classe principal para inicializar e executar as threads Produtora (T1) e Consumidora (T2).
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando cenário Produtor-Consumidor...");

        SharedList sharedList = new SharedList();

        // 2. Cria as threads T1 e T2, passando a mesma instância da lista
        ProducerThread t1 = new ProducerThread(sharedList); // Thread Produtora
        ConsumerThread t2 = new ConsumerThread(sharedList); // Thread Consumidora

        t1.start();
        t2.start();

        // Opcional: Usa join() para garantir que a thread principal espere
        // T1 e T2 terminarem suas tarefas antes de encerrar o programa.
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Execução principal finalizada.");
    }
}
