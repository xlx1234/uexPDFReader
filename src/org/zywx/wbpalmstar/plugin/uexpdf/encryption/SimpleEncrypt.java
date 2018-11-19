package org.zywx.wbpalmstar.plugin.uexpdf.encryption;


import org.zywx.wbpalmstar.plugin.uexpdf.util.EMMConsts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 按字符或字节异或加密
 * 
 * @author yipeng.zhang
 * @modifiedAt 2014年11月5日
 */
public class SimpleEncrypt {
    public final static String KEY = "appcan@3g2win.com";

    /**
     * 加密或解密字节数组(默认KEY)
     * 
     * @param bytes2Encode
     *            要加密的byte数组
     * @return 加密或解密后的字节数组
     */
    public static byte[] encryptBytes(byte[] bytes2Encode) {
        return encryptBytes(bytes2Encode, null);
    }

    /**
     * 用默认KEY加密字符串
     * 
     * @param srcStr
     * @return 加密或解密后的字符串
     */
    public static String encryptStr(String srcStr) {
        return encryptStr(srcStr, null);
    }

    /**
     * 用默认KEY加密文件
     * 
     * @param file
     */
    public static void encryptFile(File file) {
        encryptFile(file, null);
    }

    /**
     * 加密或解密一个文件
     * 
     * @param file
     *            要加密的file
     * @param key
     *            密钥
     */
    public static void encryptFile(File file, String key) {
        if (key == null) {
            key = KEY;
        }
        int keyLength = key.length();
        byte[] temp = new byte[keyLength];
        FileInputStream fis = null;
        RandomAccessFile raf = null;
        try {
            fis = new FileInputStream(file);
            int len = fis.read(temp);
            fis.close();
            SimpleEncrypt.encryptBytes(temp, key);
            raf = new RandomAccessFile(file, "rw");
            raf.write(temp, 0, len);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 加密或解密字节数组
     * 
     * @param bytes2Encode
     *            要加密的byte数组
     * @param key
     *            密钥
     * @return 加密或解密后的字节数组
     */
    public static byte[] encryptBytes(byte[] bytes2Encode, String key) {
        if (key == null) {
            key = KEY;
        }
        byte[] keyChars;
        try {
            keyChars = key.getBytes(EMMConsts.CHARSET_UTF8);
            int j = 0;
            for (int i = 0; i < bytes2Encode.length; i++) {
                bytes2Encode[i] = (byte) (bytes2Encode[i] ^ keyChars[j]);
                j++;
                if (j == keyChars.length) {
                    j = 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytes2Encode;
    }

    /**
     * 加密或解密字符串
     * 
     * @param srcStr
     *            要加密的字符串
     * @param key
     *            密钥
     * @return 加密或解密后的字符串
     */
    public static String encryptStr(String srcStr, String key) {
        String result = null;
        if (key == null) {
            key = KEY;
        }
        char[] srcChars = srcStr.toCharArray();
        char[] keyChars = key.toCharArray();
        int j = 0;
        for (int i = 0; i < srcChars.length; i++) {
            srcChars[i] = (char) (srcChars[i] ^ keyChars[j]);
            j++;
            if (j == keyChars.length) {
                j = 0;
            }
        }
        result = new String(srcChars);
        return result;
    }

}
