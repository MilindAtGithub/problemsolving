package com.milind.problem.sort;

import java.util.Arrays;

public class QuickSort {

    static void quickSort( int arr[], int beginIndx, int endIndx){
        if(beginIndx<endIndx){
            int partitionIndex = partitionIndex(arr, beginIndx, endIndx);
            quickSort(arr, beginIndx, partitionIndex-1);
            quickSort(arr, partitionIndex+1, endIndx);
        }
    }

    static int partitionIndex(int arr[], int begin, int end){
        int pivot = arr[end];
        int i = (begin-1);
        for(int j=begin; j<end; j++){
            if(arr[j]<=pivot){
                i++;
                int swap = arr[i];
                arr[i]=arr[j];
                arr[j]=swap;
            }
        }
        int swap = arr[i+1];
        arr[i+1]=arr[end];
        arr[end]=swap;
        return i+1;
    }
    
    static void print(int arr[]){
        Arrays.stream(arr).forEach(i -> System.out.println(i+","));
    }

    public static void main(String[] args) {
        
        int arr [] ={4,676,24,88,5,78,35,25,67,4,37};
        quickSort(arr, 0, arr.length-1);
        print(arr);
        System.out.println("   ");
        int[] arr1 = { 10, 7, 8, 9, 1, 5 };
        quickSort(arr1, 0, arr1.length-1);
        print(arr1);
    }
}
