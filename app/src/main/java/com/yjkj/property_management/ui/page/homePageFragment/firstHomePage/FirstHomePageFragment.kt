package com.yjkj.property_management.ui.page.homePageFragment.firstHomePage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telecom.TelecomManager
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kunminx.architecture.ui.page.DataBindingConfig
import com.yjkj.property_management.BR
import com.yjkj.property_management.R
import com.yjkj.property_management.java.ui.AfActivity
import com.yjkj.property_management.java.ui.ContractListActivity
import com.yjkj.property_management.java.ui.DealWithListActivity
import com.yjkj.property_management.java.ui.DzwlActivity
import com.yjkj.property_management.java.ui.FoodOrderListActivity
import com.yjkj.property_management.java.ui.HlfwActivity
import com.yjkj.property_management.java.ui.NbsActivity
import com.yjkj.property_management.java.ui.OldOrderListActivity
import com.yjkj.property_management.java.ui.OtherfwActivity
import com.yjkj.property_management.java.ui.PropertyOrderListActivity
import com.yjkj.property_management.java.ui.ShopOrderListActivity
import com.yjkj.property_management.java.ui.SleepActivity
import com.yjkj.property_management.java.ui.SosActivity
import com.yjkj.property_management.java.utils.PhoneUtils
import com.yjkj.property_management.library.base.BaseFragment
import com.yjkj.property_management.library.base.DataBindingActivity
import com.yjkj.property_management.library.base.act
import com.yjkj.property_management.library.base.actToJava
import com.yjkj.property_management.library.base.nav
import com.yjkj.property_management.library.base.toActivity
import com.yjkj.property_management.library.utils.ext.dpToPx
import com.yjkj.property_management.library.utils.ext.toast
import com.yjkj.property_management.library.view.GridSpaceItemDecoration
import com.yjkj.property_management.ui.aibed.AiBedActivity
import com.yjkj.property_management.ui.login.LoginActivity
import com.yjkj.property_management.ui.login.LoginViewModel
import com.yjkj.property_management.ui.main.act.MainActivity
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
        if (PhoneUtils.getPermisson(activity)){
            viewModel.missedCallsCount.set(PhoneUtils.getMissedCallCount(context).toString())
        }

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
                        Click().toSos()
                    }
                    "护理服务"->{
                        Click().toHlfw()
                    }
                    "其他服务"->{
                        Click().toOtherfw()
                    }
                    "安防报警"->{
                        Click().toAf()
                    }
                    "尿不湿报警"->{
                        Click().toNbs()
                    }
                    "睡眠垫报警"->{
                        Click().bedWarningNum()
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

    private fun unReadPhoneList(){
        var intent = Intent(Intent.ACTION_VIEW)
        intent?.setType("vnd.android.cursor.dir/calls")
        startActivity(intent)
    }

    inner class Click{

        fun missedCall(){
//            nav().navigate(R.id.missedCallFragment)
            unReadPhoneList()
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
//            val bundle = Bundle()
//            bundle.putInt(PARAM_KEY,OwnerListType.OWNER_BED_WARNING)
//            act(AiBedActivity::class.java,bundle,false)
            var intent = Intent(activity, SleepActivity::class.java)
            startActivity(intent)
        }

        fun toSos(){
//            actToJava(SosActivity::class.java, false)
            var intent = Intent(activity, SosActivity::class.java)
            startActivity(intent)
        }

        fun toHlfw(){
            var intent = Intent(activity, HlfwActivity::class.java)
            startActivity(intent)
        }

        fun toOtherfw(){
            var intent = Intent(activity, OtherfwActivity::class.java)
            startActivity(intent)
        }

        fun toAf(){
            var intent = Intent(activity, AfActivity::class.java)
            startActivity(intent)
        }

        fun toNbs(){
            var intent = Intent(activity, NbsActivity::class.java)
            startActivity(intent)
        }

        fun toSleep(){
            var intent = Intent(activity, SleepActivity::class.java)
            startActivity(intent)
        }

        fun toDzwl(){
            var intent = Intent(activity, DzwlActivity::class.java)
            startActivity(intent)
        }

        fun todayServiceBookList(){
            var intent = Intent(activity, PropertyOrderListActivity::class.java)
            startActivity(intent)
        }
        fun todayGoodsOrderList(){
            var intent = Intent(activity, ShopOrderListActivity::class.java)
            startActivity(intent)
        }
        fun todayOldBookList(){
            var intent = Intent(activity, OldOrderListActivity::class.java)
            startActivity(intent)
        }
        fun todayRestaurantOrderList(){
            var intent = Intent(activity, FoodOrderListActivity::class.java)
            startActivity(intent)
        }

        fun toContractList(){
            var intent = Intent(activity, ContractListActivity::class.java)
            startActivity(intent)
        }

        fun toDealWithList(){
            var intent = Intent(activity, DealWithListActivity::class.java)
            startActivity(intent)
        }

        fun  switchUser() {
            act(LoginActivity::class.java,true)
        }
    }

    companion object{
        const val PARAM_KEY = "page_type_param"
    }
}