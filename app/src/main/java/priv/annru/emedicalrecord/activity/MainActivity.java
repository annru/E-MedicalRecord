package priv.annru.emedicalrecord.activity;

import android.content.res.ColorStateList;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import priv.annru.emedicalrecord.R;
import priv.annru.emedicalrecord.adapter.MyPagerAdapter;
import priv.annru.emedicalrecord.base.BaseFragment;
import priv.annru.emedicalrecord.fragment.EMedicalRecordFragment;

/**
 * @author annru
 * @date 2018-01-09
 * 主页
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.tab)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(EMedicalRecordFragment.getInstance());
        fragments.add(EMedicalRecordFragment.getInstance());
        fragments.add(EMedicalRecordFragment.getInstance());
        String[] tabsTitle = getResources().getStringArray(R.array.tabs_title);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), fragments, tabsTitle));
        for (String title : tabsTitle) {
            tabLayout.addTab(tabLayout.newTab().setText(title));
        }
        tabLayout.setupWithViewPager(viewPager);
    }
}
