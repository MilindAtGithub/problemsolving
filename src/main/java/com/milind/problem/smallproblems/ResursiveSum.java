package com.milind.problem.smallproblems;

public class ResursiveSum {

    static int recursiveSum(int arr[], int indx){
        return arr ==null||arr.length==0?0:indx+1== arr.length?arr[indx]:arr[indx]+recursiveSum(arr, ++indx);
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5};
        System.out.println("Sum: "+recursiveSum(arr, 0));
        arr= new int[]{};
        System.out.println("Sum: "+recursiveSum(arr, 0));
        arr=null;
        System.out.println("Sum: "+recursiveSum(arr, 0));
    }
    
}
