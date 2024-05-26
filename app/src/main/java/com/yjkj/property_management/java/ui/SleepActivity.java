package com.yjkj.property_management.java.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.yjkj.property_management.databinding.ActivityDetailListBinding;
import com.yjkj.property_management.java.adapter.SleepAdapter;
import com.yjkj.property_management.java.adapter.SosAdapter;
import com.yjkj.property_management.java.bean.SleepBean;
import com.yjkj.property_management.tools.baseFile.BaseActivity;
import com.yjkj.property_management.tools.http.API;
import com.yjkj.property_management.tools.http.OkHttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @description 睡眠垫
 * @author: jhw
 * @date: 2024/5/25
 */
public class SleepActivity extends BaseActivity<ActivityDetailListBinding> {

    SleepAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initView() {
        super.initView();

        viewBinding.tvTitle.setText("睡眠垫报警");

        GridLayoutManager linearLayoutManager = new GridLayoutManager(activity, 5);
        viewBinding.recyclweview.setLayoutManager(linearLayoutManager);
        adapter = new SleepAdapter(this);
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
        OkHttpUtil.getInstance().doGet(API.sleep + "pageNum=" + pageNum + "&pageSize=" + pageSize, new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                SleepBean bean = new Gson().fromJson(response.body().string(), SleepBean.class);
                if (bean.getCode() == 200){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.setNewData(bean.getRows());
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
