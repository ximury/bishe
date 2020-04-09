package com.example.bisheone.tabview;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.bisheone.MainActivity;
import com.example.bisheone.R;
import com.example.bisheone.activity.SetActivity;
import com.example.bisheone.activity.ad.DataBean;
import com.example.bisheone.activity.ad.ImageAdapter;
import com.google.android.material.snackbar.Snackbar;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.indicator.RoundLinesIndicator;
import com.youth.banner.listener.OnPageChangeListener;
import com.youth.banner.util.BannerUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentHome extends Fragment implements OnPageChangeListener{

    @BindView(R.id.banner)
    Banner banner;

    @BindView(R.id.indicator)
    RoundLinesIndicator indicator;

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout refresh;

    public FragmentHome() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home_fragment, container,false);
        ButterKnife.bind(this,view);//如果是在activity里，应该写作ButterKnife.bind(this);
       //设置适配器
        banner.setAdapter(new ImageAdapter(DataBean.getTestData()));
        //设置指示器
        banner.setIndicator(new CircleIndicator(getActivity()));
        //设置点击事件
        //-> 符号左边是接受的参数，符号右边复是打算进行的函数操作
        banner.setOnBannerListener((data, position) -> {
            Snackbar.make(banner, ((DataBean) data).title, Snackbar.LENGTH_SHORT).show();
            Log.i("TAG",String.valueOf(position));
            Intent intent=null;
            switch (position){
                case 0:
                    intent=new Intent(getActivity(), MainActivity.class);
                    break;
                case 1:
                    intent=new Intent(getActivity(), SetActivity.class);
                    break;
                case 2:
                    intent=new Intent(getActivity(), MainActivity.class);
                    break;
                default:
                    intent=new Intent(getActivity(), SetActivity.class);
                    break;
            }
            startActivity(intent);
        });

        //添加切换监听
        banner.addOnPageChangeListener((OnPageChangeListener) this);
        //圆角
        banner.setBannerRound(BannerUtils.dp2px(5));


        //和下拉刷新配套使用
        refresh.setOnRefreshListener(() -> {
            //模拟网络请求需要2秒，请求完成，设置setRefreshing 为false
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    refresh.setRefreshing(false);
                    //给banner重新设置数据
                    banner.setDatas(DataBean.getTestData());
                }
            }, 2000);
        });

        return view;


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    /**
     * 如果你需要考虑更好的体验，可以这么操作
     */
    @Override
    public void onStart() {
        super.onStart();
        banner.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stop();
    }
}
