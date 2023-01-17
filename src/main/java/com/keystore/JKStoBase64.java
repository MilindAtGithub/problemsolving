package com.keystore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class JKStoBase64 {

    public static void main(String[] args) throws IOException {

        String str= jksToBase64("C:\\Users\\milind.deobhankar\\Downloads\\hamster.jks");
        Files.writeString(Paths.get("C:\\Users\\milind.deobhankar\\Downloads\\base64.txt"), str, StandardCharsets.UTF_8);
        Files.write(Paths.get("C:\\Users\\milind.deobhankar\\Downloads\\hamagain.jks"), 
        Base64.getDecoder().decode(str));
    }

    private static String  jksToBase64(String filename)throws IOException{
        String str = Base64.getEncoder().encodeToString(readFile(filename));
        return str;
    }

    public static byte[] readFile(String file) throws IOException {  
        File f = new File(file);  
         // work only for 2GB file, because array index can only up to Integer.MAX  
        byte[] buffer = new byte[(int)f.length()];   
        FileInputStream is = new FileInputStream(file);   
        is.read(buffer);   
        is.close();   
        
        return buffer;  
    }


    
}
