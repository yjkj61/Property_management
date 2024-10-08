package com.yjkj.property_management.java.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;
import com.yjkj.property_management.databinding.ActivityDealwithListBinding;
import com.yjkj.property_management.java.adapter.DealWithAdapterOne;
import com.yjkj.property_management.java.adapter.DealWithAdapterThree;
import com.yjkj.property_management.java.adapter.DealWithAdapterTwo;
import com.yjkj.property_management.java.bean.AfBean;
import com.yjkj.property_management.java.bean.DealWithOneBean;
import com.yjkj.property_management.java.bean.DealWithTwoBean;
import com.yjkj.property_management.tools.baseFile.BaseActivity;
import com.yjkj.property_management.tools.http.API;
import com.yjkj.property_management.tools.http.OkHttpUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @description 审核代办
 * @author: jhw
 * @date: 2024/5/25
 */
public class DealWithListActivity extends BaseActivity<ActivityDealwithListBinding> {

    DealWithAdapterOne adapter1 = null;

    DealWithAdapterTwo adapter2 = null;

    DealWithAdapterThree adapter3 = null;

    private int type = 0;

    private List<DealWithTwoBean> list1 = new ArrayList<>();

    private List<DealWithTwoBean> list2 = new ArrayList<>();

    private List<DealWithTwoBean> list3 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initView() {
        super.initView();

        viewBinding.tvTitle.setText("审核代办");

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(activity);
        viewBinding.recyclweview1.setLayoutManager(linearLayoutManager1);
        adapter1 = new DealWithAdapterOne(this);
        viewBinding.recyclweview1.setAdapter(adapter1);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(activity);
        viewBinding.recyclweview2.setLayoutManager(linearLayoutManager2);
        adapter2 = new DealWithAdapterTwo(this);
        viewBinding.recyclweview2.setAdapter(adapter2);

        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(activity);
        viewBinding.recyclweview3.setLayoutManager(linearLayoutManager3);
        adapter3 = new DealWithAdapterThree(this);
        viewBinding.recyclweview3.setAdapter(adapter3);

        viewBinding.rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    type = 0;
                    if (list1.size() != 0) {
                        getList1();
                    }
                    viewBinding.swipe1.setVisibility(View.VISIBLE);
                    viewBinding.swipe2.setVisibility(View.GONE);
                    viewBinding.swipe3.setVisibility(View.GONE);
                }
            }
        });

        viewBinding.rb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    type = 1;
                    if (list2.size() != 0) {
                        getList2();
                    }
                    viewBinding.swipe1.setVisibility(View.GONE);
                    viewBinding.swipe2.setVisibility(View.VISIBLE);
                    viewBinding.swipe3.setVisibility(View.GONE);
                }
            }
        });

        viewBinding.rb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    type = 2;
                    if (list3.size() != 0) {
                        getList3();
                    }
                    viewBinding.swipe1.setVisibility(View.GONE);
                    viewBinding.swipe2.setVisibility(View.GONE);
                    viewBinding.swipe3.setVisibility(View.VISIBLE);
                }
            }
        });

        viewBinding.swipe1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getList1();
                viewBinding.swipe1.setRefreshing(false);
            }
        });

        viewBinding.swipe2.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getList2();
                viewBinding.swipe2.setRefreshing(false);
            }
        });

        viewBinding.swipe3.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getList3();
                viewBinding.swipe3.setRefreshing(false);
            }
        });

        getList1();
        getList2();
        getList3();
    }

    public void back() {
        finish();
    }

    public int pageNum = 1;

    public int pageSize = 100;

    //商家代办
    private void getList1() {
        OkHttpUtil.getInstance().doGet(API.DealWithList1 + "pageNum=" + pageNum + "&pageSize=" + pageSize, new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                DealWithOneBean bean = new Gson().fromJson(response.body().string(), DealWithOneBean.class);
                if (bean.getCode() == 200){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter1.setNewData(bean.getRows());
                        }
                    });
                }

            }
        });
    }

    //服务商待办
    private void getList2() {
        OkHttpUtil.getInstance().doGet(API.DealWithList2 + "pageNum=" + pageNum + "&pageSize=" + pageSize, new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                DealWithTwoBean bean = new Gson().fromJson(response.body().string(), DealWithTwoBean.class);
                if (bean.getCode() == 200){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter2.setNewData(bean.getRows());
                        }
                    });
                }
            }
        });
    }

    //项目代办
    private void getList3() {
        OkHttpUtil.getInstance().doGet(API.DealWithList3 + "pageNum=" + pageNum + "&pageSize=" + pageSize, new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                Log.i("getList3", response.body().string());

            }
        });
    }

    @Override
    public void initData() {
        super.initData();
    }

}
