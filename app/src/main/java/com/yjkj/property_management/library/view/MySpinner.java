package com.yjkj.property_management.library.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Spinner;

/**
 * @description 自定义默认不选中的spinner
 * @author: Lenovo
 * @date: 2024/5/23
 */
@SuppressLint("AppCompatCustomView")
public class MySpinner extends Spinner {

    private static final String TAG = "ybz_spinner";

    private int lastPosition = 0;

    public MySpinner(Context context, int mode) {
        super(context, mode);
    }

    public MySpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MySpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        super(context, attrs, defStyleAttr, mode);
    }

    // 一个 item 选中的时候，总是会触发 setSelection 方法
    // 所以在这个方法中，我们记录并检查上一次的selection position 就行了，如果是相同的，手动调用监听即可
    @Override
    public void setSelection(int position, boolean animate) {
        super.setSelection(position, animate);
        if (position == lastPosition) {
            if (getOnItemSelectedListener() != null)
                getOnItemSelectedListener().onItemSelected(this, getChildAt(position), position, 0);
        }
        lastPosition = position;
    }

    @Override
    public void setSelection(int position) {
        super.setSelection(position);
        if (getOnItemSelectedListener() != null) {
            getOnItemSelectedListener().onItemSelected(this, getChildAt(position), position, 0);
        }
        lastPosition = position;
    }
}
