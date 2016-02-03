package com.liyijiang.goodscheck.db;

import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.exception.DbException;
import com.liyijiang.goodscheck.bean.LoginBean;

public class LoginDBModel extends  DBModel{

	private static LoginDBModel loginDBModel = new LoginDBModel();

	public LoginDBModel() {
		super();
	}

	public static LoginDBModel getDefault(){
		return loginDBModel;
	}

	public LoginBean getLoginInfo(){

		LoginBean loginBean = null;
		try {
			 loginBean = dbutils.findFirst((Selector.from(LoginBean.class)));
		} catch (DbException e) {
			e.printStackTrace();
		}
		return loginBean;
	}



}
