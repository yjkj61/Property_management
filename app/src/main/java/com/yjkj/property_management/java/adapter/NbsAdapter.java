 package com.yjkj.property_management.java.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yjkj.property_management.R;
import com.yjkj.property_management.java.bean.ContractBean;
import com.yjkj.property_management.java.bean.NbsBean;

 /**
 * @description 尿不湿
 * @author Lenovo
 * @time 2023/10/17
 */
public class NbsAdapter extends BaseQuickAdapter<NbsBean.RowsBean, BaseViewHolder> {

    Context mcontext;

    public NbsAdapter(Context context) {
        super(R.layout.item_user_list, null);
        this.mcontext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, NbsBean.RowsBean item) {
        TextView tv_value = helper.getView(R.id.tv_value);

        ImageView avatar_image = helper.getView(R.id.avatar_image);
        TextView room_num_text = helper.getView(R.id.room_num_text);
        TextView doctor_name = helper.getView(R.id.doctor_name);
        TextView gender_text = helper.getView(R.id.gender_text);
        TextView age_text = helper.getView(R.id.age_text);

        Glide.with(mcontext).load(item.getOwnerPic()).circleCrop().into(avatar_image);
        room_num_text.setText(item.getOwnerRoomNum());
        doctor_name.setText(item.getOwnerName());
        gender_text.setText(item.getOwnerSex() == "0" ? "男" : "女");
        age_text.setText(item.getArea() + "岁");
    }

}
