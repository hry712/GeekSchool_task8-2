package com.geekschoole.waimai_hry;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hery6 on 2017/1/9/0009.
 */

public class OrderFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_order, null);
//        Toolbar toolbar = (Toolbar) view.findViewById(R.id.tb_order);
//        toolbar.setTitle("Order");
        return inflater.inflate(R.layout.fragment_order, null);
    }
}