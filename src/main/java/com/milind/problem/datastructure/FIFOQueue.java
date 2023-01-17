package com.milind.problem.datastructure;

import java.util.HashMap;
import java.util.Map;

public class FIFOQueue {

    public class Node<T>
    {
        T value;
        Node <T> next;
        public T getValue(){
            return value;
        }
    }    

    Node<Object> head =null;
    Node<Object> tail = null;

    public void push(Object obj){
        Node<Object> node = new Node<Object>();
        node.value=obj;
        if(this.head == null){
            this.head = node;
            this.tail=node;
        } else {
            this.tail.next =node;
            this.tail=node;
        }
    }

    public Object pop(){
        if(this.head == null)
            return null;
        Node<Object> tempNode = this.head;
        this.head = head.next;
        return tempNode.value;
    }

    public static void main(String[] args) {
        
        FIFOQueue fifoQueue = new FIFOQueue();
        fifoQueue.push("One");
        fifoQueue.push("two");
        fifoQueue.push("three");
        System.out.println(fifoQueue.pop());
        System.out.println(fifoQueue.pop());
        fifoQueue.push("four");
        System.out.println(fifoQueue.pop());
        System.out.println(fifoQueue.pop());
        System.out.println(fifoQueue.pop());
        fifoQueue.push("five");
        System.out.println(fifoQueue.pop());

  
        
    }
}
