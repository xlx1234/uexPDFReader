package org.zywx.wbpalmstar.plugin.uexpdf.util;

import android.content.Context;
import android.os.Environment;

import org.zywx.wbpalmstar.base.BUtility;
import org.zywx.wbpalmstar.engine.EBrowserView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author waka
 * @version createTime:2016年4月20日 上午11:34:49
 */
public class FileUtil {

	/**
	 * 得到绝对路径
	 * 
	 * @param path
	 * @param mBrwView
	 * @return
	 */
	public static String getAbsPath(String path, EBrowserView mBrwView) {
		return BUtility.makeRealPath(path, mBrwView.getCurrentWidget().m_widgetPath,
				mBrwView.getCurrentWidget().m_wgtType);
	}

	public static String makeFile(Context context, String filePath) {
		if (filePath == null || filePath.length() == 0) {
			return null;
		}
		String fileName;
		if (!filePath.startsWith("/")) {
			if (filePath.contains("/")) {
				fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
			} else {
				fileName = filePath;
			}
			return sandbox(context, filePath, fileName);
		} else {
			return filePath;
		}
	}

	public static String sandbox(Context ctx, String inFileName, String outFileName) {
		@SuppressWarnings("unused")
		int total = 0;
		try {
			InputStream is = ctx.getAssets().open(inFileName);
			if (is == null) {
				return null;
			}

			if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
				String  sand = ctx.getFilesDir().getAbsolutePath();
				String path = sand  + "/Cache/";
				File filePath = new File(path);
				if (!filePath.exists()) {
					filePath.mkdirs();
				}
				String fileName = path + outFileName;
				FileOutputStream fos = new FileOutputStream(fileName);

				byte[] buf = new byte[1024];
				int len = 0;
				while ((len = is.read(buf)) != -1) {
					fos.write(buf, 0, len);
					total += len;
				}
				is.close();
				fos.close();
				return fileName;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
}
