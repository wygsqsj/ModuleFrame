package com.wygsqsj.moduleframe;

import androidx.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wygsqsj.common.base.BaseApplication;

public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //突破65535的限制
        MultiDex.install(this);
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
        //ARouter配置
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openLog();     // 打印日志
        }
    }
}
