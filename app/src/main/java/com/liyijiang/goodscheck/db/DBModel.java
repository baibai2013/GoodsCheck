package com.liyijiang.goodscheck.db;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.DbUtils.DbUpgradeListener;
import com.liyijiang.goodscheck.App;
import com.liyijiang.goodscheck.utils.PathUtils;


public class DBModel {

	private static final String DB = "goodscheck.db";
	private static final int DBVERSION = 1;

	protected DbUtils dbutils = null;

	protected DBModel() {

		String dbpath = null;

		if (App.debug) {
			dbpath = PathUtils.getDBPathTest();
		} else {
			dbpath = PathUtils.getDBPath();
		}
		dbutils = DbUtils.create(App.ctx, dbpath, DB, DBVERSION, new DbUpgradeListener() {

			@Override
			public void onUpgrade(DbUtils db, int oldVersion, int newVersion) {

				dropTable(db);
				createTable(db);
			}
		});
		dbutils.configAllowTransaction(true);//标示开启事务，这样多个线程操作数据库时就不会出现问题了
		
		createTable(dbutils);

	}

	/**
	 * 创建表
	 */
	public void createTable() {
		createTable(dbutils);
	}

	private void createTable(DbUtils dbutils) {
//		try {
//			dbutils.createTableIfNotExist(SDCardDBModel.class);
//		} catch (DbException e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * 删除表
	 */
	public void dropTable() {
		dropTable(dbutils);
	}

	private void dropTable(DbUtils dbutils) {
//		try {
//			dbutils.dropTable(SDCardDBModel.class);
//		} catch (DbException e) {
//			e.printStackTrace();
//		}

	}

}
