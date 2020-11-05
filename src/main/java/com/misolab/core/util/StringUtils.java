package com.misolab.core.util;

import com.misolab.core.code.Constant;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public interface StringUtils extends Constant {

    default byte[] base64Decode(String source) {
        return Base64.getDecoder().decode(source);
    }

    default String base64Encode(byte[] source) {
        return Base64.getEncoder().encodeToString(source);
    }

    default byte[] stringToBytes(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return Arrays.copyOf(bytes, bytes.length);
    }

    default String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, CHARSET_UTF_8);
        } catch (UnsupportedEncodingException e) {
        }
        return null;
    }

}
