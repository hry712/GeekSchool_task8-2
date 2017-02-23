package com.geekschoole.waimai_hry;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hery6 on 2017/1/9/0009.
 */

public class HomeFragment extends Fragment {

    private SearchView searchView;
    private ListView listView;
    private Toolbar toolbar;
    private GridView gridView;
    private int[] func_icons = {R.drawable.eat, R.drawable.buy, R.drawable.fruit, R.drawable.tea,
        R.drawable.tuhao, R.drawable.newdian, R.drawable.deliver, R.drawable.medicine};
    private String[] func_names = {"func1", "func2", "func3", "func4", "func5", "func6", "func7",
        "func8"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        toolbar = (Toolbar) view.findViewById(R.id.tb_home);
        listView = (ListView) view.findViewById(R.id.lv_search);
        gridView = (GridView) view.findViewById(R.id.gv_funcs);

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(true);

        SimpleAdapter gridAdapter = new SimpleAdapter(getActivity(), getData(), R.layout.home_grid_item,
                new String[]{"icon", "name"}, new int[]{R.id.imgbtn_iconImg, R.id.tv_iconName});
        gridView.setAdapter(gridAdapter);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.home_search, menu);
        MenuItem menuItem = menu.findItem(R.id.ab_search);
        searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)) {
                    listView.setFilterText(newText);
                } else {
                    listView.clearTextFilter();
                }
                return false;
            }
        });
        searchView.setSubmitButtonEnabled(true);
        searchView.setQueryHint("Search");
        searchView.setIconifiedByDefault(true);
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map;
        
        for (int i = 0; i < func_icons.length; i++) {
            map = new HashMap<>();
            map.put("icon", func_icons[i]);
            map.put("name", func_names[i]);
            list.add(map);
        }
        
        return list;
    }
}
