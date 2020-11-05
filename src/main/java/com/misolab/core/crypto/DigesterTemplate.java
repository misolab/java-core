package com.misolab.core.crypto;

import com.misolab.core.util.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigesterTemplate implements StringUtils {

    private MessageDigest messageDigest;

    public DigesterTemplate(String algorithm) {
        try {
            messageDigest = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("DigesterTemplate initialization is failed", e);
        }
    }

    public String digest(String str) {
        byte[] digest = messageDigest.digest(stringToBytes(str));
        return base64Encode(digest);
    }
}
