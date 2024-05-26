 package com.yjkj.property_management.java.adapter;

import android.content.Context;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yjkj.property_management.R;
import com.yjkj.property_management.java.bean.AfBean;
import com.yjkj.property_management.java.bean.SosBean;

 /**
 * @description 安防
 * @author Lenovo
 * @time 2023/10/17
 */
public class AfAdapter extends BaseQuickAdapter<AfBean.RowsBean, BaseViewHolder> {

    Context mcontext;

    public AfAdapter(Context context) {
        super(R.layout.item_property_list, null);
        this.mcontext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, AfBean.RowsBean item) {
        TextView tv_value = helper.getView(R.id.tv_value);

        String type= "";
        if ("YG04".equals(item.getType())){
            type = "烟感报警";
        }else if("JJ01".equals(item.getType())){
            type = "紧急报警器";
        }else if("RT01".equals(item.getType())){
            type = "人体报警器";
        }else if("RL01:4G".equals(item.getType())){
            type = "双向老人报警器";
        }
        tv_value.setText("姓名：" + item.getOwnerName() + "\n" + "编号：" + item.getSerialNumber() + "\n" + "类型：" + type + "\n" + "上传时间：" + item.getUpTimeDate());
    }

}
