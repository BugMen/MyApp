package jxd.com.jxdapplication.HttpReQuest;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Landy.K
 * 业务逻辑，数据回调操作定义
 */
public class DataCallBack<T> {

    /**
     * 获取数据成功时回调
     *
     * @param t 泛型
     */
    public void onSuccess(T t) {}

    /**
     * 获取数据失败时回调
     * 不重构则使用默认操作
     * 弹出错误提示窗口
     *
     * @param context   上下文
     * @param errorCode 错误码
     * @param title     标题
     * @param message   错误
     */
    public void onError(Context context, String errorCode, String title, String message) {
        if (message == null) {
            Toast.makeText(context, "网络请求超时。", Toast.LENGTH_SHORT).show();
        } else if (message.contains("http")) {
            Toast.makeText(context, "网络请求失败，请检查网络后重试。", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }
}
