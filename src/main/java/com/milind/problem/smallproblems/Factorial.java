package com.milind.problem.smallproblems;

public class Factorial {

    public static void main(String[] args) {
        int x = 5;
        System.out.println(x+"! Factorial = "+factorial(x));
        x=19;
        System.out.println(x+"! Factorial = "+factorial(x));
        //System.out.println(factorialOfTwo(3, 4));
    }

    /**
     * This is the factorial program.
     * @param x
     * @return
     */
    static int factorial(int x){
        if(x != 1){
            x *= factorial(x-1);
        }
        return x;
    }

}
