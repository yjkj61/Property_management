package com.yjkj.property_management.java.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.yjkj.property_management.databinding.ActivityDetailListBinding;
import com.yjkj.property_management.java.adapter.ContractAdapter;
import com.yjkj.property_management.java.adapter.PropertyOrderAdapter;
import com.yjkj.property_management.java.bean.ContractBean;
import com.yjkj.property_management.java.bean.DealWithOneBean;
import com.yjkj.property_management.tools.baseFile.BaseActivity;
import com.yjkj.property_management.tools.http.API;
import com.yjkj.property_management.tools.http.OkHttpUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    List<ContractBean.RowsBean> list = new ArrayList<>();

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

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.setClass(ContractListActivity.this, ContractContentActivity.class);
                intent.putExtra("content", list.get(position).getContractContent());
                startActivity(intent);
            }
        });

        getList();
    }

    public void back(){
        finish();
    }

    public int pageNum = 1;

    public int pageSize = 100;

    //物业工单
    private void getList(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String data = sdf.format(new Date());
        OkHttpUtil.getInstance().doGet(API.ContractList + data + "&pageNum=" + pageNum + "&pageSize=" + pageSize, new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                ContractBean bean = new Gson().fromJson(response.body().string(), ContractBean.class);
                if (bean.getCode() == 200){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            list.clear();
                            list.addAll(bean.getRows());
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
