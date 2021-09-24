package com.learn.tools;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;

public class StringUtils {
    public static String encodeBase64(byte[] binaryData) {
        return Base64.encode(binaryData);
    }

    public static byte[] decodeBase64(String encoded) throws Base64DecodingException {
        return Base64.decode(encoded);
    }
}
