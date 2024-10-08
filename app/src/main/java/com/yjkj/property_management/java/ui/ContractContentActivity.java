package com.yjkj.property_management.java.ui;

import android.os.Bundle;
import android.text.Html;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.yjkj.property_management.databinding.ActivityContentBinding;
import com.yjkj.property_management.databinding.ActivityDetailListBinding;
import com.yjkj.property_management.java.adapter.ContractAdapter;
import com.yjkj.property_management.java.bean.ContractBean;
import com.yjkj.property_management.tools.baseFile.BaseActivity;
import com.yjkj.property_management.tools.http.API;
import com.yjkj.property_management.tools.http.OkHttpUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @description 合同详情
 * @author: jhw
 * @date: 2024/5/25
 */
public class ContractContentActivity extends BaseActivity<ActivityContentBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initView() {
        super.initView();

        String content = getIntent().getStringExtra("content");
        viewBinding.tContent.setText(Html.fromHtml(content));

    }

    public void back(){
        finish();
    }

    @Override
    public void initData() {
        super.initData();
    }

}
