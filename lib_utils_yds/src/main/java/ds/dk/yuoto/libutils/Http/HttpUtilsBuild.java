package ds.dk.yuoto.libutils.Http;

import android.os.Handler;
import android.os.Message;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by deshui.yu on 16-8-19.
 */
public class HttpUtilsBuild {
    private static final int SUCCESS = 0;
    private static final int ERROR = 1;
    private HttpUtilsCallback mHttpUtilsCallback;
    private Request mRequest;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SUCCESS:
                    String response = (String) msg.obj;
                    mHttpUtilsCallback.success(response);

                    break;
                case ERROR:
                    String e = (String) msg.obj;
                    mHttpUtilsCallback.error(e);

                    break;
            }
        }
    };

    public HttpUtilsBuild(Request request) {
        this.mRequest = request;
    }

    /**
     * 请求开始
     *
     * @param httpUtilsCallback 回调
     */
    public void execute(HttpUtilsCallback httpUtilsCallback) {
        this.mHttpUtilsCallback = httpUtilsCallback;
        if (null == mRequest) {
            httpUtilsCallback.error(null);
            return;
        }

        Call newCall = new OkHttpClient().newCall(mRequest);
        final Message msg = mHandler.obtainMessage();
        if (HttpUtilsStatus.getType() == HttpUtils.GET || HttpUtilsStatus.getType() == HttpUtils.POST) {
            newCall.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    msg.what = ERROR;
                    msg.obj = e.getMessage();
                    mHandler.sendMessage(msg);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String str = response.body().string();
                    msg.what = SUCCESS;
                    msg.obj = str;
                    mHandler.sendMessage(msg);
                }
            });

        } else {
            httpUtilsCallback.error(null);
        }

    }

}
