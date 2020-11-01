package com.misolab.core.util;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public interface StringHelper {

    default byte[] decode(String source) {
        return Base64.getDecoder().decode(source);
    }

    default String encode(byte[] source) {
        return Base64.getEncoder().encodeToString(source);
    }

    default byte[] stringToBytes(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return Arrays.copyOf(bytes, bytes.length);
    }
}
