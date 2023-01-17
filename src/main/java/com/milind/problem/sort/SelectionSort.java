package com.milind.problem.sort;

import java.util.Arrays;

/**
 * This is the simplest sort where you will find the minimum and swap the arrays.
 * Complexity is O(n2)
 */
public class SelectionSort {

    public static void main(String args[]){
        int arr[] = {70,3,9,5,-2,8,1};
        print(selectionSort(arr));
        int arr1[] = {5,3,3,7,0,-20,20};
        print(selectionSort(arr1));
    }

    public static int[] selectionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int smallIdx = getSmallestNbrIndx(arr,i);
            int temp =arr[smallIdx];
            arr[smallIdx]=arr[i];
            arr[i]=temp;
        }
        return arr;
    }

    public static int getSmallestNbrIndx(int arr[], int pos){
        int smallIndx = pos;
        for(int i=pos; i<arr.length; i++){
            if(arr[i]<arr[smallIndx]){
                smallIndx=i;
            }
        }
        return smallIndx;
    }

    public static  void print(int arr[]){
        System.out.println();
        Arrays.stream(arr).forEach(i -> System.out.print(i +","));
    }
}
