package lesson20_HW;


import java.util.LinkedList;
import java.util.Queue;

class Store {
        private final Queue<String> products = new LinkedList<>();

        public synchronized void produce(String product) throws InterruptedException {
            while (products.size() == 3)
                wait();
            products.offer(product);
            System.out.println("Produced: " + product);
            notify();
        }

    public synchronized void consume() throws InterruptedException {
        while(products.isEmpty())
            wait();
        String product = products.poll();
        System.out.println("Consumed: "+ product);
        notify();
    }
}

    class Producer extends Thread{
        private final Store store;

        Producer(Store store) {
            this.store = store;
        }

        @Override
        public void run(){
            for(int i =1; i<=5; i++){
                try{
                    store.produce("Product" + i);

                } catch (InterruptedException _) {
                }
            }
        }
    }

    class Consumer extends Thread{
        private final Store store;

        Consumer(Store store) {
            this.store = store;
        }

        @Override
        public void run(){
            for(int i=1; i<=5; i++){
                try{
                    store.consume();
                } catch (InterruptedException _) {
                }
            }
        }
    }

public class Task3 {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        producer.start();
        consumer.start();
    }
}

