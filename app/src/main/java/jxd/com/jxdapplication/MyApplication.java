package jxd.com.jxdapplication;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.Logger;

/**
 * Created by 46123 on 2017/11/17.
 */

public class MyApplication extends Application {

    /**
     * 全局context
     */
    private static Context mContext;

    /**
     * log打印
     */
    private final String TAG = "MyApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        MyApplication.mContext = getApplicationContext();
        Logger.init(TAG);
    }

    /**
     * 开放获取接口
     *
     * @return 返回上下文
     */
    public static Context getContext() {
        return mContext;
    }
}
