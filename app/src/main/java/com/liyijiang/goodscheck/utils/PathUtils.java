package com.liyijiang.goodscheck.utils;

import android.os.Environment;

import com.liyijiang.goodscheck.App;

import java.io.File;
import java.io.FilenameFilter;

public class PathUtils {

	public static String getSDcardDir() {
		return Environment.getExternalStorageDirectory().getPath() + "/";
	}

	public static String checkAndMkdirs(String dir) {
		File file = new File(dir);
		if (file.exists() == false) {
			file.mkdirs();
		}
		return dir;
	}

	public static String getAppPath() {
		String dir = getSDcardDir() + "goodscheck/";
		return checkAndMkdirs(dir);
	}

	public static String getPhotoPath() {
		String dir = getAppPath() + "photo/";
		return checkAndMkdirs(dir);
	}

	public static String getDownLoadPath() {
		String dir = getAppPath() + "download/";
		return checkAndMkdirs(dir);
	}

	public static String getDBPath() {
		String dir = App.ctx.getApplicationContext().getFilesDir().getAbsolutePath();
		return dir;
	}

	public static String getDBPathTest() {
		String dir = getAppPath() + "db/";
		return checkAndMkdirs(dir);
	}

	public static String getGameResPath() {
		String dir = getAppPath() + "gameRes/";
		return checkAndMkdirs(dir);
	}

	public static String getUnitResPath() {
		String dir = getAppPath() + "unitRes/";
		return checkAndMkdirs(dir);
	}

	public static String getAudioTestResPath() {
		String dir = getAppPath() + "AudioTest/";
		return checkAndMkdirs(dir);
	}

	public static String getShareTempPath() {
		String dir = getAppPath() + "ShareTemp/";
		return checkAndMkdirs(dir);
	}

	public static String getVideoPath() {
		String dir = getAppPath() + "Video/";
		return checkAndMkdirs(dir);
	}

	public static String getTempPath() {
		String dir = getAppPath() + "Temp/";
		return checkAndMkdirs(dir);
	}

	public static String getRadioPath() {
		String dir = getAppPath() + "Radio/";
		return checkAndMkdirs(dir);
	}

	public static String[] findURIPath(String path,String type) {

		File songFolder = new File(path);
		DirFilter dirFilter = new DirFilter(type);
		
		String[] getNames= songFolder.list(new DirFilter(type));

		
		
		return getNames;
	}

   static class DirFilter implements FilenameFilter{

		private String type;
		
		public DirFilter(String type) {
			this.type = type.toLowerCase();
		}
		
		
		@Override
		public boolean accept(File dir, String path) {
			File file = new File(path);
			String filnames = file.getName();
			return filnames.indexOf(type) != -1;
		}
		
	}


}
