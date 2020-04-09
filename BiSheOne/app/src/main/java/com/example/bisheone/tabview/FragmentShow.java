package com.example.bisheone.tabview;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.bisheone.R;
import com.example.bisheone.activity.SetActivity;
import com.example.bisheone.util.DoubleClickListener;
import com.example.bisheone.util.MyClickListener;

public class FragmentShow extends Fragment {
    ImageView imageView1,imageView2,imageView3,imageView4;

    public FragmentShow() {
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.show_fragment, container, false);
        imageView1=view.findViewById(R.id.iv_tip1);
//        imageView1=view.findViewById(R.id.iv_tip1);
        imageView2=view.findViewById(R.id.iv_tip2);
        imageView3=view.findViewById(R.id.iv_tip3);
        imageView4=view.findViewById(R.id.iv_tip4);

        Glide.with(this)
                .load(R.mipmap.star_one)
                .placeholder(R.mipmap.like)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView1);
        Glide.with(this)
                .load(R.mipmap.star_two)
                .into(imageView2);
        Glide.with(this)
                .load(R.mipmap.star_five)
                .into(imageView3);
        Glide.with(this)
                .load(R.mipmap.star_four)
                .into(imageView4);

        new Thread(new Runnable() {
            Intent intent=null;
            @Override
            public void run() {
                Looper.prepare();
                //以下方式不能实现双击效果，会被单击效果截断
                //实现双击开启动画
/**                imageView1.setOnClickListener(new DoubleClickListener() {
                    @Override
                    public void onDoubleClick(View v) {
                        //创建动画对象(透明度渐变动画)
                        Animation anim= AnimationUtils.loadAnimation(getActivity(), R.anim.alpha);
                        imageView1.startAnimation(anim);
                    }
                });
                //实现单击进行跳转
                imageView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intent=new Intent(getActivity(), SetActivity.class);
                        startActivity(intent);
                    }
                });
 **/
                imageView1.setOnClickListener(new MyClickListener(new MyClickListener.DoubleClickCallBack() {
                    //实现单击进行跳转
                    @Override
                    public void oneClick(View view) {
                        intent=new Intent(getActivity(), SetActivity.class);
                        startActivity(intent);
                    }

                    //实现双击开启动画
                    @Override
                    public void doubleClick(View view) {
                        //创建动画对象(透明度渐变动画)
                        Animation anim= AnimationUtils.loadAnimation(getActivity(), R.anim.alpha);
                        imageView1.startAnimation(anim);
                    }
                }));
                Looper.loop();
            }

        }).start();


        return view;
    }
}