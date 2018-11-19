package org.zywx.wbpalmstar.plugin.uexpdf.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;

import org.zywx.wbpalmstar.base.BUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {
    /**
     * 复制文件
     *
     * @param oldPath
     * @param dstPath
     * @return copy是否成功
     */
    public static boolean copyFile(String oldPath, String dstPath) {
        File oldFile = new File(oldPath);
        File dstFile = new File(dstPath);
        try {
            dstFile.getParentFile().mkdirs();
            dstFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileInputStream fis = null;
        FileOutputStream fos = null;
        boolean isSuccess = false;
        try {
            fis = new FileInputStream(oldFile);
            fos = new FileOutputStream(dstFile);
            byte[] buffer = new byte[4096];
            int len = -1;
            while ((len = fis.read(buffer, 0, buffer.length)) != -1) {
                fos.write(buffer, 0, len);
            }
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
        }
        return isSuccess;
    }

    /**
     * 复制文件
     *
     * @param oldFile
     * @param dstFile
     * @return copy是否成功
     */
    public static boolean copyFile(File oldFile, File dstFile) {
        return copyFile(oldFile.getAbsolutePath(), dstFile.getAbsolutePath());
    }

    /**
     * @param file       要删除的文件或文件夹
     * @param path       沙箱根目录
     * @param libPath    库目录
     * @param widgetPath widget目录
     */
    private static void deleteFile(final File file, final String path,
                                   String libPath, String widgetPath) {
        try {
            String widgetPathParent = new File(widgetPath).getParent();
            if (file.exists()) {
                if (file.isFile()) {
                    file.delete();
                } else if (file.isDirectory()) {
                    File files[] = file.listFiles();
                    for (int i = 0; i < files.length; i++) {
                        if (!libPath.equals(files[i].getPath())
                                && !widgetPath.equals(files[i].getPath())) {
                            deleteFile(files[i], path, libPath, widgetPath);
                        }
                    }
                }
                if (!path.equals(file.getPath())
                        && !widgetPathParent.equals(file.getPath())) {
                    file.delete();
                }

            }
        } catch (Exception e) {
            Log.e("deleteFile", e+"");
        }
    }

    /**
     * 删除文件夹
     *
     * @param file
     */
    private static void delDirectory(File file) {
        try {
            if (file.exists()) {
                if (file.isFile()) {
                    file.delete();
                } else if (file.isDirectory())/** file.delete 不能删除非空文件夹 */ {
                    File[] fileList = file.listFiles();
                    for (int i = 0; i < fileList.length; i++) {
                        delDirectory(fileList[i]);
                    }
                    /** 文件夹内容删除完后，删除空文件夹 */
                    file.delete();
                }
            }
        } catch (Exception e) {

            Log.e("deleteFile", e+"");
        }
    }

    /**
     * 擦除应用数据
     *
     * @param path
     * @param delAll 是否删除目录中所有数据
     */
    private static void eraseAppData(String path, boolean delAll) {
        Log.e("eraseData path:" , path);
        File file = new File(path);
        if (delAll) {
            delDirectory(file);
        } else {
            deleteFile(file, path, path + "/lib", path + "/files/widget");
        }
    }

    /**
     * 子应用数据擦除操作(包括widgetone内的widget沙箱擦除)
     *
     * @param context
     * @param appId
     */
    public static void eraseSubAppData(Context context, String appId) {
        String widgetonePath = BUtility.getSdCardRootPath()
                + BUtility.F_APP_PATH + appId;
        /** widgetone/apps/appId 删除整个目录 20160224modify by wanglei */
        eraseAppData(widgetonePath, true);
    }

    /**
     * 主应用数据擦除操作(包括内部存储的沙箱擦除，sd卡Android应用沙箱擦除，以及widgetone内的widget沙箱擦除)
     *
     * @param context
     * @param widgetonePath
     */
    @SuppressLint("NewApi")
    public static void eraseMainAppData(Context context, String widgetonePath) {
        String boxPath = context.getFilesDir().getParent();
        String sdBoxPath = context.getExternalFilesDir(null).getParent();

        /** 内部存储的沙箱擦除 */
        eraseAppData(boxPath, false);

        /** sd卡Android应用沙箱擦除 */
        /** ExternalFilesDir 删除整个目录 20160224modify by wanglei */
        eraseAppData(sdBoxPath, true);

        /** widgetone内的widget沙箱擦除 */
        /** widgetone/apps/appId 删除整个目录 20160224modify by wanglei */
        eraseAppData(widgetonePath, true);
    }

    public static FileInputStream getFileInputStream(String fileName) {
        FileInputStream fis = null;
        if (!TextUtils.isEmpty(fileName)) {
            File file = new File(fileName);
            try {
                fis = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return fis;
    }

    /**
     * 用于保证能够得到一个缓存目录 by yipeng
     *
     * @param context
     * @return
     */
    public static File getExternalCacheDir(Context context) {
        File path = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
            path = context.getExternalCacheDir();
            // In some case, even the sd card is mounted,
            // getExternalCacheDir will return null
            // may be it is nearly full.
        }
        if (null == path) {
            // Before Froyo or the path is null,
            // we need to construct the external cache folder ourselves
            final String cacheDir = "/Android/data/" + context.getPackageName() + "/cache/";
            path = new File(Environment.getExternalStorageDirectory().getPath() + cacheDir);
        }
        return path;
    }

    public static String getFileExtension(String url, String defValue) {
        String suffix = MimeTypeMap.getFileExtensionFromUrl(url);
        if (TextUtils.isEmpty(suffix)) {
            suffix = defValue;
        }
        return suffix;
    }

}
