package com.yjkj.property_management.java.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.yjkj.property_management.databinding.ActivityDetailListBinding;
import com.yjkj.property_management.java.adapter.NbsAdapter;
import com.yjkj.property_management.java.adapter.SosAdapter;
import com.yjkj.property_management.java.bean.AfBean;
import com.yjkj.property_management.java.bean.NbsBean;
import com.yjkj.property_management.tools.baseFile.BaseActivity;
import com.yjkj.property_management.tools.http.API;
import com.yjkj.property_management.tools.http.OkHttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @description 尿不湿
 * @author: jhw
 * @date: 2024/5/25
 */
public class NbsActivity extends BaseActivity<ActivityDetailListBinding> {

    NbsAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initView() {
        super.initView();

        viewBinding.tvTitle.setText("尿不湿告警");

        GridLayoutManager linearLayoutManager = new GridLayoutManager(activity, 5);
        viewBinding.recyclweview.setLayoutManager(linearLayoutManager);
        adapter = new NbsAdapter(this);
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
        OkHttpUtil.getInstance().doGet(API.NBS + "pageNum=" + pageNum + "&pageSize=" + pageSize, new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                NbsBean bean = new Gson().fromJson(response.body().string(), NbsBean.class);
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
