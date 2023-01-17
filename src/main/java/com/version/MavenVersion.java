package com.version;

import com.keystore.JKStoBase64;

public class MavenVersion {


    public static void main(String[] args) {
        
        System.out.println(MavenVersion.class.getPackage().getImplementationVersion());
    }


    
}
