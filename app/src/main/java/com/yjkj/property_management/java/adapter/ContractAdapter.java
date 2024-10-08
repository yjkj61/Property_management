 package com.yjkj.property_management.java.adapter;

import android.content.Context;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yjkj.property_management.R;
import com.yjkj.property_management.java.bean.ContractBean;
import com.yjkj.property_management.java.bean.PropertyOrderBean;

 /**
 * @description 合同列表
 * @author Lenovo
 * @time 2023/10/17
 */
public class ContractAdapter extends BaseQuickAdapter<ContractBean.RowsBean, BaseViewHolder> {

    Context mcontext;

    public ContractAdapter(Context context) {
        super(R.layout.item_property_list, null);
        this.mcontext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ContractBean.RowsBean item) {
        TextView tv_value = helper.getView(R.id.tv_value);

        tv_value.setText("合同名称：" + item.getContractTemplateName() + "\n"
                + "公司名称：" + item.getCompanyName() + "\n"
                + "合同编号：" + item.getContractNumber() + "\n"
                + "开始时间：" + item.getStartDate() + "\n"
                + "结束时间：" + item.getEndDate());
    }

}
