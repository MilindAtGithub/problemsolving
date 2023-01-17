package com.milind.problem.simple;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class MyCompleteableFuture {


    public static void main (String args[]) throws Exception {

        CompletableFuture completeableFuture = CompletableFuture.supplyAsync(() ->{
            System.out.println("Thread Name: "+ Thread.currentThread());
            try{
                TimeUnit.SECONDS.sleep(5);
            }catch (Exception e){
                e.printStackTrace();
            }
            return "Milind";
        });
        completeableFuture.thenAccept(s->{
            System.out.println("Thread Name 1: "+ Thread.currentThread()+ "Value: "+s);
        } );
        System.out.println("Before Get");
       // completeableFuture.get();
        completeableFuture.join();
        System.out.println("After Get");
    }
}
