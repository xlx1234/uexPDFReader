package org.zywx.wbpalmstar.plugin.uexpdf.encryption;

import android.util.Base64;

import org.zywx.wbpalmstar.plugin.uexpdf.util.FileUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 先将文件头部的与KEY相同长度的部分进行与KEY进行异或处理，然后Base64加密
 * 
 * @author yipeng.zhang
 * @createdAt 2014年11月5日
 */
public class FileEncryption {
    public final static String KEY = "appcan@3g2win.com";

    /**
     * 用默认KEY加密文件（覆盖）
     * 
     * @param file
     * @return 加密是否成功
     */
    public static boolean encryptFile(File file) {
        return encryptFile(file, null);
    }

    /**
     * 用默认KEY解密文件
     * 
     * @param file
     * @return 解密是否成功
     */
    public static boolean decryptFile(File file) {
        return decryptFile(file, null);
    }

    /**
     * 用默认KEY解密文件,不覆盖源文件
     * 
     * @param srcFile
     *            源文件
     * @param dstFile
     *            解密文件的保存位置
     */
    public static boolean decryptFileInCoverly(File srcFile, File dstFile) {
        boolean isSuccess1 = false;
        boolean isSuccess2 = false;
        isSuccess1 = FileUtils.copyFile(srcFile, dstFile);
        isSuccess2 = decryptFile(dstFile, null);
        return isSuccess1 && isSuccess2;
    }

    /**
     * 加密或解密一个文件的头
     * 
     * @param file
     *            要加密的file
     * @param key
     *            密钥
     * @return 加密或解密是否成功
     */
    private static boolean encryptFileHeader(File file, String key) {
        boolean isSuccess = false;
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
            isSuccess = true;
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
        return isSuccess;
    }

    /**
     * 加密一个文件
     * 
     * @param file
     *            要加密的file
     * @param key
     *            密钥
     * @return 加密是否成功
     */
    private static boolean encryptFile(File file, String key) {
        boolean isSuccess1 = false;
        boolean isSuccess2 = false;
        if (key == null) {
            key = KEY;
        }
        isSuccess1 = encryptFileHeader(file, key);
        isSuccess2 = Base64EncryptFile(file);
        return isSuccess1 && isSuccess2;
    }

    /**
     * 解密一个文件
     * 
     * @param file
     *            要加密的file
     * @param key
     *            密钥
     * @return 解密是否成功
     */
    private static boolean decryptFile(File file, String key) {
        boolean isSuccess1 = false;
        boolean isSuccess2 = false;
        if (key == null) {
            key = KEY;
        }
        isSuccess1 = Base64DecryptFile(file);
        isSuccess2 = encryptFileHeader(file, key);
        return isSuccess1 && isSuccess2;
    }

    /**
     * Base64加密文件
     * 
     * @param file
     */
    private static boolean Base64EncryptFile(File file) {
        boolean isSuccess = false;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        ByteArrayOutputStream baos = null;
        try {
            fis = new FileInputStream(file);
            baos = new ByteArrayOutputStream();
            int len = -1;
            byte[] buffer = new byte[1024];
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
                baos.flush();
            }
            fis.close();
            fos = new FileOutputStream(file);
            byte[] fileBytes = baos.toByteArray();
            byte[] encodedBytes = Base64.encode(fileBytes, Base64.DEFAULT);
            fos.write(encodedBytes, 0, encodedBytes.length);
            fos.flush();
            isSuccess = true;
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
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return isSuccess;
    }

    /**
     * Base64解密文件
     * 
     * @param file
     */
    private static boolean Base64DecryptFile(File file) {
        boolean isSuccess = false;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        ByteArrayOutputStream baos = null;
        try {
            fis = new FileInputStream(file);
            baos = new ByteArrayOutputStream();
            int len = -1;
            byte[] buffer = new byte[1024];
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
                baos.flush();
            }
            fis.close();
            // 读取文件结束，开始写文件
            fos = new FileOutputStream(file);
            byte[] fileBytes = baos.toByteArray();
            byte[] decodedBytes = Base64.decode(fileBytes, Base64.DEFAULT);
            fos.write(decodedBytes, 0, decodedBytes.length);
            fos.flush();
            isSuccess = true;
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
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return isSuccess;
    }
}
