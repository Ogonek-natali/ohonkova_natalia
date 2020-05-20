package ua.khpi.oop.Ohonkova13;

import ua.khpi.oop.Ohonkova13.Container;
import ua.khpi.oop.Ohonkova13.Threads;
import ua.khpi.oop.Ohonkova13.Store;

import java.io.IOException;
import java.util.concurrent.*;

public class Demo {

    public static void main(String[] args) throws IOException {
        //Lab13.main(new String[]{"-auto"});
        // Lab13.main(args);

        Container<Store> container = new Container<>();
        Store rec1 = new Store();
        Store rec2 = new Store();
        Store rec3 = new Store();

        rec1.setUnitPrice(1500);
        rec2.setUnitPrice(3000);
        for (int i = 0; i < 10000; i++) {
            container.add(rec1);
            container.add(rec2);
        }
        rec3.setUnitPrice(2500);
        for (int i = 0; i < 1200; i++) {
            container.add(rec3);
        }
        rec2.setUnitPrice(1900);
        container.add(rec2);
        rec2.setUnitPrice(3500);
        container.add(rec2);
        Threads.MyTread1 myTread1 = new Threads.MyTread1();
        myTread1.set(container);
        Threads.MyTread2 myTread2 = new Threads.MyTread2();
        myTread2.set(container);
        Threads.MyTread3 myTread3 = new Threads.MyTread3();
        myTread3.set(container);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Boolean> future = executorService.submit(myTread1);
        Future<Boolean> future1 = executorService.submit(myTread2);
        Future<Boolean> future2 = executorService.submit(myTread3);
        try {
            future.get(6, TimeUnit.SECONDS);
            future1.get(6, TimeUnit.SECONDS);
            future2.get(6, TimeUnit.SECONDS);
        } catch (TimeoutException | InterruptedException | ExecutionException ex) {
            future.cancel(true);
            future1.cancel(true);
            future2.cancel(true);
        }
        executorService.shutdown();

    }
}
