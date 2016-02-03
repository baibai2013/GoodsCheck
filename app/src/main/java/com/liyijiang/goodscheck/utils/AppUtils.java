package com.liyijiang.goodscheck.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.liyijiang.goodscheck.App;
import com.liyijiang.goodscheck.utils.NetWorkUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author zhou
 */
public class AppUtils {

	/**
	 * 根据包名判断某个程序是否存在
	 * @param context
	 * @param packageName
	 * @return
	 */
	public static boolean checkApkExist(Context context, String packageName) {
		if (TextUtils.isEmpty(packageName) || context == null)
			return false;
		try {
			context.getPackageManager().getApplicationInfo(packageName,
					PackageManager.GET_UNINSTALLED_PACKAGES);
			return true;
		} catch (NameNotFoundException e) {
			return false;
		}
	}
	

	public static boolean isForeground(Context context, String className) {  
	       if (context == null || TextUtils.isEmpty(className)) {  
	           return false;  
	       }  
	  
	       ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);  
	       List<RunningTaskInfo> list = am.getRunningTasks(1);  
	       if (list != null && list.size() > 0) {  
	           ComponentName cpn = list.get(0).topActivity;  
//	           System.out.println("sssss====="+cpn.getClassName());
	           
	           if (className.equals(cpn.getClassName())) {  
	               return true;  
	           }  
	       }  
	  
