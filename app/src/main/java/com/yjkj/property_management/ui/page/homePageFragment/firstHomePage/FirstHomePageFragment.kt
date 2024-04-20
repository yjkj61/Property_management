package com.yjkj.property_management.ui.page.homePageFragment.firstHomePage

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kunminx.architecture.ui.page.DataBindingConfig
import com.yjkj.property_management.BR
import com.yjkj.property_management.R
import com.yjkj.property_management.library.base.BaseFragment
import com.yjkj.property_management.library.base.act
import com.yjkj.property_management.library.base.nav
import com.yjkj.property_management.library.utils.ext.dpToPx
import com.yjkj.property_management.library.utils.ext.toast
import com.yjkj.property_management.library.view.GridSpaceItemDecoration
import com.yjkj.property_management.ui.aibed.AiBedActivity
import com.yjkj.property_management.ui.login.LoginActivity
import com.yjkj.property_management.ui.login.LoginViewModel
import com.yjkj.property_management.ui.page.ownerlist.OwnerListType
import kotlinx.coroutines.launch

/**
* @Author hxy
* Create at 2024/1/13
* @desc  首页第一个页面
*/
class FirstHomePageFragment : BaseFragment() {
    private lateinit var viewModel: FirstHomePageViewModel
    private lateinit var loginViewModel : LoginViewModel
    override fun initViewModel() {
        viewModel = getFragmentScopeViewModel(FirstHomePageViewModel::class.java)
        loginViewModel = getFragmentScopeViewModel(LoginViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.fragment_first_home_page,BR.viewModel,viewModel).addBindingParam(BR.click,Click())
    }

    override fun lazyInit() {
        super.lazyInit()
        initServiceItems()
        initOrderItems()
        readMissedCalls()
        viewModel.requestManagement()
//        loginViewModel.login{
//            toast("登录成功")
//            //viewModel.requestHouseholdAnalysis()
//            viewModel.requestManagement()
//        }


    }

    private fun initServiceItems(){
        viewModel.serviceLayoutManager.set(LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false))
        viewModel.initServiceItems()
    }

    private fun initOrderItems(){
        viewModel.orderItemDirection.set(GridSpaceItemDecoration(requireContext().dpToPx(20),requireContext().dpToPx(5)))
        viewModel.orderGridLayoutManager.set(GridLayoutManager(requireContext(),2))
        viewModel.initOrderItems()
    }

    override fun observer() {
        super.observer()
        //服务列表item点击事件监听
        lifecycleScope.launch {
            viewModel.serviceItemClickFlow.collect{
                when(it){
                    "SOS报警"->{
                        toast(it)
                    }
                    "护理服务"->{
                        toast(it)
                    }
                    "其他服务"->{
                        toast(it)
                    }
                    "安防报警"->{
                        toast(it)
                    }
                    "尿不湿报警"->{
                        toast(it)
                    }
                    "睡眠垫报警"->{
                        Click().bedWarningNum()
                    }
                    "电子围栏报警"->{
                        toast(it)
                    }
                }
            }
        }

        //订单网格item点击事件监听
        lifecycleScope.launch {
            viewModel.orderItemClickFlow.collect{
                toast(it)
                when(it){
                    "物业工单"->{
                        Click().todayServiceBookList()
                    }
                    "商城订单"->{
                        Click().todayGoodsOrderList()
                    }
                    "适老订单"->{
                        Click().todayOldBookList()
                    }
                    "餐饮订单"->{
                        Click().todayRestaurantOrderList()
                    }
                }
            }
        }
    }



    private fun readMissedCalls(){
        viewModel.readMissedCalls(requireContext().contentResolver) {
            viewModel.missedCallsCount.set("${it.size}")
        }
    }

    inner class Click{

        fun missedCall(){
            nav().navigate(R.id.missedCallFragment)
        }

        fun payment(){
            nav().navigate(R.id.paymentFragment)
        }

        fun over60(){
            val bundle = Bundle()
            bundle.putInt(PARAM_KEY,OwnerListType.OVER_60)
            nav().navigate(R.id.ownerListFragment,bundle)
        }

        fun owner(){
            val bundle = Bundle()
            bundle.putInt(PARAM_KEY,OwnerListType.OWNER)
            nav().navigate(R.id.ownerListFragment,bundle)
        }

        fun ownerLiving(){
            val bundle = Bundle()
            bundle.putInt(PARAM_KEY,OwnerListType.OWNER_LIVING)
            nav().navigate(R.id.ownerListFragment,bundle)
        }

        fun workList(){
            val bundle = Bundle()
            bundle.putInt(PARAM_KEY,OwnerListType.OWNER_WORK_LIST)
            nav().navigate(R.id.ownerListFragment,bundle)
        }

        fun serviceList(){
            val bundle = Bundle()
            bundle.putInt(PARAM_KEY,OwnerListType.OWNER_SERVICE_LIST)
            nav().navigate(R.id.ownerListFragment,bundle)
        }

        fun bedWarningNum(){
            val bundle = Bundle()
            bundle.putInt(PARAM_KEY,OwnerListType.OWNER_BED_WARNING)
            act(AiBedActivity::class.java,bundle,false)
        }

        fun todayServiceBookList(){
            val bundle = Bundle()
            bundle.putInt(PARAM_KEY,OwnerListType.TODAY_SERVICE_BOOK_LIST)
            nav().navigate(R.id.ownerListFragment,bundle)
        }
        fun todayGoodsOrderList(){
            val bundle = Bundle()
            bundle.putInt(PARAM_KEY,OwnerListType.TODAY_OLD_BOOK_LIST)
            nav().navigate(R.id.ownerListFragment,bundle)
        }
        fun todayOldBookList(){
            val bundle = Bundle()
            bundle.putInt(PARAM_KEY,OwnerListType.TODAY_GOODS_ORDER_LIST)
            nav().navigate(R.id.ownerListFragment,bundle)
        }
        fun todayRestaurantOrderList(){
            val bundle = Bundle()
            bundle.putInt(PARAM_KEY,OwnerListType.TODAY_RESTAURANT_LIST)
            nav().navigate(R.id.ownerListFragment,bundle)
        }
        fun  switchUser() {
            act(LoginActivity::class.java,true)
        }
    }

    companion object{
        const val PARAM_KEY = "page_type_param"
    }
}