 package com.yjkj.property_management.java.adapter;

import android.content.Context;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yjkj.property_management.R;
import com.yjkj.property_management.java.bean.PropertyOrderBean;
import com.yjkj.property_management.java.bean.ShopOrderBean;

 /**
  * @description 商城适配器
  * @author Lenovo
  * @time 2024/05/25
  */
public class ShopOrderAdapter extends BaseQuickAdapter<ShopOrderBean.RowsDTO.SOrderPoListDTO, BaseViewHolder> {

    Context mcontext;

    public ShopOrderAdapter(Context context) {
        super(R.layout.item_property_list, null);
        this.mcontext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopOrderBean.RowsDTO.SOrderPoListDTO item) {
        TextView tv_value = helper.getView(R.id.tv_value);

        tv_value.setText("商家名称：" + item.getBusinessName() + "\n" + "地址：" + item.getAddress() + "\n" + "联系方式：" + item.getPhone() + "\n" + "时间：" + item.getCreateOrderTime());
    }

}
