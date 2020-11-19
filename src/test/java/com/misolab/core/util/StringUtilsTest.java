package com.misolab.core.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilsTest {

    private String SAMPLE = "S A_M&P=L플";
    private String URL_SAMPLE = "S%20A_M%26P%3DL%ED%94%8C";
    private String BASE64_SAMPLE = "UyBBX00mUD1M7ZSM";


    @Test
    void base64Decode() {
        byte[] decoded = StringUtils.base64Decode(BASE64_SAMPLE);
        assertArrayEquals(SAMPLE.getBytes(), decoded);
    }

    @Test
    void base64Encode() {
        String encoded = StringUtils.base64Encode(SAMPLE.getBytes());
        assertEquals(BASE64_SAMPLE, encoded);
    }

    @Test
    void stringToBytes() {
    }

    @Test
    void urlEncode() {
        String encoded = StringUtils.urlEncode(SAMPLE);
        assertEquals(URL_SAMPLE, encoded);
    }

    @Test
    void urlDecode() {
        String decoded = StringUtils.urlDecode(URL_SAMPLE);
        assertEquals(SAMPLE, decoded);

    }
}
