package com.yjkj.property_management.java.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.yjkj.property_management.databinding.ActivityDetailListBinding;
import com.yjkj.property_management.java.adapter.ContractAdapter;
import com.yjkj.property_management.java.adapter.PropertyOrderAdapter;
import com.yjkj.property_management.tools.baseFile.BaseActivity;
import com.yjkj.property_management.tools.http.API;
import com.yjkj.property_management.tools.http.OkHttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @description 合同列表
 * @author: jhw
 * @date: 2024/5/25
 */
public class ContractListActivity extends BaseActivity<ActivityDetailListBinding> {

    ContractAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initView() {
        super.initView();

        viewBinding.tvTitle.setText("合同列表");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        viewBinding.recyclweview.setLayoutManager(linearLayoutManager);
        adapter = new ContractAdapter(this);
        viewBinding.recyclweview.setAdapter(adapter);

        getList();
    }

    public void back(){
        finish();
    }

    public int pageNum = 1;

    public int pageSize = 100;

    //物业工单
    private void getList(){
        OkHttpUtil.getInstance().doGet(API.ContractList + "pageNum=" + pageNum + "&pageSize=" + pageSize, new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                Log.i("getList", response.body().string());

            }
        });
    }

    @Override
    public void initData() {
        super.initData();
    }

}
