package com.Multithreading;

import java.sql.Time;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(); // сколько потоков будет использоваться можно указать число newFixedThreadPool(5)
        executorService.submit( new MyRunable());
        executorService.submit(new MyCallable());
        System.out.println(executorService.submit(new MyCallable()));
        executorService.shutdown();

        System.out.println("------------ потоки по расписанию -----");
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(new MyRunable(), 5, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }

    static class MyRunable implements Runnable{ // создание потока Runnable
        @Override
        public void run() {
            System.out.println(1);
        }
    }

    static class MyCallable implements Callable<String>{ // создание потока Callable с возвращением эл.
        @Override
        public String call() throws Exception {
            System.out.println("2");
            return "3";
        }
    }
}
