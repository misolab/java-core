package com.misolab.core.crypto;

import com.misolab.core.util.StringHelper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigesterTemplate implements StringHelper {

    private MessageDigest messageDigest;

    public DigesterTemplate(String algorithm) {
        init(algorithm);
    }

    protected void init(String algorithm) {
        try {
            messageDigest = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("DigesterTemplate initialization is failed", e);
        }
    }

    public String digest(String str) {
        byte[] digest = messageDigest.digest(stringToBytes(str));
        return encode(digest);
    }
}
