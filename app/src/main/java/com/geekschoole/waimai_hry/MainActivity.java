package com.geekschoole.waimai_hry;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements ViewPager.OnPageChangeListener, FragmentTabHost.OnTabChangeListener{

    private FragmentTabHost fragmentTabHost;
    private LayoutInflater layoutInflater;
    private Class fragmentsArr[] = {HomeFragment.class, OrderFragment.class, AccountFragment.class};
    private int ImageViewArr[] = {R.drawable.bt_home_selector, R.drawable.bt_order_selector, R.drawable.bt_account_selector};
    private String TextArr[] = {"Index", "Order", "Account"};
    private List<Fragment> fragmentList = new ArrayList<>();
    private ViewPager pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initPages();
    }

    private void initView() {
        layoutInflater = LayoutInflater.from(this);

        pager = (ViewPager) findViewById(R.id.vp_fragments);
        pager.addOnPageChangeListener(this);
        fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        fragmentTabHost.setOnTabChangedListener(this);
        // 这里指定了 activity_main.xml 中的 R.id.fl_tabcontent FrameLayout 为 TabHost 要
        // 控制的 Fragment 对象
        fragmentTabHost.setup(this, getSupportFragmentManager(), R.id.fl_tabcontent);

        int count = fragmentsArr.length;
        for (int i = 0; i < count; i++) {
            // 设置好每个按钮底部的文字，以及图片样式
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(TextArr[i]).setIndicator(getTabItemView(i));
            fragmentTabHost.addTab(tabSpec, fragmentsArr[i], null);
            fragmentTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.bt_selector);
        }
    }

    private void initPages() {
        fragmentList.add(new HomeFragment());
        fragmentList.add(new OrderFragment());
        fragmentList.add(new AccountFragment());

        pager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), fragmentList));
        fragmentTabHost.getTabWidget().setDividerDrawable(null);
    }

    // 用于产生一个底部栏菜单中的一个按钮 View
    private View getTabItemView(int index) {
        View view = layoutInflater.inflate(R.layout.tab_item_view, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.iv_icon);
        imageView.setImageResource(ImageViewArr[index]);

        TextView textView = (TextView) view.findViewById(R.id.tv_text);
        textView.setText(TextArr[index]);

        return view;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        TabWidget widget = fragmentTabHost.getTabWidget();
        int oldFocusability = widget.getDescendantFocusability();
        widget.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        fragmentTabHost.setCurrentTab(position);
        widget.setDescendantFocusability(oldFocusability);
    }

    @Override
    public void onTabChanged(String s) {
        int position = fragmentTabHost.getCurrentTab();
        pager.setCurrentItem(position);
    }
}
