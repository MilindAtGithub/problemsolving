package com.milind.problem.simple;

//import javax.xml.bind.SchemaOutputResolver;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Executable {

    public static void main(String args[]) throws Exception{

        Consumer<String> consumer = s -> {
            System.out.println("Consumer Call In Thread: "+ Thread.currentThread()+ " With Value: "+s);
        };
        ExecutorService executorService =
                new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>());
        executorService.submit(new MyTask(consumer));
        System.out.println(" Sleep thread for 12 Sec: "+ Thread.currentThread());
        TimeUnit.SECONDS.sleep(12);
        executorService.submit(new MyTask(consumer));
        executorService.shutdown();
        System.out.println("Bye");
    }
}

class MyTask implements Runnable{

    Consumer<String> c;

    public MyTask(Consumer<String> c) {
        this.c = c;
    }

    public void run(){
        System.out.println("Sleep the Thread: "+Thread.currentThread()+ " For 10 Sec");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        c.accept("Test From Milind"+System.nanoTime());
    }
}
