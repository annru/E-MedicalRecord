package priv.annru.emedicalrecord.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import priv.annru.emedicalrecord.R;
import priv.annru.emedicalrecord.model.MedicalRecord;

/**
 * Created on 2018/1/12.
 *
 * @author 00224524
 *         单次病程数据列表适配器类
 */

public class SingleDiseaseAdapter extends RecyclerView.Adapter<SingleDiseaseAdapter.MyViewHolder> {
    private LayoutInflater mInflater;
    private List<MedicalRecord> mData;


    public SingleDiseaseAdapter(Context context, List<MedicalRecord> list) {
        mInflater = LayoutInflater.from(context);
        this.mData = list;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.fragment_single_disease_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.yearMonthTv.setText(getDateStr(0, mData.get(position).getDate()));
        holder.dayTv.setText(getDateStr(1, mData.get(position).getDate()));
        holder.departmentTv.setText(mData.get(position).getDepartment());
        holder.diagnosisTv.setText(mData.get(position).getDiagnosis());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.year_month_tv)
        TextView yearMonthTv;

        @BindView(R.id.day_tv)
        TextView dayTv;

        @BindView(R.id.department_tv)
        TextView departmentTv;

        @BindView(R.id.diagnosis_tv)
        TextView diagnosisTv;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    /**
     * 年月日日期字符串分开显示
     *
     * @param type 0：显示年月  1：显示天
     * @return String
     */
    private String getDateStr(int type, String dateStr) {
        int index = dateStr.lastIndexOf("-");
        String result = "";
        switch (type) {
            case 0:
                result = dateStr.substring(0, index);
                break;
            case 1:
                result = dateStr.substring(index + 1, dateStr.length());
                break;
            default:
                break;
        }
        return result;
    }
}
