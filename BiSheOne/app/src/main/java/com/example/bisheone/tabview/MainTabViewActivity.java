package com.example.bisheone.tabview;

import androidx.appcompat.app.AppCompatActivity;

//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentTransaction;

import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.bisheone.R;

public class MainTabViewActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txt_topbar, txt_home, txt_part, txt_find, txt_myself;
    private TextView textView4,textView3,textView2,textView1;
    private FrameLayout content;
    private FragmentTest fgt1, fgt2, fgt3, fgt4;

    private FragmentMyself myself;
    private FragmentSearch search;

    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//消除系统标题
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab_view);

        fragmentManager=getFragmentManager();

        bindViews();
        txt_home.performClick();//模拟一次点击，既进去后选择第一项
    }

    //UI组件初始化与事件绑定
    private void bindViews(){
        txt_topbar=findViewById(R.id.txt_topbar);
        txt_home=findViewById(R.id.txt_home);
        txt_part=findViewById(R.id.txt_part);
        txt_find=findViewById(R.id.txt_find);
        txt_myself=findViewById(R.id.txt_myself);
        content=(FrameLayout) findViewById(R.id.content);

        txt_home.setOnClickListener(this);
        txt_part.setOnClickListener(this);
        txt_find.setOnClickListener(this);
        txt_myself.setOnClickListener(this);
    }
    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fgt1 != null){
            fragmentTransaction.hide(fgt1);
        }
        if(fgt2 != null){
            fragmentTransaction.hide(fgt2);
        }
        if(search != null){
            fragmentTransaction.hide(search);
        }
        if(myself != null){
            fragmentTransaction.hide(myself);
        }
    }
    //重置所有文本的选中状态
    private void setSelected(){
        txt_home.setSelected(false);
        txt_part.setSelected(false);
        txt_find.setSelected(false);
        txt_myself.setSelected(false);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        hideAllFragment(fragmentTransaction);
        switch (v.getId()){
            case R.id.txt_home:
                textView1=findViewById(R.id.txt_topbar);
                textView1.setText("首页");
                setSelected();
                txt_home.setSelected(true);
                if (fgt1==null){
                    fgt1=new FragmentTest("第一个Fragment");
                    fragmentTransaction.add(R.id.content, fgt1);
                }else {
                    fragmentTransaction.show(fgt1);
                }
                break;
            case R.id.txt_part:
                textView2=findViewById(R.id.txt_topbar);
                textView2.setText("兼职秀");
                setSelected();
                txt_part.setSelected(true);
                if (fgt2==null){
                    fgt2=new FragmentTest("第二个Fragment");
                    fragmentTransaction.add(R.id.content, fgt2);
                }else {
                    fragmentTransaction.show(fgt2);
                }
                break;
            case R.id.txt_find:
                textView3=findViewById(R.id.txt_topbar);
                textView3.setText("我的圈子");
                setSelected();
                txt_find.setSelected(true);
                if (search==null){
                    search=new FragmentSearch();
                    fragmentTransaction.add(R.id.content, search);
                }else {
                    fragmentTransaction.show(search);
                }
                break;
            case R.id.txt_myself:
                textView4=findViewById(R.id.txt_topbar);
                textView4.setText("个人中心");
                setSelected();
                txt_myself.setSelected(true);
                if (myself==null){
                    myself=new FragmentMyself();
                    fragmentTransaction.add(R.id.content, myself);
                }else {
                    fragmentTransaction.show(myself);
                }
                break;
        }
        fragmentTransaction.commit();
    }
}
