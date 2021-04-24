package com.example.demo.utils;

/**
 * description: MethodFormatUtil
 * date: 4/24/21 5:11 PM
 * author: fourwood
 */
public class MethodFormatUtil {
    private static final char SEPARATOR = '_';

    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        boolean upperCase = true;
        StringBuilder numSb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == SEPARATOR) {
                upperCase = true;
            } else if(Character.isDigit(c)){
                numSb.append(c);
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }
        return sb.append(numSb).toString();
    }

    public static String surfMethod(String s) {
        if (s == null) {
            return null;
        }
        if(s.charAt(1) == '_') return "get" + toCamelCase(s);
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(0) == 'v') {
            sb.setCharAt(0, 'V');
        }
        return "get" + sb;
    }
}
