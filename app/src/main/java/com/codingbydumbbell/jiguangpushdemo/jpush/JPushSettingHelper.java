package com.codingbydumbbell.jiguangpushdemo.jpush;

import android.content.Context;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;

public class JPushSettingHelper {

    private static final String TAG = JPushSettingHelper.class.getSimpleName();

    // 用户自定义的操作序列号，同操作结果一起返回，用来标识一次操作的唯一性。
    private static final int SEQUENCES_ALIAS = 53;
    private static final int SEQUENCES_TAGS = 62;

    private Context context;

    public JPushSettingHelper(Context context) {
        this.context = context;
    }

    public void initJPush() {

        // debug 为 true 则会打印 debug 级别的日志，false 则只会打印 warning 级别以上的日志
        JPushInterface.setDebugMode(true);

        // context 应用的 ApplicationContext
        JPushInterface.init(context);

        // 集成了 JPush SDK 的应用程序在第一次成功注册到 JPush 服务器时，JPush 服务器会给客户端返回一个唯一的该设备的标识 - RegistrationID。
        Log.d(TAG, "RegistrationID:" + JPushInterface.getRegistrationID(context));

        setAlias();
        setTags();
    }

    // 通常我們會放使用者帳號這種具唯一特性的值
    private void setAlias() {
        String alias = "Rick";
        JPushInterface.setAlias(context, SEQUENCES_ALIAS, alias);
    }

    // 通常就是分類標籤，通常不止一個
    private void setTags() {
        Set<String> tags = new HashSet<>();
        tags.add("TagA");
        tags.add("TagB");
        JPushInterface.setTags(context, SEQUENCES_TAGS, tags);
    }
}
