package com.liyijiang.goodscheck.service;


import com.alibaba.fastjson.JSON;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.liyijiang.goodscheck.bean.LoginBean;
import com.liyijiang.goodscheck.bean.RequestBean;
import com.liyijiang.goodscheck.utils.Debug;

/**
 * Created by lili on 16/2/3.
 */
public class BackofficeService {

    private static String SERVICE_URL = "http://182.50.112.20:8101/backoffice/pandian/checkInterface.php";

    //下载登录信息
    public static String ACTION_DOWNLOADSTAFF = "downloadStaff";

    //下载最大盘点数量
    public static String ACTION_DOWNLOADMAXNUMBER = "downloadMaxNumber";

    //下载盘点枪编号
    public static String ACTION_DOWNLOADCODE = "downloadCode";

    //下载商品信息
    public static String ACTION_DOWNLOADCHECKDATA = "downloadCheckData";

    //下载库房信息
    public static String ACTION_DOWNLOADSTORE = "downloadStore";

    //上传盘点结果
    public static String ACTION_UPLOADCHECKDATA = "uploadCheckData";




    public void init() {

    }


    private String getRequestBeanJsonString(String action, Object data) {
        RequestBean requestBean = new RequestBean();
        LoginBean loginBean = new LoginBean("leyoucheck","leyou1234");
        if (loginBean != null) {
            requestBean.setLogin(loginBean);
        }
        requestBean.setAction(action);
        requestBean.setData(data);

        String jsonString = (String) JSON.toJSONString(requestBean);
        Debug.printlili(jsonString);
        return jsonString;
    }


    public void downloadData(String action,Object data,RequestCallBack<String> callBack) {

        String requestBeanjsonString = getRequestBeanJsonString(action, data);

        RequestParams params = new RequestParams();
        params.addBodyParameter("data", requestBeanjsonString);

        HttpUtils http = new HttpUtils();
        http.send(HttpRequest.HttpMethod.POST, SERVICE_URL, params, callBack);



    }






}
