package com.milind.problem.smallproblems;
/**
 * divide this farm evenly into square plots
 * figure out the largest square size you can use for a plot of
*   land
*   Example farm size 50 * 25 Largest square plot will be 25*25
*   Farm size 1680 * 640 Largest square plot will be 80 *80
*/
public class LargetSquareSize {

    
    static int largestSquareSize(int length, int width){
        if(length==width || length == 0 || width==0)
            return length==0?width:width==0?length:width;
        else{
            if(length<width){
                return largestSquareSize(length, width%length);
            }else{
                return largestSquareSize(length%width, width);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Largest Square: "+ largestSquareSize(50, 25));
        System.out.println("Largest Square: "+ largestSquareSize(1680, 640));
    }
}   
