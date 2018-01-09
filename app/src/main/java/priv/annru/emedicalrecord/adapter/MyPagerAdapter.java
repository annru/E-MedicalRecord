package priv.annru.emedicalrecord.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import priv.annru.emedicalrecord.base.BaseFragment;

/**
 * Created on 2018/1/9.
 *
 * @author 00224524
 *         首页ViewPager页卡数据适配器类
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> fragmentList;
    private String[] titles;


    public MyPagerAdapter(FragmentManager fm, List<BaseFragment> list, String[] titles) {
        super(fm);
        this.titles = titles;
        this.fragmentList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
