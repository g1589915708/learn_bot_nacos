package com.learn.tools;

import java.security.MessageDigest;

public class MD5Util {
    //盐，用于混交md5
//    private static final String slat = "&%5123***&&%%$$#@";
    private static final String slat = "&%8192#*#*&%%$$";
    public static String encrypt(String dataStr) {
        try {
            dataStr = dataStr + slat;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes("UTF8"));
            byte s[] = m.digest();
            String result = "";
            for (int i = 0; i < s.length; i++) {
                result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     *

     /**
     * 生成md5
     * @param seckillId
     * @return
     *
    public static String getMD5(String str) {
        String base = str +"/"+slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
     * */
}
