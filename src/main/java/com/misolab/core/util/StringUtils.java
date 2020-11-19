package com.misolab.core.util;

import com.misolab.core.code.Constant;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class StringUtils {

    public static byte[] base64Decode(String source) {
        return Base64.getDecoder().decode(source);
    }

    public static String base64Encode(byte[] source) {
        return Base64.getEncoder().encodeToString(source);
    }

    public static byte[] stringToBytes(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return Arrays.copyOf(bytes, bytes.length);
    }

    public static byte[] stringToBytes(String str, int length) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return Arrays.copyOf(bytes, length);
    }

    public static String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, Constant.CHARSET_UTF_8).replace(Constant.PLUS, Constant.ESCAPE_SPACE);
        } catch (UnsupportedEncodingException e) {
        }
        return null;
    }

    public static String urlDecode(String s) {
        try {
            return URLDecoder.decode(s, Constant.CHARSET_UTF_8);
        } catch (UnsupportedEncodingException e) {
        }
        return null;
    }

}
