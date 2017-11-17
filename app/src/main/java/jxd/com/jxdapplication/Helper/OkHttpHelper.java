package jxd.com.jxdapplication.Helper;

import android.os.Build;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2017/6/1 0001.
 * OKHttp帮助类
 */

class OkHttpHelper {

    /**
     * 单例
     */
    private static final OkHttpHelper ourInstance = new OkHttpHelper();

    public static OkHttpHelper getInstance() {
        return ourInstance;
    }

    /**
     * 配置 OkHttpClient
     */
    private OkHttpHelper() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                //.addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }

    /**
     * JSON头
     */
    private MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * 请求头
     *
     * @return 返回值
     */
    private Map<String, String> getHeader(boolean gzip) {
        HashMap<String, String> header = new HashMap<>();
        header.put("client", Build.MODEL);
        if (gzip) {
            header.put("Content-Encoding", "gzip");
        }
        return header;
    }

    /**
     * 异步获取
     *
     * @param url      url地址
     * @param gzip     GZIP
     * @param callback 回调
     */
    public void asynGet(String url, final boolean gzip, final StringCallback callback) {
        OkHttpUtils
                .get()
                .url(url)
                .headers(getHeader(gzip))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onError(call, e, id);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        callback.onResponse(response, id);
                    }
                });
    }

    /**
     * 同步获取
     *
     * @param url  url地址
     * @param gzip GZIP
     * @return 返回值
     * @throws IOException 异常
     */
    public String synGet(String url, boolean gzip) throws IOException {
        return OkHttpUtils
                .get()
                .url(url)
                .headers(getHeader(gzip))
                .build()
                .execute().body().string();
    }

    /**
     * 异步提交
     *
     * @param url      url地址
     * @param json     表单
     * @param gzip     GZIP
     * @param callback 回调
     */
    public void asynPost(String url, String json, final boolean gzip, final StringCallback callback) {
        OkHttpUtils
                .postString()
                .url(url)
                .content(json)
                .mediaType(JSON)
                .headers(getHeader(gzip))
                .build()
                .execute(callback);
    }

    /**
     * 异步提交 (没有form表单的情况)
     *
     * @param url      url地址
     * @param gzip     GZIP
     * @param callback 回调
     */
    public void asynPost(String url, final boolean gzip, final StringCallback callback) {
        OkHttpUtils
                .post()
                .url(url)
                .headers(getHeader(gzip))
                .build()
                .execute(callback);
    }


    /**
     * 同步提交
     *
     * @param url  url地址
     * @param json 表单
     * @param gzip GZIP
     * @return 返回值
     * @throws IOException 异常
     */
    public String synPost(String url, String json, boolean gzip) throws IOException {
        return OkHttpUtils
                .postString()
                .url(url)
                .content(json)
                .mediaType(JSON)
                .headers(getHeader(gzip))
                .build()
                .execute().body().string();
    }

    /**
     * 异步上传文件
     *
     * @param url      url地址
     * @param file     文件
     * @param callback 回调
     */
    public void asynPostFile(String url, File file, final StringCallback callback) {
        OkHttpUtils
                .postFile()
                .url(url)
                .file(file)
                .headers(getHeader(false))
                .build()
                .execute(callback);
    }

    /**
     * 异步上传文件，表单方式上传
     *
     * @param url      url地址
     * @param file     文件
     * @param callback 回调
     */
    public void asynPostFormFile(String url, File file, final StringCallback callback) {
        OkHttpUtils.post()//
                .addFile("mFile", file.getName(), file)
                .url(url)
                .headers(getHeader(false))
                .build()
                .execute(callback);
    }
}
