package ds.dk.yuoto.libutils.Http;

import okhttp3.Request;

/**
 * Created by deshui.yu on 16-8-19.
 */
public interface HttpUtilsCallback {

    /**
     * 请求成功后的回调
     * UI线程
     *
     * @param response 返回的结果
     */
    public void success(String response);

    /**
     * 请求失败后的回调
     * UI线程
     *
     * @param e 可能为null，错误信息
     */
    public void error(String e);
}
