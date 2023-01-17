package com.keystore;

/**
 * This is the class which needs to be modified per release or patch release.
 * Fields are not transitent for heap dump to capture the same info.
 */
public class Version {

    // Increment the version per release.
    public static final int majorVersion =1;
    // Increment the version per production release/patch
    public static final int minorVersion = 0;
    //Release Info
    public static final String release="NovGA2022";   

    // Not allowed to create object
    public Version() throws Exception{
        throw new Exception("Version Class Object creation not allowed");
    }
}
