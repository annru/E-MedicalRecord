package priv.annru.emedicalrecord.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import priv.annru.emedicalrecord.R;
import priv.annru.emedicalrecord.base.BaseFragment;

/**
 * Created on 2018/1/9.
 *
 * @author 00224524 资料分类
 */

public class DataClassificationFragment extends BaseFragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    public static DataClassificationFragment getInstance() {
        DataClassificationFragment fragment = new DataClassificationFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_data_classification, container, false);
    }
}
