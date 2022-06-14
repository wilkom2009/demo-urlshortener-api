package com.wilkom.demourlshortenerapi.utils;

import java.nio.charset.Charset;

import com.google.common.hash.Hashing;

public class UtilClass {
    /**
     * Generate a 8 max characters Hash code
     * 
     * @param longUrl
     * @return 8 characters hash String code
     */
    public static String generateHashCode(String longUrl) {
        return Hashing.murmur3_32_fixed().hashString(longUrl, Charset.defaultCharset()).toString();
    }
}