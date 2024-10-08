 package com.yjkj.property_management.java.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yjkj.property_management.R;
import com.yjkj.property_management.java.bean.PropertyOrderBean;

 /**
 * @description 告警信息
 * @author Lenovo
 * @time 2023/10/17
 */
public class PropertyOrderAdapter extends BaseQuickAdapter<PropertyOrderBean.RowsDTO, BaseViewHolder> {

    Context mcontext;

    public PropertyOrderAdapter(Context context) {
        super(R.layout.item_property_list, null);
        this.mcontext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, PropertyOrderBean.RowsDTO item) {
        TextView tv_value = helper.getView(R.id.tv_value);

        tv_value.setText("服务名称：" + item.getAgentName() + "\n" + "服务类型：" + item.getProjectName() + "\n" + "服务人员：" + item.getWorkerName() + "\n" + "地址：" + item.getOwnerAddress());
    }

}
