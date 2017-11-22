package edu.bistu.cs.se.wordapp;

import java.util.UUID;

/**
 * Created by wym on 2017/11/10.
 */

public class GUID {
    public static String getGUID() {
        UUID uuid = UUID.randomUUID();
        String a = uuid.toString();
        a = a.toUpperCase();
        a = a.replaceAll("-", "");
        return a;
    }
}
