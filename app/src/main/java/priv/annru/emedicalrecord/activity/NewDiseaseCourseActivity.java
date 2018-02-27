package priv.annru.emedicalrecord.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import priv.annru.emedicalrecord.R;
import priv.annru.emedicalrecord.base.BaseActivity;
import priv.annru.emedicalrecord.base.MyApplication;
import priv.annru.emedicalrecord.dialog.CommonDialog;
import priv.annru.emedicalrecord.gen.MedicalRecordDao;
import priv.annru.emedicalrecord.model.MedicalRecord;

/**
 * Created on 2018/1/11.
 *
 * @author 00224524  新建病程
 */

public class NewDiseaseCourseActivity extends BaseActivity {

    @BindView(R.id.user_name_edit)
    EditText userNameEdit;

    @BindView(R.id.data_edit)
    EditText dateEdit;

    @BindView(R.id.department_edit)
    EditText departmentEdit;

    @BindView(R.id.diagnosis_edit)
    EditText diagnosisEdit;

    @BindView(R.id.the_illness_edit)
    EditText illnessEdit;


    public static void goStart(Activity activity) {
        Intent intent = new Intent(activity, NewDiseaseCourseActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_disease_course);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.data_edit, R.id.save_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.data_edit:
                showDatePickerDialog();
                break;
            case R.id.save_btn:
                customDialog();
                if (userNameEdit.getText().toString().trim().isEmpty()) {
                    return;
                }
                if (dateEdit.getText().toString().trim().isEmpty()) {
                    return;
                }
                if (departmentEdit.getText().toString().trim().isEmpty()) {
                    return;
                }
                if (diagnosisEdit.getText().toString().trim().isEmpty()) {
                    return;
                }
                if (illnessEdit.getText().toString().trim().isEmpty()) {
                    return;
                }
                save();
                finish();
                break;
            default:
                break;
        }
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(this, 0, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String dateStr = year + "-" + (++month) + "-" + dayOfMonth;
                dateEdit.setText(dateStr);
            }
        }, year, month, day);
        dialog.show();
    }

    private void save() {
        MedicalRecordDao medicalRecordDao = MyApplication.getInstance().getDaoSession().getMedicalRecordDao();
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setName(userNameEdit.getText().toString());
        medicalRecord.setDate(dateEdit.getText().toString());
        medicalRecord.setDepartment(departmentEdit.getText().toString());
        medicalRecord.setDiagnosis(diagnosisEdit.getText().toString());
        medicalRecord.setIllness(illnessEdit.getText().toString());
        medicalRecordDao.insert(medicalRecord);
    }


    private void customDialog() {
        CommonDialog.with(this)
                .title("自定义对话框标题")
                .message("这是内容")
                .leftButtonText("取消", new CommonDialog.Builder.ButtonClickListener() {
                    @Override
                    public void onClick(CommonDialog dialog) {
                        dialog.dismiss();
                    }
                })
                .rightButtonText("确定", new CommonDialog.Builder.ButtonClickListener() {
                    @Override
                    public void onClick(CommonDialog dialog) {
                        dialog.dismiss();
                        dialog.cancel();
                        Toast.makeText(NewDiseaseCourseActivity.this, "退出", Toast.LENGTH_LONG).show();
                    }
                })
                .create()
                .show();
    }
}
