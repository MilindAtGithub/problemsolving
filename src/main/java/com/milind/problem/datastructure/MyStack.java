package com.milind.problem.datastructure;

public class MyStack <T> {

    class Node {
        Object T;
        Node previous;
    }
    Node top;

    public MyStack() {
        top = null;
    }

    /** 
     * This will return if stack is empty or not.
     */
    public boolean isEmpty(){
        return top==null;
    }
    /**
     * Add to stack
     * @param object
     */
    public void push(Object object){

        Node node = new Node();
        node.T=object;
        node.previous = top;
        top=node;
    }
    /**
     * Pop the first element form stack.
     * @return
     */
    public T pop(){
        if(isEmpty())
            return null;
        else {
            Node temp = top;
            top = temp.previous;
            return (T) temp.T;
        }
    }

    public static void main(String[] args) {
        Integer i = 1;
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(i);
        i=2;
        myStack.push(i);
        i=3;
        myStack.push(i);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        i=-99;
        myStack.push(i);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
    
    
}
