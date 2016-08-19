package ds.dk.yuoto.libutils.Http;

/**
 * Created by deshui.yu on 16-8-19.
 */
public class HttpUtilsStatus {
    /**
     * get or post
     * 0 -- get // 1 -- post
     */
    private static int mType = -1;

    public HttpUtilsStatus(int type) {
        this.mType = type;
    }

    /**
     * 获取目前的请求方式
     */
    protected static int getType() {
        return mType;
    }


    /**
     * 请求的Url
     *
     * @param url 请求的Url
     */
    public HttpUtilsParams url(String url) {
        return new HttpUtilsParams(url);
    }
}
