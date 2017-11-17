package jxd.com.jxdapplication.Helper;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by Administrator on 2017/9/20 0020.
 * Glide图片加载帮助类
 */

public class GlideHelper {

    /**
     * 直接加载网络图片
     * with(Context context). 使用Application上下文，Glide请求将不受Activity/Fragment生命周期控制。
     * with(Activity activity).使用Activity作为上下文，Glide的请求会受到Activity生命周期控制。
     * with(FragmentActivity activity).Glide的请求会受到FragmentActivity生命周期控制。
     * with(android.app.Fragment fragment).Glide的请求会受到Fragment 生命周期控制。
     * with(android.support.v4.app.Fragment fragment).Glide的请求会受到Fragment生命周期控制。
     * <p>
     * load SD卡资源：load("file://"+ Environment.getExternalStorageDirectory().getPath()+"/test.jpg")
     * load assets资源：load("file:///android_asset/f003.gif")
     * load drawable资源：load("android.resource://com.frank.glide/drawable/news")或
     * load("android.resource://com.frank.glide/drawable/"+R.drawable.news)
     *
     * @param context   上下文
     * @param url       加载图片地址
     * @param imageView 控件
     */
    public static void loadImage(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).into(imageView);
    }

    /**
     * 加载资源图片
     *
     * @param context   上下文
     * @param res       加载图片地址
     * @param imageView 控件
     */
    public static void loadImage(Context context, int res, ImageView imageView) {
        Glide.with(context).load(res).into(imageView);
    }

    /**
     * 带加载中以及加载失败的加载图片
     *
     * @param context   上下文
     * @param url       加载图片地址
     * @param imageView 控件
     */
    public static void loadImagePlaceHolder(Context context, String url, ImageView imageView) {
        RequestOptions mOptions = new RequestOptions()
                .centerCrop() // 填充方式
//                .placeholder(R.drawable.bg_imgloding) // 等待加载的占位图片
//                .error(R.drawable.icon_defaultlogo) // 加载失败的占位图片
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC) // 缓存方式
                .priority(Priority.HIGH); // 优先加载
        Glide.with(context).load(url).apply(mOptions).into(imageView);
    }
}
