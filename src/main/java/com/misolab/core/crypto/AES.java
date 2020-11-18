package com.misolab.core.crypto;

import com.misolab.core.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

@Slf4j
public class AES extends CipherTemplate {

    SecretKeySpec keySpec;
    AlgorithmParameterSpec ivSpec;

    public AES(String algorithm, String secretKey) {
        super(algorithm);
        init(secretKey, null);
    }

    public AES(String algorithm, String secretKey, byte[] iv) {
        super(algorithm);
        init(secretKey, iv);
    }

    void init(String secretKey, byte[] iv) {
        byte[] key = StringUtils.stringToBytes(secretKey);
        if (iv != null) {
            ivSpec = new IvParameterSpec(iv);
        }
        keySpec = new SecretKeySpec(key, "AES");
    }

    @Override
    protected AlgorithmParameterSpec getAlgorithmParameterSpec() {
        return ivSpec;
    }

    @Override
    protected Key getSecretKey() {
        return keySpec;
    }

//    @Override
//    protected byte[] decode(String source) {
//        return Hex.decodeHex(source.toCharArray());
//    }

//    @Override
//    protected String encode(byte[] source) {
//        return Hex.encodeHex(source);
//    }
}
