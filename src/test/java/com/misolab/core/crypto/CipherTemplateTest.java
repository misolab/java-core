package com.misolab.core.crypto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CipherTemplateTest {

    final String SAMPLE = "SAMPLE";
    static byte[] iv = {0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};

    @Test
    void AES() {
        String gwSeed = "1234567890abcdef";
        CipherTemplate cipher = new CipherTemplate(gwSeed, "AES");

        String encrypted = cipher.encrypt(SAMPLE);
        assertEquals(encrypted, "EvDhzhRj7cqPaJpq5JoJHg==");

        String decrypted = cipher.decrypt("EvDhzhRj7cqPaJpq5JoJHg==");
        assertEquals(decrypted, SAMPLE);
    }


    @Test
    void AES_ECB() {
        String gwSeed = "1234567890abcdef1234567890abcdef";
        CipherTemplate cipher = new CipherTemplate(gwSeed, "AES/CBC/PKCS5Padding", iv);

        String encrypted = cipher.encrypt(SAMPLE);
        assertEquals(encrypted, "fkP5FfsS4t5bgiatyIpGtw==");

        String decrypted = cipher.decrypt("fkP5FfsS4t5bgiatyIpGtw==");
        assertEquals(decrypted, SAMPLE);
    }

    @Test
    void MD5() {
        DigesterTemplate digester = new DigesterTemplate("MD5");
        String result = digester.digest(SAMPLE);
        assertEquals(result, "9aJJbPZsuM/+ZssbJ9fe3g==");
    }

}
