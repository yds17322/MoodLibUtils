package ds.dk.yuoto.libutils.Http;

import java.util.LinkedHashMap;

import okhttp3.FormBody;
import okhttp3.Request;

/**
 * Created by deshui.yu on 16-8-19.
 */
public class HttpUtilsParams {
    private String mUrl = null;
    private LinkedHashMap<String, String> mParams = null;

    public HttpUtilsParams(String url) {
        this.mUrl = url;
        this.mParams = new LinkedHashMap<>();
    }

    /**
     * post 请求的参数，get请求无需实现，get/post未分开写
     * 注：get实现了也不会去执行
     */
    public HttpUtilsParams addParams(String key, String value) {
        mParams.put(key, value);
        return this;
    }

    /**
     * 构建请求体
     */
    public HttpUtilsBuild build() {
        Request.Builder requestBuilder = new Request.Builder().url(mUrl);
        Request request = null;

        if (HttpUtilsStatus.getType() == HttpUtils.GET) {
            requestBuilder.method("GET", null);
            request = requestBuilder.build();

        } else if (HttpUtilsStatus.getType() == HttpUtils.POST) {
            FormBody build = null;
            if (null != mParams && mParams.size() > 0) {
                FormBody.Builder builder = new FormBody.Builder();
                for (LinkedHashMap.Entry<String, String> entry : mParams.entrySet()) {
                    builder.add(entry.getKey(), entry.getValue());
                }
                build = builder.build();
            }
            request = requestBuilder.post(build).build();

        }

        return new HttpUtilsBuild(request);
    }

}
