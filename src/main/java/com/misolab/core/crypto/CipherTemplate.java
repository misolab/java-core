package com.misolab.core.crypto;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.Base64;

@Slf4j
public abstract class CipherTemplate {
    Cipher cipher;

    public CipherTemplate(String algorithm) {
        try {
            cipher = Cipher.getInstance(algorithm);
        } catch (Exception e) {
            log.error("cipher create fail", e);
        }
    }

    public String encrypt(String source) {
        if (cipher == null) {
            return null;
        }

        byte[] encrypted = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(), getAlgorithmParameterSpec());
            encrypted = cipher.doFinal(source.getBytes());
        } catch (Exception e) {
            log.error("fail ecrypt", e);
        }
        return encode(encrypted);
    }

    public String decrypt(String input) {
        if (cipher == null) {
            return null;
        }

        byte[] encrypted = decode(input);
        byte[] decrypted = null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(), getAlgorithmParameterSpec());
            decrypted = cipher.doFinal(encrypted);
        } catch (Exception e) {
            log.error("fail decrypt", e);
        }
        return new String(decrypted);
    }

    protected abstract AlgorithmParameterSpec getAlgorithmParameterSpec();

    protected abstract Key getSecretKey();

    protected byte[] stringToBytes(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return Arrays.copyOf(bytes, bytes.length);
    }

    protected byte[] decode(String source) {
        return Base64.getDecoder().decode(source);
    }

    protected String encode(byte[] source) {
        return Base64.getEncoder().encodeToString(source);
    }
}
