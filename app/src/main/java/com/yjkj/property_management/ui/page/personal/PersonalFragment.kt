package com.yjkj.property_management.ui.page.personal

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.lifecycleScope
import com.kunminx.architecture.ui.page.DataBindingConfig
import com.yjkj.property_management.BR
import com.yjkj.property_management.R
import com.yjkj.property_management.entity.OwnerEntity
import com.yjkj.property_management.library.base.BaseFragment
import com.yjkj.property_management.library.base.nav
import com.yjkj.property_management.library.utils.ext.toast
import com.yjkj.property_management.ui.main.frag.MainFragmentViewModel
import com.yjkj.property_management.ui.page.homePageFragment.secondHomePage.SecondHomePageFragment
import com.yjkj.property_management.ui.page.personal.item.CallLogItemViewModel.Companion.CLICK_TYPE_AGREE
import com.yjkj.property_management.ui.page.personal.item.CallLogItemViewModel.Companion.CLICK_TYPE_DISAGREE
import kotlinx.coroutines.launch

class PersonalFragment : BaseFragment() {
    private lateinit var viewModel : PersonalViewModel
    private lateinit var mainViewModel: MainFragmentViewModel

    private  var currOwner: OwnerEntity? = null;

    override fun initViewModel() {
        viewModel = getFragmentScopeViewModel(PersonalViewModel::class.java)
        mainViewModel = getActivityScopeViewModel(MainFragmentViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.fragment_personal,BR.viewModel,viewModel).addBindingParam(BR.click,Click())
    }

    override fun lazyInit() {
        super.lazyInit()
        arguments?.let {
            val ownerEntity = it.getSerializable(SecondHomePageFragment.OWNER_ENTITY_PARAM) as OwnerEntity
            currOwner = ownerEntity
           viewModel.initUserInfo(ownerEntity)
        }
        viewModel.initCallLogItems()
        viewModel.initUserContactsItems()
    }

    override fun observer() {
        super.observer()
        lifecycleScope.launch {
            viewModel.callLogItemClickFlow.collect{
                when(it.first){
                    CLICK_TYPE_AGREE->{
                        toast("接受")
                    }
                    CLICK_TYPE_DISAGREE->{
                        toast("拒绝")
                    }
                }
            }
        }
    }

    inner class Click{
        //返回上一个页面
        fun backup(){
            nav().navigateUp()
        }

        //回首页
        fun home(){
            backup()
            lifecycleScope.launch {
                mainViewModel.toHomeClickFlow.emit(Unit)
            }
        }

        //拨打电话
        fun call(){
            call(currOwner?.ownerPhone ?:"10086")
        }

        //护理计划记录
        fun nursePlanRecord(){

        }
    }
}