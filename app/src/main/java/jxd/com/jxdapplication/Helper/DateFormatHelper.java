package jxd.com.jxdapplication.Helper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式化帮助类
 */
public class DateFormatHelper {

    /**
     * 字符串转Date
     *
     * @param dateString 时间字符串
     * @return 返回值 ("HH:mm")
     */
    public static Date fromHHmm(String dateString) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            return format.parse(dateString);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new Date();
    }

    /**
     * 字符串转Date
     *
     * @param dateString 时间字符串
     * @return 返回值 ("yyyy-MM-dd HH:mm")
     */
    public static Date yyyyMMddThhmm(String dateString) {
        if (!dateString.isEmpty()) {
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                return format.parse(dateString);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return new Date();
    }

    /**
     * 字符串转Date
     *
     * @param dateString 时间字符串
     * @return 返回值  ("yyyy-MM-dd'T'hh:mm:ss")
     */
    public static Date yyyyMMddThhmmss(String dateString) {
        if (!dateString.isEmpty()) {
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
                return format.parse(dateString);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return new Date();
    }

    /**
     * Date转字符串
     *
     * @param datetime 时间日期
     * @return 返回值 ("00:00")
     */
    public static String toHHmm(Date datetime) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            return format.format(datetime);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "00:00";
    }

    /**
     * Date转字符串
     *
     * @param datetime 时间日期
     * @return 返回值 ("00:00:00")
     */
    public static String ToHHmmss(Date datetime) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            return format.format(datetime);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "00:00:00";
    }

    /**
     * Date转字符串
     *
     * @param datetime 时间日期
     * @return 返回值 ("00-00-00")
     */
    public static String ToYYYYMMDD(Date datetime) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return format.format(datetime);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "00-00-00";
    }

    /**
     * Date转字符串
     *
     * @param datetime 时间日期
     * @return 返回值 ("00-00 00:00")
     */
    public static String ToMMDDHHMM(Date datetime) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");
            return format.format(datetime);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "00-00 00:00";
    }

    /**
     * Date转字符串
     *
     * @param datetime 时间日期
     * @return 返回值 ("0000-00-00 00:00")
     */
    public static String ToYYYYMMDDHHMM(Date datetime) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return format.format(datetime);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "0000-00-00 00:00";
    }
}
