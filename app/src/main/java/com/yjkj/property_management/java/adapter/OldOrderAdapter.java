 package com.yjkj.property_management.java.adapter;

import android.content.Context;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yjkj.property_management.R;
import com.yjkj.property_management.java.bean.OldOrderBean;
import com.yjkj.property_management.java.bean.PropertyOrderBean;

 /**
  * @description 适老适配器
  * @author Lenovo
  * @time 2024/05/25
  */
public class OldOrderAdapter extends BaseQuickAdapter<OldOrderBean.RowsDTO, BaseViewHolder> {

    Context mcontext;

    public OldOrderAdapter(Context context) {
        super(R.layout.item_property_list, null);
        this.mcontext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, OldOrderBean.RowsDTO item) {
        TextView tv_value = helper.getView(R.id.tv_value);

        tv_value.setText("名称：" + item.getOwnerName() + "\n" + "服务名称：" + item.getAgentName() + "\n" + "服务人员：" + item.getWorkerName()
                + "\n" + "服务类型：" + item.getProjectName() + "\n" + "服务地址：" + item.getOwnerAddress());
    }

}
