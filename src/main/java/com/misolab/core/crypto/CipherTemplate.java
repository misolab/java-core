package com.misolab.core.crypto;

import com.misolab.core.util.StringHelper;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

@Slf4j
public abstract class CipherTemplate implements StringHelper {

    Cipher cipher;

    protected abstract AlgorithmParameterSpec getAlgorithmParameterSpec();

    protected abstract Key getSecretKey();

    public CipherTemplate(String algorithm) {
        try {
            cipher = Cipher.getInstance(algorithm);
        } catch (Exception e) {
            throw new RuntimeException("CipherTemplate initialization is failed", e);
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
}
