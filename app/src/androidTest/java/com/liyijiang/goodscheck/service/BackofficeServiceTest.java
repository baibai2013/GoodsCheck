package com.liyijiang.goodscheck.service;

import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.liyijiang.goodscheck.utils.Debug;

import junit.framework.TestCase;

/**
 * Created by lili on 16/2/3.
 */
public class BackofficeServiceTest extends TestCase {

    BackofficeService backofficeService;

    @Override
    protected void setUp() throws Exception {
        backofficeService = new BackofficeService();
    }

    public void testDownloadData() throws Exception {
    backofficeService.downloadData(BackofficeService.ACTION_DOWNLOADSTAFF, true, new RequestCallBack<String>() {
        @Override
        public void onSuccess(ResponseInfo<String> responseInfo) {




            Debug.printlili(responseInfo.result);

        }

        @Override
        public void onFailure(HttpException error, String msg) {

            error.printStackTrace();
            Debug.printlili(msg);

        }
    });
    }
}