 package com.yjkj.property_management.java.adapter;

import android.content.Context;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yjkj.property_management.R;
import com.yjkj.property_management.java.bean.DealWithOneBean;
import com.yjkj.property_management.java.bean.DealWithTwoBean;

 /**
 * @description 合同列表
 * @author Lenovo
 * @time 2023/10/17
 */
public class DealWithAdapterOne extends BaseQuickAdapter<DealWithOneBean.RowsBean, BaseViewHolder> {

    Context mcontext;

    public DealWithAdapterOne(Context context) {
        super(R.layout.item_property_list, null);
        this.mcontext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, DealWithOneBean.RowsBean item) {
        TextView tv_value = helper.getView(R.id.tv_value);

        tv_value.setText("商家名称：" + item.getBusinessName() + "\n" + "店铺名称：" + item.getShopName() + "\n" + "地址：" + item.getAddress() + "\n" + "联系电话：" + item.getContactPhone());
    }

}
