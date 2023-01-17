package com.keystore;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class JavaKeyStore {
    public static void main(String[] args) throws Exception {

        KeyStore keystore = loadKeyStore();
        Enumeration enumeration = keystore.aliases();
         while(enumeration.hasMoreElements()) {
            String alias = (String)enumeration.nextElement();
            X509Certificate certificate = (X509Certificate) keystore.getCertificate(alias);
            BigInteger serialNumber = certificate.getSerialNumber();
            System.out.println(alias+ "- "+ serialNumber);
         }
    }
    private static KeyStore loadKeyStore() throws Exception {
        String relativeCacertsPath = "/lib/security/cacerts".replace("/", File.separator);
        String filename = System.getProperty("java.home") + relativeCacertsPath;
        FileInputStream is = new FileInputStream(filename);
    
        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        String password = "changeit";
        keystore.load(is, password.toCharArray());
    
        return keystore;
    }
}

