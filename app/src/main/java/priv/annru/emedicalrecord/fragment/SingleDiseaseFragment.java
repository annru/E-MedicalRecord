package priv.annru.emedicalrecord.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import priv.annru.emedicalrecord.R;
import priv.annru.emedicalrecord.adapter.SingleDiseaseAdapter;
import priv.annru.emedicalrecord.base.BaseFragment;
import priv.annru.emedicalrecord.base.MyApplication;
import priv.annru.emedicalrecord.gen.MedicalRecordDao;
import priv.annru.emedicalrecord.model.MedicalRecord;

/**
 * Created on 2018/1/9.
 *
 * @author 00224524 单次病程
 */

public class SingleDiseaseFragment extends BaseFragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private SingleDiseaseAdapter mAdapter;
    private List<MedicalRecord> mData;


    public static SingleDiseaseFragment getInstance() {
        SingleDiseaseFragment fragment = new SingleDiseaseFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_single_disease, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        mData = getData();
        mAdapter = new SingleDiseaseAdapter(getActivity(), mData);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mData = getData();
    }

    private List<MedicalRecord> getData() {
        MedicalRecordDao medicalRecordDao = MyApplication.getInstance().getDaoSession().getMedicalRecordDao();
        return medicalRecordDao.loadAll();
    }


}
