package com.yjkj.property_management.java.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.yjkj.property_management.databinding.ActivityDetailListBinding;
import com.yjkj.property_management.java.adapter.AfAdapter;
import com.yjkj.property_management.java.adapter.HlListAdapter;
import com.yjkj.property_management.java.bean.AfBean;
import com.yjkj.property_management.java.bean.HlListBean;
import com.yjkj.property_management.tools.baseFile.BaseActivity;
import com.yjkj.property_management.tools.http.API;
import com.yjkj.property_management.tools.http.OkHttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @description 护理列表
 * @author: jhw
 * @date: 2024/5/25
 */
public class HlListActivity extends BaseActivity<ActivityDetailListBinding> {

    HlListAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initView() {
        super.initView();

        viewBinding.tvTitle.setText("护理列表");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        viewBinding.recyclweview.setLayoutManager(linearLayoutManager);
        adapter = new HlListAdapter(this);
        viewBinding.recyclweview.setAdapter(adapter);

        getList();
    }

    public void back(){
        finish();
    }

    public int pageNum = 1;

    public int pageSize = 100;

    private int ownerid = 0;

    //护理列表
    private void getList(){
        ownerid = getIntent().getIntExtra("id", 0);
        OkHttpUtil.getInstance().doGet(API.HL_LIST + ownerid, new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                HlListBean bean = new Gson().fromJson(response.body().string(), HlListBean.class);
                if (bean.getCode() == 200){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.setNewData(bean.getData());
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
