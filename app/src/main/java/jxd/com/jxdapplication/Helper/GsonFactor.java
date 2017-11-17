package jxd.com.jxdapplication.Helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Win7 on 2016/5/23.
 * Gson 工厂类
 */
public class GsonFactor {

    /**
     * 不以时间作为序列化的Gson对象
     *
     * @return 返回值
     */
    public static Gson CreateNotDate() {
        return new GsonBuilder().create();
    }

    /**
     * 创建以日期格式：HH:mm:ss 作序列化的Gson对象
     *
     * @return 返回值
     */
    public static Gson CreateForDateFormateHHMMSS() {
        return new GsonBuilder().disableHtmlEscaping().setDateFormat("HH:mm:ss").create();
    }

    /**
     * 创建以日期格式：yyyy-MM-dd'T'HH:mm:ss 作序列化的Gson对象
     *
     * @return 返回值
     */
    public static Gson CreateForDateFormate() {
        return new GsonBuilder().disableHtmlEscaping().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
    }

    /**
     * 创建以Html格式作序列化的Gson对象
     *
     * @return 返回值
     */
    public static Gson CreateForHtml() {
        return new GsonBuilder().disableHtmlEscaping().create();
    }
}
