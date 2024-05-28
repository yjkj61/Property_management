 package com.yjkj.property_management.java.adapter;

import android.content.Context;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yjkj.property_management.R;
import com.yjkj.property_management.java.bean.FoodOrderBean;
import com.yjkj.property_management.java.bean.PropertyOrderBean;

 /**
 * @description 餐饮适配器
 * @author Lenovo
 * @time 2024/05/25
 */
public class FoodOrderAdapter extends BaseQuickAdapter<FoodOrderBean.RowsDTO, BaseViewHolder> {

    Context mcontext;

    public FoodOrderAdapter(Context context) {
        super(R.layout.item_property_list, null);
        this.mcontext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, FoodOrderBean.RowsDTO item) {
        TextView tv_value = helper.getView(R.id.tv_value);

        tv_value.setText("名称：" + item.getRFoodCanteenName() + "\n" + "时间：" + item.getROrderTime() + "\n" + "地址：" + item.getROrderAddress());
    }

}
