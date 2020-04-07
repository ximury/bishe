package com.example.bisheone.tabview;

import android.annotation.SuppressLint;
import android.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.bisheone.R;

public class FragmentTest extends Fragment {
    private String content;
    public FragmentTest(){

    }
    @SuppressLint("ValidFragment")
    public FragmentTest(String content) {
        this.content=content;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.test_fragment, container,false);

        TextView txt_content=view.findViewById(R.id.txt_content);
        txt_content.setText(content);
        return view;
    }
}