	       return false;  
	   }  
	
	public static boolean exit(Context context) {  
		if (context == null ) {  
			return false;  
		}  
		
		ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);  
		List<RunningTaskInfo> list = am.getRunningTasks(1);  
		if (list != null && list.size() > 0) {  
			ComponentName cpn = list.get(0).topActivity;  
		}  
		
		return false;  
	}  
	
	public static String gainVersionName(Context context){
		try {
			PackageManager pm = context.getPackageManager();
			PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
			if(pi == null){
				return null;
			}
			return pi.versionName;
		} catch (NameNotFoundException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	public static int gainVersionCode(Context context,String packageName){
		if(packageName == null || "".equals(packageName)){
			return 0;
		}
		try {
			PackageManager pm = context.getPackageManager();
			PackageInfo pi = pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
			if(pi == null){
				return 0;
			}
			return pi.versionCode;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static String inputStream2String(InputStream is) {
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		try {
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}

			return buffer.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	
	public static void showDisPlay(Context context){
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);  
	    Display display = wm.getDefaultDisplay();  
	    // 屏幕宽度  
	    float screenWidth = display.getWidth();  
	    // 屏幕高度  
	    float screenHeight = display.getHeight();  
	    
	    System.out.println("++++++++win widthxheight:[" + screenWidth + "x" + screenHeight + "]+++++++++");
	    
	}
	public static float showDisPlay1(Context context){
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);  
		Display display = wm.getDefaultDisplay();  
		// 屏幕宽度  
		float screenWidth = display.getWidth();  
		// 屏幕高度  
		float screenHeight = display.getHeight();  
		
		return screenHeight;
	}
	
	/** 
	 * 判断是否为平板 
	 *  
	 * @return 
	 */  
	public static  boolean isPad() {  
		
	    WindowManager wm = (WindowManager) App.ctx.getSystemService(Context.WINDOW_SERVICE);
	    Display display = wm.getDefaultDisplay();  
	    // 屏幕宽度  
	    float screenWidth = display.getWidth();  
	    // 屏幕高度  
	    float screenHeight = display.getHeight();  
	    DisplayMetrics dm = new DisplayMetrics();  
	    display.getMetrics(dm);  
	    double x = Math.pow(dm.widthPixels / dm.xdpi, 2);  
	    double y = Math.pow(dm.heightPixels / dm.ydpi, 2);  
	    // 屏幕尺寸  
	    double screenInches = Math.sqrt(x + y);  
	    // 大于7尺寸则为Pad  
	    if (screenInches >= 7.0) {  
	        return true;  
	    }  
	    return false;  
	}  
	
	
	public static boolean checkNetWork(){
		int networktype = NetWorkUtils.getNetWorkType(App.ctx);
		if (networktype == NetWorkUtils.NETWORKTYPE_INVALID) {
			return false;
		}
		return true;
	}
	
	public static String getCurrentTime()
	{
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd"); 
		Date curDate = new Date(System.currentTimeMillis());//获取当前时间
		String time = formatter.format(curDate);
		
		return time;
	}
	
	public static String getUsedMemory(Context mContext){
		long unused = getmem_UNUSED(mContext);
		long total = getmem_TOLAL();
		long avalible = total-unused;
		return Formatter.formatFileSize(mContext, avalible);// Byte转换为KB或者MB，内存大小规格化 
	}
	
	public static String getAvalibleMemory(Context mContext){
		long unused = getmem_UNUSED(mContext);
		return Formatter.formatFileSize(mContext, unused);// Byte转换为KB或者MB，内存大小规格化 
	}
	
	 // 获得可用的内存
    public static long getmem_UNUSED(Context mContext) {
        long MEM_UNUSED;
	// 得到ActivityManager
        ActivityManager am = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
	// 创建ActivityManager.MemoryInfo对象  

        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        am.getMemoryInfo(mi);

	// 取得剩余的内存空间 

        MEM_UNUSED = mi.availMem / 1024;
        return MEM_UNUSED;
    }

    // 获得总内存
    public static long getmem_TOLAL() {
        long mTotal;
        // /proc/meminfo读出的内核信息进行解释
        String path = "/proc/meminfo";
        String content = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path), 8);
            String line;
            if ((line = br.readLine()) != null) {
                content = line;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // beginIndex
        int begin = content.indexOf(':');
        // endIndex
        int end = content.indexOf('k');
        // 截取字符串信息

	content = content.substring(begin + 1, end).trim();
        mTotal = Integer.parseInt(content);
        return mTotal;
    }
    
    
    private static final int ERROR = -1;

    /**
     * SDCARD是否存
     */
    public static boolean externalMemoryAvailable() {
        return android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED);
    }

    /**
     * 获取手机内部剩余存储空间
     * 
     * @return
     */
    public static long getAvailableInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        return availableBlocks * blockSize;
    }

    /**
     * 获取手机内部总的存储空间
     * 
     * @return
     */
    public static long getTotalInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long totalBlocks = stat.getBlockCount();
        return totalBlocks * blockSize;
    }

    /**
     * 获取SDCARD剩余存储空间
     * 
     * @return
     */
    public static long getAvailableExternalMemorySize() {
        if (externalMemoryAvailable()) {
            File path = Environment.getExternalStorageDirectory();
            StatFs stat = new StatFs(path.getPath());
            long blockSize = stat.getBlockSize();
            long availableBlocks = stat.getAvailableBlocks();
            return availableBlocks * blockSize;
        } else {
            return ERROR;
        }
    }

    /**
     * 获取SDCARD总的存储空间
     * 
     * @return
     */
    public static long getTotalExternalMemorySize() {
        if (externalMemoryAvailable()) {
            File path = Environment.getExternalStorageDirectory();
            StatFs stat = new StatFs(path.getPath());
            long blockSize = stat.getBlockSize();
            long totalBlocks = stat.getBlockCount();
            return totalBlocks * blockSize;
        } else {
            return ERROR;
        }
    }
    
    
    private static String sID = null;
    private static final String INSTALLATION = "INSTALLATION";
    
    public static String getUID(Context cext){
    	sID = Secure.getString(cext.getContentResolver(), Secure.ANDROID_ID);
    	if(sID == null)
    	{
    		id(cext);
    	}
    	
    	return sID;
    }
    
    public synchronized static String id(Context context) {
        if (sID == null) {  
            File installation = new File(context.getFilesDir(), INSTALLATION);
            try {
                if (!installation.exists())
                    writeInstallationFile(installation);
                sID = readInstallationFile(installation);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return sID;
    }
    private static String readInstallationFile(File installation) throws IOException {
        RandomAccessFile f = new RandomAccessFile(installation, "r");
        byte[] bytes = new byte[(int) f.length()];
        f.readFully(bytes);
        f.close();
        return new String(bytes);
    }
    private static void writeInstallationFile(File installation) throws IOException {
        FileOutputStream out = new FileOutputStream(installation);
        String id = UUID.randomUUID().toString();
        out.write(id.getBytes());
        out.close();
    }
}
