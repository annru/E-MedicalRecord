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


    public MyPagerAdapter(FragmentManager fm, List<BaseFragment> list) {
        super(fm);
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
}
