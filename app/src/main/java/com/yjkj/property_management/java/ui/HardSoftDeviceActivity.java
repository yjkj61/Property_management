package com.yjkj.property_management.java.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.yjkj.property_management.databinding.ActivityDetailListBinding;
import com.yjkj.property_management.databinding.ActivityHardsoftDeviceBinding;
import com.yjkj.property_management.java.adapter.AfAdapter;
import com.yjkj.property_management.java.bean.AfBean;
import com.yjkj.property_management.tools.baseFile.BaseActivity;
import com.yjkj.property_management.tools.http.API;
import com.yjkj.property_management.tools.http.OkHttpUtil;
import com.yjkj.property_management.ui.aibed.AiBedActivity;
import com.yjkj.property_management.ui.page.ownerlist.OwnerListType;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @description 物联网设备
 * @author: jhw
 * @date: 2024/5/25
 */
public class HardSoftDeviceActivity extends BaseActivity<ActivityHardsoftDeviceBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initView() {
        super.initView();

        viewBinding.tvTitle.setText("物联网设备");

        setClick();
    }

    public void setClick(){
        viewBinding.relSleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(HardSoftDeviceActivity.this, AiBedActivity.class);
                intent.putExtra("page_type_param", OwnerListType.OWNER_BED_WARNING);
                startActivity(intent);
            }
        });

        viewBinding.relNbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        viewBinding.relNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void back(){
        finish();
    }

    @Override
    public void initData() {
        super.initData();
    }

}
