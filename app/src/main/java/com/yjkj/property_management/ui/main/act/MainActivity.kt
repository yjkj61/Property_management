package com.yjkj.property_management.ui.main.act

import com.gyf.immersionbar.BarHide
import com.gyf.immersionbar.ImmersionBar
import com.kunminx.architecture.ui.page.DataBindingConfig
import com.yjkj.property_management.BR
import com.yjkj.property_management.R
import com.yjkj.property_management.library.base.BaseActivity

/**
* @Author hxy
* Create at 2024/1/12
* @desc 应用基座activity
*/
class MainActivity : BaseActivity() {
    private lateinit var viewModel: MainActivityViewModel


    override fun initViewModel() {
        viewModel = getActivityScopeViewModel(MainActivityViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.activity_main,BR.viewModel,viewModel)
    }

    override fun initData() {
        super.initData()
        //隐藏状态栏
        ImmersionBar.with(this).hideBar(BarHide.FLAG_HIDE_STATUS_BAR).init()
    }
}