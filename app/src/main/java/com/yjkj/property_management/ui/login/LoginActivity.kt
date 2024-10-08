package com.yjkj.property_management.ui.login

import android.content.Intent
import com.gyf.immersionbar.BarHide
import com.gyf.immersionbar.ImmersionBar
import com.kunminx.architecture.ui.page.DataBindingConfig
import com.yjkj.property_management.BR
import com.yjkj.property_management.R
import com.yjkj.property_management.java.ui.SosActivity
import com.yjkj.property_management.library.base.BaseActivity
import com.yjkj.property_management.library.base.toActivity
import com.yjkj.property_management.library.utils.ext.toast
import com.yjkj.property_management.ui.main.act.MainActivity

class LoginActivity : BaseActivity() {

    private lateinit var viewModel: LoginViewModel


    override fun initViewModel() {
        viewModel = getActivityScopeViewModel(LoginViewModel::class.java)

    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.activity_login, BR.viewModel, viewModel).addBindingParam(BR.click,Click())
    }

    inner class Click {

        fun login() {
            viewModel.login {
                toast("登录成功")
                toActivity(this@LoginActivity,MainActivity::class.java)
            }
        }
    }

    override fun initData() {
        super.initData()
        //隐藏状态栏
        ImmersionBar.with(this).hideBar(BarHide.FLAG_HIDE_STATUS_BAR).init()
        viewModel.initLoginItems()
    }
}