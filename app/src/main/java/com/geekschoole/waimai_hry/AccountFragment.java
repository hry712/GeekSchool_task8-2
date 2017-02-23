package com.geekschoole.waimai_hry;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hery6 on 2017/1/9/0009.
 */

public class AccountFragment extends Fragment {

    private SimpleAdapter listAdapter_1, listAdapter_2, listAdapter_3;
    private ListView list_1, list_2, list_3;
    private Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, null);

        list_1 = (ListView) view.findViewById(R.id.lv_items_1);
        list_2 = (ListView) view.findViewById(R.id.lv_items_2);
        list_3 = (ListView) view.findViewById(R.id.lv_items_3);
        toolbar = (Toolbar) view.findViewById(R.id.tb_account);
        toolbar.inflateMenu(R.menu.account_setting);

        listAdapter_1 = new SimpleAdapter(getActivity(),
                getItemsDataOne(),
                R.layout.account_list_item,
                new String[]{"text", "image"},
                new int[]{R.id.tv_item_text, R.id.iv_item_img});
        listAdapter_2 = new SimpleAdapter(getActivity(),
                getItemsDataTwo(),
                R.layout.account_list_item,
                new String[]{"text", "image"},
                new int[]{R.id.tv_item_text, R.id.iv_item_img});
        listAdapter_3 = new SimpleAdapter(getActivity(),
                getItemsDataThree(),
                R.layout.account_list_item,
                new String[]{"text", "image"},
                new int[]{R.id.tv_item_text, R.id.iv_item_img});

        list_1.setAdapter(listAdapter_1);
        list_2.setAdapter(listAdapter_2);
        list_3.setAdapter(listAdapter_3);

        return view;
    }

    private List<Map<String, Object>> getItemsDataOne() {
        List<Map<String, Object>> listTemp = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("text", "My dinning address");
        map.put("image", R.drawable.mypage_list_icon_location);
        listTemp.add(map);

        map = new HashMap<>();
        map.put("text", "My vounchers");
        map.put("image", R.drawable.mypage_list_icon_daijinjuan);
        listTemp.add(map);

        map = new HashMap<>();
        map.put("text", "My achievements");
        map.put("image", R.drawable.mypage_list_icon_refund);
        listTemp.add(map);

//        map.put("text", "My Messages");
//        map.put("image", R.drawable.)
//
//        map.put("text", "My Collection");
//        map.put("text", "My Comments");
//        map.put("text", "Baidu wallet");
//        map.put("text", "Baidu nuomi");

        return listTemp;
    }

    private List<Map<String, Object>> getItemsDataTwo() {
        List<Map<String, Object>> listTemp = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("text", "Messages");
        map.put("image", R.drawable.my_messages);
        listTemp.add(map);

        map = new HashMap<>();
        map.put("text", "Collection");
        map.put("image", R.drawable.mypage_list_icon_star);
        listTemp.add(map);

        map = new HashMap<>();
        map.put("text", "Comments");
        map.put("image", R.drawable.mypage_list_icon_comment);
        listTemp.add(map);

        return listTemp;
    }

    private List<Map<String, Object>> getItemsDataThree() {
        List<Map<String, Object>> listTemp = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("text", "Baidu wallet");
        map.put("image", R.drawable.mypage_list_icon_wallet);
        listTemp.add(map);

        map = new HashMap<>();
        map.put("text", "Baidu NuoMi");
        map.put("image", R.drawable.icon_nuomi);
        listTemp.add(map);

        return listTemp;
    }
}
