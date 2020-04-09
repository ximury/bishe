package com.example.bisheone.util;

import android.os.Handler;
import android.view.View;

public class MyClickListener implements View.OnClickListener {
    //记录连续点击次数
    private int clickCount = 0;
    private Handler handler;
    private DoubleClickCallBack myClickCallBack;

    public interface DoubleClickCallBack {
        //点击一次的回调
        void oneClick(View view);

        //连续点击两次的回调
        void doubleClick(View view);

    }

    public MyClickListener(MyClickListener.DoubleClickCallBack myClickCallBack) {
        this.myClickCallBack = myClickCallBack;
        handler = new Handler();
    }

    @Override
    public void onClick(View v) {
        clickCount++;
        //双击间二百毫秒延时
        int timeout = 200;
        handler.postDelayed(() -> {
            if (clickCount == 1) {
                myClickCallBack.oneClick(v);
            } else if (clickCount == 2) {
                myClickCallBack.doubleClick(v);
            }
            //清空handler延时，并防内存泄漏
            handler.removeCallbacksAndMessages(null);
            //计数清零
            clickCount = 0;
        }, timeout);//延时timeout后执行run方法中的代码
    }
}