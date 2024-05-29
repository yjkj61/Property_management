package com.yjkj.property_management.ui.page.personal

import android.content.Intent
import android.net.Uri
import android.webkit.WebView
import androidx.lifecycle.lifecycleScope
import com.kunminx.architecture.ui.page.DataBindingConfig
import com.yjkj.property_management.BR
import com.yjkj.property_management.R
import com.yjkj.property_management.entity.OwnerEntity
import com.yjkj.property_management.java.ui.CfbgActivity
import com.yjkj.property_management.java.ui.HardSoftDeviceActivity
import com.yjkj.property_management.java.ui.HealthCardActivity
import com.yjkj.property_management.java.ui.HlListActivity
import com.yjkj.property_management.java.ui.SosActivity
import com.yjkj.property_management.java.ui.UserInfoActivity
import com.yjkj.property_management.library.base.BaseFragment
import com.yjkj.property_management.library.base.nav
import com.yjkj.property_management.library.utils.ext.toast
import com.yjkj.property_management.ui.main.frag.MainFragmentViewModel
import com.yjkj.property_management.ui.page.homePageFragment.secondHomePage.SecondHomePageFragment
import com.yjkj.property_management.ui.page.personal.item.CallLogItemViewModel.Companion.CLICK_TYPE_AGREE
import com.yjkj.property_management.ui.page.personal.item.CallLogItemViewModel.Companion.CLICK_TYPE_DISAGREE
import kotlinx.coroutines.launch

class PersonalFragment : BaseFragment() {
    private lateinit var viewModel: PersonalViewModel
    private lateinit var mainViewModel: MainFragmentViewModel

    private var currOwner: OwnerEntity? = null;

    private var ownerid: Int = 0;

    override fun initViewModel() {
        viewModel = getFragmentScopeViewModel(PersonalViewModel::class.java)
        mainViewModel = getActivityScopeViewModel(MainFragmentViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(
            R.layout.fragment_personal,
            BR.viewModel,
            viewModel
        ).addBindingParam(BR.click, Click())
    }

    override fun lazyInit() {
        super.lazyInit()
        arguments?.let {
            val ownerEntity =
                it.getSerializable(SecondHomePageFragment.OWNER_ENTITY_PARAM) as OwnerEntity
            currOwner = ownerEntity
            ownerEntity.ownerId?.let { ownerid = it }
            viewModel.initUserInfo(ownerEntity)
            ownerEntity.ownerId?.let { it1 ->
                viewModel.getInfo(it1)
            }
        }
        viewModel.initCallLogItems()
        viewModel.initUserContactsItems()
    }

    override fun observer() {
        super.observer()
        lifecycleScope.launch {
            viewModel.callLogItemClickFlow.collect {
                when (it.first) {
                    CLICK_TYPE_AGREE -> {
                        toast("接受")
                    }

                    CLICK_TYPE_DISAGREE -> {
                        toast("拒绝")
                    }
                }
            }
        }
    }

    inner class Click {
        //返回上一个页面
        fun backup() {
            nav().navigateUp()
        }

        //回首页
        fun home() {
            backup()
            lifecycleScope.launch {
                mainViewModel.toHomeClickFlow.emit(Unit)
            }
        }

        //拨打电话
        fun call() {
            call(currOwner?.ownerPhone ?: "10086")
        }

        //护理计划记录
        fun nursePlanRecord() {
            var intent = Intent(activity, HlListActivity::class.java)
            intent.putExtra("id", ownerid)
            startActivity(intent)
        }

        //用户详情
        fun toUserInfo() {
            var intent = Intent(activity, UserInfoActivity::class.java)
            intent.putExtra("id", ownerid)
            startActivity(intent)
        }

        fun toAIDoctor(){
            var intent = Intent(activity, com.yjkj.property_management.java.ui.WebView::class.java)
            intent.putExtra("msg", "https://robot-lib-achieve.zuoshouyisheng.com/?app_id=586232fc0bdf3f6784d211bb")
            startActivity(intent)
        }

        //查房报告
        fun toReport() {
            var intent = Intent(activity, CfbgActivity::class.java)
            startActivity(intent)
        }

        //健康监测
        fun toHealthCard() {
            var intent = Intent(activity, HealthCardActivity::class.java)
            intent.putExtra("id", ownerid)
            startActivity(intent)
        }

        //物联网
        fun toWulianwang() {
            var intent = Intent(activity, HardSoftDeviceActivity::class.java)
            intent.putExtra("id", ownerid)
            startActivity(intent)
        }
    }
}