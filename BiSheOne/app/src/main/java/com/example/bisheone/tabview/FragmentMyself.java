package com.example.bisheone.tabview;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import com.example.bisheone.R;
import com.example.bisheone.activity.SetActivity;

public class FragmentMyself extends Fragment {

//    private TextView tv_test;
    private LinearLayout linearLayout1;

//    @SuppressLint("ValidFragment")
    public FragmentMyself(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.myself_fragment, container,false);
//        tv_test=view.findViewById(R.id.test);
        linearLayout1=view.findViewById(R.id.ll_total);

        OnClick onClick=new OnClick();
        linearLayout1.setOnClickListener(onClick);

        return view;
    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=null;
            switch (v.getId()){
                case R.id.ll_total:
                    intent=new Intent(getActivity(), SetActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
