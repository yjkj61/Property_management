package com.yjkj.property_management.java.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.yjkj.property_management.databinding.ActivityDetailListBinding;
import com.yjkj.property_management.java.adapter.PropertyOrderAdapter;
import com.yjkj.property_management.java.adapter.ShopOrderAdapter;
import com.yjkj.property_management.java.bean.OldOrderBean;
import com.yjkj.property_management.java.bean.ShopOrderBean;
import com.yjkj.property_management.tools.baseFile.BaseActivity;
import com.yjkj.property_management.tools.http.API;
import com.yjkj.property_management.tools.http.OkHttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @description 商城工单列表
 * @author: jhw
 * @date: 2024/5/25
 */
public class ShopOrderListActivity extends BaseActivity<ActivityDetailListBinding> {

    ShopOrderAdapter adapter = null;

    public int pageNum = 1;

    public int pageSize = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initView() {
        super.initView();

        viewBinding.tvTitle.setText("商城工单");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        viewBinding.recyclweview.setLayoutManager(linearLayoutManager);
        adapter = new ShopOrderAdapter(this);
        viewBinding.recyclweview.setAdapter(adapter);

        getList();
    }

    public void back(){
        finish();
    }

    //商城工单
    private void getList(){
        OkHttpUtil.getInstance().doGet(API.ShopOrderList + "pageNum=" + pageNum + "&pageSize=" + pageSize, new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                ShopOrderBean bean = new Gson().fromJson(response.body().string(), ShopOrderBean.class);
                if (bean.getCode() == 200){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (bean.getRows().size() != 0){
                                adapter.setNewData(bean.getRows().get(0).getSOrderPoList());
                            }
                        }
                    });
                }
            }
        });
    }

    @Override
    public void initData() {
        super.initData();
    }

}
