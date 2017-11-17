package jxd.com.jxdapplication.Helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Win7 on 2016/5/12.
 * 图片操作类
 */
public class ImageHelper {

    /**
     * base64字符串转Bitmap
     *
     * @param string base64字符串
     * @return 返回值
     */
    public static Bitmap stringtoBitmap(String string) {
        Bitmap bitmap = null;
        try {
            byte[] bitmapArray;
            //去掉html所需的html前缀
            string = string.replace("data:image/png;base64,", "");//对png图片的处理
            bitmapArray = Base64.decode(string, Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
        } catch (Exception e) {
            e.printStackTrace();
            bitmap = null;
        }
        return bitmap;
    }

    /**
     * Bitmap转Base64字符串
     *
     * @param bitmap Bitmap
     * @return 返回值
     */
    public static String bitmaptoString(Bitmap bitmap) {
        String string = null;
        ByteArrayOutputStream bStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bStream);
        byte[] bytes = bStream.toByteArray();
        string = Base64.encodeToString(bytes, Base64.DEFAULT);
        return string;
    }

    /**
     * 通过URI转Bitmap
     *
     * @param context 上下文
     * @param uri     Uri
     * @return 返回值
     */
    public static Bitmap getBitmapFromUri(Context context, Uri uri) {
        try {
            return MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 等宽压缩图片
     *
     * @param sourceBitmap Bitmap
     * @param maxWidth     最大宽度
     * @return 返回值
     */
    public static Bitmap scaleBitmap(Bitmap sourceBitmap, int maxWidth) {
        float width = sourceBitmap.getWidth();
        float height = sourceBitmap.getHeight();
        if (width > maxWidth) {
            // 创建操作图片用的matrix对象
            Matrix matrix = new Matrix();
            // 计算宽高缩放率
            float scaleWidth = maxWidth / width;
            // 缩放图片动作
            matrix.postScale(scaleWidth, scaleWidth);
            return Bitmap.createBitmap(sourceBitmap, 0, 0, (int) width,
                    (int) height, matrix, true);
        }
        return sourceBitmap;
    }

    /**
     * 通过uri删除图片
     *
     * @param context 上下文
     * @param uri     Uri
     */
    public static void deleteFromUri(Context context, Uri uri) {
        context.getContentResolver().delete(uri, null, null);
    }

    /**
     * 通过URL生成Bitmap
     *
     * @param url 图片Url
     * @return 返回值
     */
    public static Bitmap returnBitMap(String url) {
        URL myFileUrl = null;
        Bitmap bitmap = null;
        try {
            myFileUrl = new URL(url);
            HttpURLConnection conn;
            conn = (HttpURLConnection) myFileUrl.openConnection();
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bitmap;
    }

    /**
     * 获取圆角位图的方法
     *
     * @param bitmap 需要转化成圆角的位图
     * @param pixels 圆角的度数，数值越大，圆角越大
     * @return 处理后的圆角位图
     */
    public static Bitmap toRoundCornerImage(Bitmap bitmap, int pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        // 抗锯齿
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, (float) pixels, (float) pixels, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }
}
