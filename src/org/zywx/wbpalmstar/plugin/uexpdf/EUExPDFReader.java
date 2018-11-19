package org.zywx.wbpalmstar.plugin.uexpdf;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RelativeLayout;

import com.artifex.mupdfdemo.MuPDFActivity;

import org.zywx.wbpalmstar.base.BUtility;
import org.zywx.wbpalmstar.engine.DataHelper;
import org.zywx.wbpalmstar.engine.EBrowserView;
import org.zywx.wbpalmstar.engine.universalex.EUExBase;
import org.zywx.wbpalmstar.plugin.uexpdf.encryption.FileEncryption;
import org.zywx.wbpalmstar.plugin.uexpdf.util.FileUtil;
import org.zywx.wbpalmstar.plugin.uexpdf.util.MyLog;
import org.zywx.wbpalmstar.plugin.uexpdf.vo.OpenVO;

import java.io.File;
import java.util.UUID;

/**
 * uexPDFReader
 * 
 * 基于MuPDF的PDF阅读器插件
 * 
 * @author waka
 * @version createTime:2016年4月20日 上午11:11:16
 */
public class EUExPDFReader extends EUExBase {

    private PDFView mPDFView;
//	private String srcPath;


	public EUExPDFReader(Context arg0, EBrowserView arg1) {
		super(arg0, arg1);

	}

//	public void ncryptPDFReader(String[] params) {
//
//		String path = params[0];
//		String absPath = FileUtil.getAbsPath(path, mBrwView);
//        final String fileName = FileUtil.makeFile(mContext, absPath);
//		if (fileName == null) {
//			MyLog.getLog().i("fileName == null");
//			return;
//		}
//		new AsyncTask<Void, Void, String>() {
//			@Override
//			protected String doInBackground(Void... parm) {
//				String newPath = parsePath(mContext,fileName);
//				if (TextUtils.isEmpty(newPath)) {
//					Log.e("fileEncrypt: path-->"+newPath,"<--format error");
//					return null;
//				}
//				File file = new File(newPath);
//				Log.e("isSuccess",newPath);
//				boolean isSuccess = FileEncryption.encryptFile(file);
//				if (isSuccess){
//					Log.e("true","加密成功");
//				}else {
//					Log.e("flase","加密失败");
//				}
//
//				return newPath;
//			}
//
//			@Override
//			protected void onPostExecute(String result) {
//			  Log.e("result",result);
////				String uuid = UUID.randomUUID().toString();
////				String  sand = mContext.getFilesDir().getAbsolutePath();
////				String  dst = sand  + "/Cache/";
////				srcPath = result;
////				dstPath = dst + uuid;
//			}
//
//	}.execute();
//
//	}


