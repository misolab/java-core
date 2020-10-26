package com.misolab.core.crypto;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class DigesterTemplate {

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
        byte[] digest;
        try {
            digest = messageDigest.digest(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 is not supported!");
        }
        return Base64.getEncoder().encodeToString(digest);
    }
}
