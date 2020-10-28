package com.misolab.core.crypto;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

public class CipherTemplate {

    private SecretKeySpec keySpec;
    private AlgorithmParameterSpec ivSpec;
    private Cipher cipher;

    public CipherTemplate(String secretKey, String algorithm) {
        init(secretKey, algorithm, null);
    }

    public CipherTemplate(String secretKey, String algorithm, byte[] iv) {
        init(secretKey, algorithm, iv);
    }

    protected void init(String secretKey, String algorithm, byte[] iv) {
        try {
            byte[] raw = stringToBytes(secretKey);
            if (iv != null) {
                ivSpec = new IvParameterSpec(iv);
                raw = secretKey.getBytes();
            }
            keySpec = new SecretKeySpec(raw, algorithm.contains("AES") ? "AES" : algorithm);
            cipher = Cipher.getInstance(algorithm);
        } catch (Exception e) {
            throw new RuntimeException("CipherTemplate initialization is failed", e);
        }
    }

    public String encrypt(String str) {
        try {
            byte[] encrypted = null;
            synchronized (cipher) {
                cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
                encrypted = cipher.doFinal(str.getBytes());
            }
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            throw new RuntimeException("CipherTemplate encryption is failed", e);
        }
    }

    public String decrypt(String encStr) {
        try {
            byte[] encrypted = null;
            encrypted = Base64.getDecoder().decode(encStr);

            byte[] decrypted = null;
            synchronized (cipher) {
                cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
                decrypted = cipher.doFinal(encrypted);
            }
            return new String(decrypted);
        } catch (Exception e) {
            throw new RuntimeException("CipherTemplate decryption is failed", e);
        }
    }

    private static byte[] stringToBytes(String str) throws Exception {
        final byte[] keyBytes = new byte[16];
        final byte[] b = str.getBytes("UTF-8");
        int len = b.length;
        if (len > keyBytes.length)
            len = keyBytes.length;
        System.arraycopy(b, 0, keyBytes, 0, len);
        return keyBytes;
    }
}
