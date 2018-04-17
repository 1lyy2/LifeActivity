package com.example.administrator.rxjava2study;


import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/4/15.
 */

public class BottomDialogFragment extends DialogFragment implements View.OnClickListener {
    private TextView tv_title;//标题
    private TextView tv_content;//内容
    private TextView tv_cancel;//取消
    /**
     * 监听弹出窗是否被取消
     */
    private OnDialogCancelListener mCancelListener;
    private OnDialogBindViewSuccessListener mOnDialogBindViewSuccessListener;
    private onDialogConfirmListener mConfirmListener;

    public static BottomDialogFragment newInstance() {
        Bundle args = new Bundle();
        BottomDialogFragment fragment = new BottomDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void setOnDialogCancelListener(OnDialogCancelListener onDialogCancelListener) {
        mCancelListener = onDialogCancelListener;
    }

    public void setOnDialogBindViewSuccessListener(OnDialogBindViewSuccessListener onDialogBindViewSuccessListener) {
        this.mOnDialogBindViewSuccessListener = onDialogBindViewSuccessListener;
    }

    public void setConfirmListener(onDialogConfirmListener confirmListener) {
        mConfirmListener = confirmListener;
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        // 一定要设置Background，如果不设置，window属性设置无效
        window.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white)));
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.BOTTOM; // 显示在底部
        // 使用ViewGroup.LayoutParams，以便Dialog 宽度充满整个屏幕
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        window.setAttributes(params);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_dialog, container, false);
        tv_title = (TextView) view.findViewById(R.id.dialog_title);
        tv_content = (TextView) view.findViewById(R.id.dialog_content);
        tv_cancel = (TextView) view.findViewById(R.id.dialog_cancel);
        mOnDialogBindViewSuccessListener.onBindViewSuccess();
        tv_cancel.setOnClickListener(this);
        tv_content.setOnClickListener(this);
        getDialog().setCanceledOnTouchOutside(true);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_cancel:
                dismiss();
                break;
            case R.id.dialog_content:
                mConfirmListener.onConfirm();
                break;
            default:

                break;
        }
    }

    /**
     * dialog消失
     */
    public interface OnDialogCancelListener {
        void onCancel();
    }

    /**
     * 监听控件关联成功回调设置文本颜色字体，防止出现空指针问题
     */
    public interface OnDialogBindViewSuccessListener {
        void onBindViewSuccess();
    }

    public interface onDialogConfirmListener {
        void onConfirm();
    }


    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        mCancelListener.onCancel();
    }


    /**
     * 设置dialog的标题文字
     *
     * @param title
     */
    public void setTitleText(String title) {
        tv_title.setText(title);
    }

    /**
     * 设置dialog的标题文字颜色
     *
     * @param titleColor
     */
    public void setTitleColor(int titleColor) {
        tv_title.setTextColor(titleColor);
    }

    /**
     * 设置dialog的内容文字
     *
     * @param content
     */
    public void setContentText(String content) {
        tv_content.setText(content);
    }

    /**
     * 设置dialog的内容文字颜色
     *
     * @param contentColor
     */
    public void setContentColor(int contentColor) {
        tv_content.setTextColor(contentColor);
    }

    /**
     * 设置dialog的取消文字
     *
     * @param cancel
     */
    public void setCancelText(String cancel) {
        tv_cancel.setText(cancel);
    }

    /**
     * 设置dialog的取消文字颜色
     *
     * @param cancelColor
     */
    public void setCancelColor(int cancelColor) {
        tv_cancel.setTextColor(cancelColor);
    }
}
