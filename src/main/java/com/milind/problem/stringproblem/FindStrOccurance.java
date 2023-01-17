package com.milind.problem.stringproblem;

import java.util.Stack;

/**
 * This is the program to find out the no of occurance of string in text.
 * Example:
 * input:
 * string = "AC"
 * text = "DFVACSFRTACFOACC"
 * output:
 * count:3
 * 
 * @param args
 */
public class FindStrOccurance {

    public static void main(String[] args) {
        String str = "AC";
        String text = "DFVACSFRTACFOACC";
        System.out.println(getStrCountUsingNonStringFunction(str.toCharArray(), text.toCharArray()));
        System.out.println(getStrCountByStrFunc(str, text));
        str="AB";
        text="PQRST";
        System.out.println(getStrCountUsingNonStringFunction(str.toCharArray(), text.toCharArray()));
        System.out.println(getStrCountByStrFunc(str, text));
    }

    /**
     * Using non string function
     * @param str
     * @param text
     * @return
     */
    static int getStrCountUsingNonStringFunction(char str[], char text[]) {
        int count = 0;
        // Loop the text to find first occurance.
        for (int i = 0; i < text.length; i++) {
            if (text[i] == str[0]) {
                boolean match = true;
                for (int j = 0; j < str.length; j++) {
                    if (text[i + j] != str[j]) {
                        match = false;
                        break;
                    }
                }
                if (match)
                    count++;
            }
        }
        return count;
    }
    /**
     * Using String function
     * @param str
     * @param text
     * @return
     */
    static int getStrCountByStrFunc(String str, String text){
        int count=0;
        int incr=0;
        while(true){
            int indx = text.indexOf(str, incr);
            if(indx !=-1){
                count++;
                incr=indx+str.length();
            }else{
                break;
            }
        }
        return count;
    }

}
