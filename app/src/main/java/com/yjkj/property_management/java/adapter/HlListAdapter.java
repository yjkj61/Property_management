 package com.yjkj.property_management.java.adapter;

import android.content.Context;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yjkj.property_management.R;
import com.yjkj.property_management.java.bean.AfBean;
import com.yjkj.property_management.java.bean.HlListBean;

 /**
 * @description 安防
 * @author Lenovo
 * @time 2023/10/17
 */
public class HlListAdapter extends BaseQuickAdapter<HlListBean, BaseViewHolder> {

    Context mcontext;

    public HlListAdapter(Context context) {
        super(R.layout.item_property_list, null);
        this.mcontext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HlListBean item) {
        TextView tv_value = helper.getView(R.id.tv_value);

//        tv_value.setText("姓名：" + item.getOwnerName() + "\n" + "编号：" + item.getSerialNumber() + "\n" + "类型：" + type + "\n" + "上传时间：" + item.getUpTimeDate());
    }

}
