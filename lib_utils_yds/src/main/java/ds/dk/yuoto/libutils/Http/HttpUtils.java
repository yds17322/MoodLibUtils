package ds.dk.yuoto.libutils.Http;


/**
 * Created by deshui.yu on 16-8-19.
 */
public class HttpUtils {
    protected static final int GET = 0;
    protected static final int POST = 1;
    private static HttpUtils mHttpUtils = null;

    private HttpUtils() {
    }

    /**
     * 获得HttpUtils对象
     */
    public static HttpUtils getInstance() {
        if (mHttpUtils == null) {
            synchronized (HttpUtils.class) {
                if (mHttpUtils == null) {
                    mHttpUtils = new HttpUtils();
                }
            }
        }
        return mHttpUtils;
    }

    /**
     * http get请求
     */
    public static HttpUtilsStatus get() {
        return new HttpUtilsStatus(GET);
    }

    /**
     * http post请求
     */
    public static HttpUtilsStatus post() {
        return new HttpUtilsStatus(POST);
    }
}
