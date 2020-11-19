package com.misolab.core.crypto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CipherTemplateTest {

    final String SAMPLE = "SAMPLE";
    static byte[] iv = {0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};

    @Test
    void AES_ECB() {
        String SECRET_KEY = "1234567890abcdef";

        AES aes_ecb = new AES("AES", SECRET_KEY, SECRET_KEY.length());
        String encrypted = aes_ecb.encrypt(SAMPLE);
        assertEquals("EvDhzhRj7cqPaJpq5JoJHg==", encrypted);

        String decrypted = aes_ecb.decrypt("EvDhzhRj7cqPaJpq5JoJHg==");
        assertEquals(SAMPLE, decrypted);
    }

    @Test
    void AES() {
        String SECRET_KEY = "1234567890abcdef1234567890abcdef";
        byte[] iv = {0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};

        AES aes = new AES("AES/CBC/PKCS5Padding", SECRET_KEY, SECRET_KEY.length(), iv);
        String encrypted = aes.encrypt(SAMPLE);
        assertEquals("fkP5FfsS4t5bgiatyIpGtw==", encrypted);

        String decrypted = aes.decrypt("fkP5FfsS4t5bgiatyIpGtw==");
        assertEquals(SAMPLE, decrypted);
    }

    @Test
    void MD5() {
        DigesterTemplate digester = new DigesterTemplate("MD5");
        String result = digester.digest(SAMPLE);
        assertEquals(result, "9aJJbPZsuM/+ZssbJ9fe3g==");
    }

}
