package com.milind.problem.simple.grades;

import java.util.Optional;

public class TestOptional {

    public static void main (String args[]){
        System.out.println("Test: "+check(null));
        System.out.println("Test: "+check("Test"));
        System.out.println("Test: "+check(""));
        String s= "o";

        switch (s){
            case "o":
                System.out.println("Print o");
                break;
            case "t":
                System.out.println(" T");
        }
    }

    public static String check(String s){

        Optional<String> str = Optional.ofNullable(s);
        //return  str.orElse("");
        return  str.isPresent()?str.get():null;
    }

}
