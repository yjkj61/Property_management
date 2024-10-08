 package com.yjkj.property_management.java.adapter;

import android.content.Context;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yjkj.property_management.R;
import com.yjkj.property_management.java.bean.ContractBean;
import com.yjkj.property_management.java.bean.OtherFwBean;

 /**
 * @description 其他服务
 * @author Lenovo
 * @time 2023/10/17
 */
public class OtherFwAdapter extends BaseQuickAdapter<OtherFwBean, BaseViewHolder> {

    Context mcontext;

    public OtherFwAdapter(Context context) {
        super(R.layout.item_property_list, null);
        this.mcontext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, OtherFwBean item) {
        TextView tv_value = helper.getView(R.id.tv_value);

//        tv_value.setText();
    }

}