	/**
	 * 打开PDFReader
	 * 
	 * @param params
	 */
	public void openPDFReader(String[] params) {

		MyLog.getLog().i("start");

		if (params.length < 1) {
			MyLog.getLog().i("params.length < 1");
			return;
		}

		if (params[0].isEmpty()) {
			MyLog.getLog().i("params[0].isEmpty()");
			return;
		}

			String path = params[0];
			String isDecode = params[1];
		    String absPath = FileUtil.getAbsPath(path, mBrwView);
		   final String fileName = FileUtil.makeFile(mContext, absPath);
		   if (fileName == null) {
			     MyLog.getLog().i("fileName == null");
		      	return;
		   }
		if (isDecode.equals("1")) {
			String uuid = UUID.randomUUID().toString();
			String sand = mContext.getFilesDir().getAbsolutePath();
			String dst = sand + "/Cache/";
			final String srcPath = fileName;
			final String dstPath = dst + uuid;
			new AsyncTask<Void, Void, String>() {
				@Override
				protected String doInBackground(Void... parm) {
					if (TextUtils.isEmpty(srcPath) || TextUtils.isEmpty(dstPath)) {
						Log.e("fileDecrypt: srcPath-->", srcPath);
						Log.e(" <--  dstPath--> ", dstPath);
						Log.e("<--path params error", "");
						return null;
					}
					String srcPathParse = parsePath(mContext, srcPath);
					String dstPathParse = parsePath(mContext, dstPath);
					if (TextUtils.isEmpty(srcPathParse) || TextUtils.isEmpty(dstPath)) {
						Log.e("fileDecrypt: srcPath-->", srcPathParse);
						Log.e(" <--  dstPath--> ", dstPathParse);
						Log.e("<--path params error", "");
						return null;
					}
					 File srcFile = new File(srcPathParse);
					 File dstFile = new File(dstPathParse);
					boolean isSuccess = false;
					if (srcPathParse.equals(dstPathParse)) {
						// 如果路径相同，则表示需要覆盖解密文件
						isSuccess = FileEncryption.decryptFile(srcFile);
						if (isSuccess) {
							Log.e("isSuccess", "覆盖解密文件成功");
						}
					} else {
						// 如果路径不同，则表示两个文件路径不同，采用不覆盖模式的解密
						isSuccess = FileEncryption.decryptFileInCoverly(srcFile,
								dstFile);
						if (isSuccess){
							Log.e("isSuccess", "两个文件路径不同覆盖解密文件成功");
						}else {
							Log.e("isSuccess", "两个文件路径不同覆盖解密文件失败");
						}
					}
					//dstPathParse
					return dstPathParse;
				}

				@Override
				protected void onPostExecute(String result) {
					Log.e("result",result);
					Uri uri = Uri.fromFile(new File(result));
					MyLog.getLog().i("uri = " + uri.toString());
					Intent intent = new Intent(mContext, MuPDFActivity.class);
					intent.setAction(Intent.ACTION_VIEW);
					intent.setData(uri);
					startActivityForResult(intent, Constant.REQUEST_CODE_PDF_PREVIEW_ACTIVITY);
				}

			}.execute();

		} else {
			Uri uri = Uri.fromFile(new File(path));
			MyLog.getLog().i("uri = " + uri.toString());
			Intent intent = new Intent(mContext, MuPDFActivity.class);
			intent.setAction(Intent.ACTION_VIEW);
			intent.setData(uri);
			startActivityForResult(intent, Constant.REQUEST_CODE_PDF_PREVIEW_ACTIVITY);
		}
	}


	public  String parsePath(Context mContext,
							 String srcPath) {
		String path = null;
		if (srcPath.startsWith("wgt://")) {
			path = BUtility.makeRealPath(srcPath, mBrwView.getCurrentWidget().m_widgetPath,
					mBrwView.getCurrentWidget().m_wgtType);
		} else if (srcPath.startsWith("/")) {
			path = srcPath;
		}
		return path;
	}

	@Override
	public void onActivityResult(int i, int i1, Intent intent) {
		super.onActivityResult(i, i1, intent);
		File file = new File(intent.getAction());
		if(file.isFile()){
			file.delete();
		}
		file.exists();

	}

	public void openView(String[] params){
        OpenVO openVO= DataHelper.gson.fromJson(params[0],OpenVO.class);
        openVO.path= BUtility.getRealPathWithCopyRes(mBrwView,openVO.path);
        if (mPDFView==null){
            mPDFView=new PDFView(mContext,openVO.path);
        }

        RelativeLayout.LayoutParams lp=new RelativeLayout.LayoutParams(openVO.width,openVO.height);
        lp.topMargin=openVO.y;
        lp.leftMargin=openVO.x;
        addViewToCurrentWindow(mPDFView,lp);

    }

    public void closeView(String[] params){
        if (mPDFView!=null){
            mPDFView.close();
            removeViewFromCurrentWindow(mPDFView);
            mPDFView=null;
        }
    }


	/**
	 * 关闭
	 * 
	 * @param params
	 */
	public void close(String[] params) {

		MyLog.getLog().i("start");

		// 发送关闭Activity本地广播
		LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(mContext);
		Intent intent = new Intent(Constant.ACTION_LOCAL_BROADCAST_CLOSE_ACTIVITY);
		localBroadcastManager.sendBroadcast(intent);

		MyLog.getLog().i("end");
	}

	@Override
	protected boolean clean() {
		return false;
	}

}
