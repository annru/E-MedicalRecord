package priv.annru.emedicalrecord.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import priv.annru.emedicalrecord.R;
import priv.annru.emedicalrecord.activity.NewDiseaseCourseActivity;
import priv.annru.emedicalrecord.adapter.MyPagerAdapter;
import priv.annru.emedicalrecord.base.BaseFragment;

/**
 * Created on 2018/1/9.
 *
 * @author 00224524
 */

public class EMedicalRecordFragment extends BaseFragment {

    @BindView(R.id.tab)
    TabLayout tabLayout;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.action_btn)
    FloatingActionButton floatingActionButton;


    public static EMedicalRecordFragment getInstance() {
        EMedicalRecordFragment fragment = new EMedicalRecordFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_e_medical_record, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(SingleDiseaseFragment.getInstance());
        fragments.add(DataClassificationFragment.getInstance());
        fragments.add(DailyRecordFragment.getInstance());
        String[] tabsTitle = getResources().getStringArray(R.array.child_tabs_title);
        viewPager.setAdapter(new MyPagerAdapter(getChildFragmentManager(), fragments, tabsTitle));
        for (String title : tabsTitle) {
            tabLayout.addTab(tabLayout.newTab().setText(title));
        }
        tabLayout.setupWithViewPager(viewPager);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewDiseaseCourseActivity.goStart(getActivity());
            }
        });
    }
}
