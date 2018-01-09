package priv.annru.emedicalrecord.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import priv.annru.emedicalrecord.base.BaseFragment;

/**
 * Created on 2018/1/9.
 *
 * @author 00224524
 */

public class EMedicalRecordFragment extends BaseFragment {


    public static EMedicalRecordFragment getInstance() {
        EMedicalRecordFragment fragment = new EMedicalRecordFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
