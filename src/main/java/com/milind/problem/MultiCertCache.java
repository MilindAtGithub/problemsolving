package com.milind.problem;

import java.security.KeyStore;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Sample multicert Cache.
 */
public class MultiCertCache {

    // This is smaple please use the original cache Map
    private static Map<String, KeyStore> certCache= new HashMap<String, KeyStore>();

    // This is the map which will hold last used cert in case of multcerts.
    public static Map<String, LinkedList <String>> multiCertThresholdCache = 
        new HashMap<String, LinkedList<String>>();


    public static void main(String[] args) {
        String alias = "alias_siteId_jks";
        String oldAlias = new StringBuilder(alias).append("_old").toString();

        // Before threshold and new Cert Insert 
        certCache.put(alias, (KeyStore) new Object());
        //Update the expiry Date Map. Key alias -- Value : Expiry Date

        //After new cert insert and before threshold
        // Special Case at starup/keystore if two cert present and threashold not reached 
        //    Update the cert Cache  with alias = "alias_siteId_jks" and Content 
        //    of alias ="alias_siteId_jks_old" 
        // No change as threshold not reached.

        //After new cert insert and threshold reached.

        // Step-1 try will new cert alias 
        // For first time only  -- Get certs from MongoDB and not cache
        // Reload the cache locally.
        // Send event to kafka for both alias cache reload. "new" and "old" alias = alias_siteId_jks + alias =alias_siteId_Old_jks
        // New Cert Sucessfull
        // Reload the cache via kafka and pass the alias = alias+"_forMultiCert";
        // Code at kafka consumer end
        atKafkaConsumerEnd(alias+"_forMultiCert");

        // If the new Cert failed
        // Update the cert Cache locally and via kafka.
        certCache.put(oldAlias, (KeyStore) new Object());
        //Send to kafka and pass the aliad = oldAlias"_forMultiCert"
        //Code at kafka consumer end
        atKafkaConsumerEnd(oldAlias+"_forMultiCert");

        //GetKeyStoreCalls -- By Gatherer.
        // This will always with normal alias alias_siteId_jks
        tempGetKeyStore(alias);
    }


    /**
     * This will update the latest used cert  in the thrshold cache.
     * @param alias
     */
    //Key:  alias_siteId_jks --> alias_siteId_jks -> alias_siteId__old_jks
    //KEY:  alias_siteId_Old_jks-->alias_siteId_jks -->
    public static void updateThresholdCache(String alias){
        // if old_alias is send key should be alway alias_siteId_jks
           if(multiCertThresholdCache.get(alias)== null) 
                multiCertThresholdCache.put(alias, new LinkedList<>(Arrays.asList(alias)));
            else
                multiCertThresholdCache.get(alias).add(alias);
    }

    public static void clearThreshold(String alias){
        multiCertThresholdCache.put(alias, null);
    }


    /** 
     * This is the method which will get you the last alias.
     */
    public static String getLastestMultiCert(String alias){
        return multiCertThresholdCache.get(alias)==null ?
                null:multiCertThresholdCache.get(alias).getLast();
    }

    public static void atKafkaConsumerEnd(String alias){
            if(alias.endsWith("__forMultiCert"))
                MultiCertCache.updateThresholdCache(alias.substring(0, 
                    alias.indexOf("__forMultiCert")));
            // Normal Cache reload code.
    }
    

    private static byte[] tempGetKeyStore(String alias){

        boolean threshold= false;
        // Check for reverse look up for site id for the given alias
        // Got the site id check for threshold of the siteid.
        // Check against expiry date map Lookup
        // If threshold has reached
        if(threshold){
            String tempAlias = MultiCertCache.getLastestMultiCert(alias);
            // get the cert bytes and return bytes
            // This is the mock code u need to return actual cert bytes.
            return tempAlias.getBytes();
        }else {
            MultiCertCache.clearThreshold(alias);
            // Normal Flow
            // This is the mock code u need to return actual cert bytes.
            return alias.getBytes();
        }
    }
}
