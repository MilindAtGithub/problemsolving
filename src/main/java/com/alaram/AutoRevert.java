package com.alaram;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AutoRevert {

    public static void main(String[] args) throws InterruptedException {
        // Root 11:00
        Map <String, Thread> threadMap = new HashMap<>();
        String logger = "root";
        Revert r1 = new Revert(logger, "warn", 20);
        r1.start();
        threadMap.put(logger,r1);

        TimeUnit.SECONDS.sleep(7);
        Revert r2 = new Revert(logger, "dEBUG", 30);
        threadMap.get(logger).interrupt();
        r2.start();
        threadMap.put(logger,r2);
        logger="health";
        Revert r3 = new Revert(logger, "Error", 10);
        if(threadMap.get(logger) !=null) {
            threadMap.get(logger).interrupt();
        }
        r3.start();
        threadMap.put(logger,r3);
        TimeUnit.SECONDS.sleep(2);
        r3 = new Revert(logger, "Fatal", 30);
        if(threadMap.get(logger) !=null) {
            threadMap.get(logger).interrupt();
        }
        r3.start();
        threadMap.put(logger,r3);
    }
 
    
}


class Revert extends Thread {

    String loggerName;
    String intialLevel;
    long time;

    public Revert(String loggerName, String initialLevel, long time){
        this.loggerName=loggerName;
        this.intialLevel= initialLevel;
        this.time = time;
    }

    @Override
    public void run(){

        try {
            TimeUnit.SECONDS.sleep(time);
            System.out.println("Logger: "+ this.loggerName + "Reverted back to Original State: "+ this.intialLevel);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
           // e.printStackTrace();
           System.out.println("Thread Interupted ....");
        }
        
    }
}