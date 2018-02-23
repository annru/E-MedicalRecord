package priv.annru.emedicalrecord.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import priv.annru.emedicalrecord.R;
import priv.annru.emedicalrecord.util.Utils;


/**
 * Created on 2018/2/1.
 * 使用建造者模式自定义dialog
 *
 * @author 00224524
 */

public class CommonDialog extends Dialog implements View.OnClickListener {
    private static Builder builder;

    private Builder.ButtonClickListener leftButtonListener;
    private Builder.ButtonClickListener rightButtonListener;


    CommonDialog(DialogParams params) {
        super(params.context);
        View contentView = LayoutInflater.from(params.context).inflate(R.layout.dialog_common, null);
        setContentView(contentView);
        TextView titleTv = contentView.findViewById(R.id.dialog_common_title);
        TextView messageTv = contentView.findViewById(R.id.dialog_common_content_tv);
        Button leftButton = contentView.findViewById(R.id.dialog_common_cancel_btn);
        Button rightButton = contentView.findViewById(R.id.dialog_common_ok_btn);
        titleTv.setText(params.title);
        messageTv.setText(params.message);
        leftButton.setText(params.leftButtonText);
        rightButton.setText(params.rightButtonText);
        leftButtonListener = params.leftListener;
        rightButtonListener = params.rightListener;
        leftButton.setOnClickListener(this);
        rightButton.setOnClickListener(this);
        setCanceledOnTouchOutside(params.cancelOnTouchOutside);

        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.width = (int) (Utils.getScrrenWidth(params.context) * 0.8);
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            window.setAttributes(lp);
        }


    }

    public static Builder with(Context context) {
        if (builder == null) {
            builder = new Builder(context);
        }
        return builder;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_common_cancel_btn:
                leftButtonListener.onClick(this);
                break;
            case R.id.dialog_common_ok_btn:
                rightButtonListener.onClick(this);
                break;
            default:
                break;
        }
    }


    public static class Builder {

        private DialogParams params;

        Builder(Context context) {
            params = new DialogParams();
            params.context = context;
        }

        public CommonDialog create() {
            return new CommonDialog(params);
        }

        public Builder title(String title) {
            params.title = title;
            return builder;
        }

        public Builder message(String msg) {
            params.message = msg;
            return builder;
        }

        public Builder cancelOnTouchOutside(boolean flag) {
            params.cancelOnTouchOutside = flag;
            return builder;
        }

        public Builder leftButtonText(String leftText, ButtonClickListener listener) {
            params.leftButtonText = leftText;
            params.leftListener = listener;
            return builder;
        }

        public Builder rightButtonText(String rightText, ButtonClickListener listener) {
            params.rightButtonText = rightText;
            params.rightListener = listener;
            return builder;
        }

        public interface ButtonClickListener {
            /**
             * 按钮点击事件
             *
             * @param dialog 对话框对象实例
             */
            void onClick(CommonDialog dialog);
        }
    }

    static class DialogParams {
        private Context context;
        private String title;
        private String message;
        private String leftButtonText;
        private String rightButtonText;
        private boolean cancelOnTouchOutside;
        private Builder.ButtonClickListener leftListener;
        private Builder.ButtonClickListener rightListener;
    }
}
