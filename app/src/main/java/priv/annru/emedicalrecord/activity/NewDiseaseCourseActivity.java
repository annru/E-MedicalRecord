package priv.annru.emedicalrecord.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import priv.annru.emedicalrecord.R;
import priv.annru.emedicalrecord.base.BaseActivity;

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
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_new_disease_course);
        ButterKnife.bind(this);
    }
}
