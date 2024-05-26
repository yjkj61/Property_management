 package com.yjkj.property_management.java.adapter;

import android.content.Context;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yjkj.property_management.R;
import com.yjkj.property_management.java.bean.ContractBean;
import com.yjkj.property_management.java.bean.HlfwBean;

 /**
 * @description 护理服务
 * @author Lenovo
 * @time 2023/10/17
 */
public class HlfwAdapter extends BaseQuickAdapter<HlfwBean, BaseViewHolder> {

    Context mcontext;

    public HlfwAdapter(Context context) {
        super(R.layout.item_property_list, null);
        this.mcontext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HlfwBean item) {
        TextView tv_value = helper.getView(R.id.tv_value);

//        tv_value.setText();
    }

}
