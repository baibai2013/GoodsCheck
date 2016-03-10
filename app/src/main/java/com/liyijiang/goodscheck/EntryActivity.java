package com.liyijiang.goodscheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.liyijiang.goodscheck.service.BackofficeService;
import com.liyijiang.goodscheck.utils.Debug;

import java.io.UnsupportedEncodingException;

public class EntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        getDate();
    }

    private void getDate() {
        BackofficeService backofficeService = new BackofficeService();
        backofficeService.downloadData(BackofficeService.ACTION_DOWNLOADSTAFF, true, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {



                try {
                    String uft8Str = new String(responseInfo.result.getBytes("ISO8859-1"), "GBK");
                    Debug.printlili(uft8Str);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(HttpException error, String msg) {

                error.printStackTrace();
                Debug.printlili(msg);

            }
        });

    }


}
