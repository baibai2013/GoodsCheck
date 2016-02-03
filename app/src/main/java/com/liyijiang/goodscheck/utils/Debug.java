package com.liyijiang.goodscheck.utils;

import android.util.Log;


/**
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 * 
 * @author Nicolas Gramlich
 * @since 13:29:16 - 08.03.2010
 */
public class Debug {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private static boolean showlog = true;
	
	private static String DEBUGTAGLILI = "lili";

	public static void printlili(String pMessage) {
		if(showlog){
			StackTraceElement[] elements = Thread.currentThread().getStackTrace();
			if(elements.length<4){
				Log.i(DEBUGTAGLILI, "Stack to shallow");
			}
			else {
				String fullClassName = elements[3].getClassName();
				String className = fullClassName.substring(fullClassName.lastIndexOf(".")+1);
				String methodName = elements[3].getMethodName();
				int lineNumber = elements[3].getLineNumber();
						
				Log.i(DEBUGTAGLILI,"-->line: "+lineNumber+"  "+className+"."+methodName+"()::"+pMessage, null);
			}
		}
	}

}
