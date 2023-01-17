package com.encode_decode;

import java.util.Base64;

public class MyBase64 {
    public static void main(String[] args) {
        //Test
        String str = "milind.d";
        System.out.println("Original String: "+str);
        str= new String(Base64.getEncoder().encode(str.getBytes()));
        System.out.println("Encoded String: "+str);
        System.out.println("Remvoing = in the base64 Starts .... ");
        byte bytes[] = Base64.getDecoder().decode(str);
        bytes = padBase64ToRemoveEqual(bytes, " ");
        System.out.println("Original String after Padding : "+new String(bytes));
        str = new String(Base64.getEncoder().encode(bytes));
        System.out.println("Encoded String after Padding:"+str);
        System.out.println("Final Decoded: "+ new String( Base64.getDecoder().decode(str)).trim());

        //Hayath sample
        str = "JljGSbRlT20FDVcFcrUQrznZUhRbhVzhFtFLmRMTmCs=";
        System.out.println("Hayath Encoded String: "+str);
        System.out.println("Encoded Hayath string after Padding: "+
        new String(Base64.getEncoder().encode( 
                                    padBase64ToRemoveEqual(
                Base64.getDecoder().decode(str),"#")))
        );
    }
    
    static byte[] padBase64ToRemoveEqualOld(byte bytes[], String padStr){
            int noOfPads = 3 - bytes.length%3;
            if(noOfPads==0)
                return bytes;
            byte[] newBytes = new byte[bytes.length+noOfPads];
            for(int i=0; i<newBytes.length; i++)
                newBytes[i]= (i<bytes.length)?bytes[i]:padStr.getBytes()[0];
            return newBytes;
    }
    static byte[] padBase64ToRemoveEqual(byte bytes[], String padStr){
        int noOfPads = 3 - (bytes.length%3==0?3:bytes.length%3);
        byte[] newBytes=noOfPads>0?new byte[bytes.length+noOfPads]:null;
        for(int i=0; noOfPads >0 && i<newBytes.length; i++)
            newBytes[i]= (i<bytes.length)?bytes[i]:padStr.getBytes()[0];
        return noOfPads>0?newBytes:bytes;
    }
}
