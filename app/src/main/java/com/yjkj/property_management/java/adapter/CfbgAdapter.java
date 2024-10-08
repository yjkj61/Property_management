 package com.yjkj.property_management.java.adapter;

import android.content.Context;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yjkj.property_management.R;
import com.yjkj.property_management.java.bean.AfBean;
import com.yjkj.property_management.java.bean.CfbgBean;

 /**
 * @description 安防
 * @author Lenovo
 * @time 2023/10/17
 */
public class CfbgAdapter extends BaseQuickAdapter<AfBean.RowsBean, BaseViewHolder> {

    Context mcontext;

    public CfbgAdapter(Context context) {
        super(R.layout.item_property_list, null);
        this.mcontext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, AfBean.RowsBean item) {
        TextView tv_value = helper.getView(R.id.tv_value);

    }

}
