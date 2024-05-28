package com.yjkj.property_management.ui.page.homePageFragment.firstHomePage

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.provider.CallLog
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.yjkj.property_management.BR
import com.yjkj.property_management.R
import com.yjkj.property_management.library.base.BaseViewModel
import com.yjkj.property_management.ui.page.homePageFragment.firstHomePage.item.OrderItemViewModel
import com.yjkj.property_management.ui.page.homePageFragment.firstHomePage.item.ServiceItemViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import me.tatarka.bindingcollectionadapter2.ItemBinding

class FirstHomePageViewModel : BaseViewModel() {
    private val repo by lazy {
        FirstPageRepo()
    }

    //住户分析图
    val firstCircularProgressBarProgress = ObservableField<Float>()
    val secondCircularProgressBarProgress = ObservableField<Float>()
    val overSixtyOwnerNumber = ObservableField<String>()
    val ownerNumber = ObservableField<String>()
    val buildingNumber = ObservableField<String>()
    val solitaryElderlyNumber = ObservableField<String>()
    val cardUserNumber = ObservableField<String>()

    //上班/服务人数
    val employeesNumber = ObservableField<String>()
    val servingNumber = ObservableField<String>()

    //审批代办、合同到期
    val approvalAgencyCount = ObservableField<String>()
    val expireNumber = ObservableField<String>()


    //服务列表相关
    val serviceLayoutManager = ObservableField<LinearLayoutManager>()
    val serviceItems = ObservableArrayList<ServiceItemViewModel>()
    val serviceItemBinding = ItemBinding.of<ServiceItemViewModel>(BR.viewModel,R.layout.service_item_layout)
    val serviceItemClickFlow = MutableSharedFlow<String>()

    //订单网格相关
    val orderItemDirection = ObservableField<ItemDecoration>()
    val orderGridLayoutManager = ObservableField<GridLayoutManager>()
    val orderItems = ObservableArrayList<OrderItemViewModel>()
    val orderItemBinding = ItemBinding.of<OrderItemViewModel>(BR.viewModel,R.layout.order_item_layout)
    val orderItemClickFlow = MutableSharedFlow<String>()

    //未接来电数量
    val missedCallsCount = ObservableField<String>()


    //加载服务列表
    fun initServiceItems(){
        serviceItems.add(ServiceItemViewModel(this, Triple(R.drawable.sos_icon,"0","SOS报警")))
        serviceItems.add(ServiceItemViewModel(this, Triple(R.drawable.nurse_icon,"0","护理服务")))
        serviceItems.add(ServiceItemViewModel(this, Triple(R.drawable.orthers_service_icon,"0","其他服务")))
        serviceItems.add(ServiceItemViewModel(this, Triple(R.drawable.camera_icon,"0","安防报警")))
        serviceItems.add(ServiceItemViewModel(this, Triple(R.drawable.baby_diapers_icon,"0","尿不湿报警")))
        serviceItems.add(ServiceItemViewModel(this, Triple(R.drawable.mattress_icon,"0","睡眠垫报警")))
//        serviceItems.add(ServiceItemViewModel(this, Triple(R.drawable.ele_fence_icon,"0","电子围栏报警")))
    }

    //加载订单网格列表
    fun initOrderItems(){
        orderItems.add(OrderItemViewModel(this, Triple(R.drawable.pro_mananger_order_icon,"物业工单","0")))
        orderItems.add(OrderItemViewModel(this, Triple(R.drawable.mall_order_icon,"商城订单","0")))
        orderItems.add(OrderItemViewModel(this, Triple(R.drawable.old_man_order_icon,"适老订单","0")))
        orderItems.add(OrderItemViewModel(this, Triple(R.drawable.catering_order_icon,"餐饮订单","0")))
    }

    @SuppressLint("Range")
    fun readMissedCalls(resolver : ContentResolver,result : (it:List<Pair<String,String>>)->Unit = {}) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                val missedCall = mutableListOf<Pair<String,String>>()
                val contentResolver: ContentResolver = resolver
                val cursor = contentResolver.query(
                    CallLog.Calls.CONTENT_URI,
                    null,
                    CallLog.Calls.TYPE + " = ? AND " + CallLog.Calls.IS_READ + " = ?",
                    arrayOf(CallLog.Calls.MISSED_TYPE.toString(), "0"),
                    CallLog.Calls.DATE + " DESC"
                )

                cursor?.use {
                    while (it.moveToNext()) {
                        // 获取未接来电信息
                        val number = it.getString(it.getColumnIndex(CallLog.Calls.NUMBER))
                        val date = it.getString(it.getColumnIndex(CallLog.Calls.DATE))
                        // 处理未接来电信息，例如显示在界面上
                        missedCall.add(Pair(number,date))
                    }
                }
                missedCall
            }.onSuccess {
                runOnUiThread {
                    result.invoke(it)
                }

            }
        }

    }


    fun requestHouseholdAnalysis(){
        launch({repo.requestHouseholdAnalysis()}, onSuccess = {

        })
    }

    fun requestManagement(){
        launch ({repo.requestHomePageData()}, onSuccess = {
            overSixtyOwnerNumber.set("${it.overSixtyOwnerNumber}")
            ownerNumber.set("${it.ownerNumber}")
            buildingNumber.set("${it.buildingNumber}")
            solitaryElderlyNumber.set("${it.solitaryElderlyNumber}")
            firstCircularProgressBarProgress.set(100f)
            val percent = it.overSixtyOwnerNumber.toFloat() / it.ownerNumber.toFloat()
            secondCircularProgressBarProgress.set(percent * 100)
            employeesNumber.set(it.employeesNumber.toString())
            servingNumber.set(it.servingNumber.toString())
            orderItems[0].orderCount.set(it.todayServiceBook.toString())
            orderItems[1].orderCount.set(it.todayGoodsOrder.toString())
            orderItems[2].orderCount.set(it.todayOldBook.toString())
            orderItems[3].orderCount.set(it.todayRestaurantOrder.toString())
            val count = it.shopAgencyCount + it.servicerAgencyCount + it.projectAgencyCount;
            approvalAgencyCount.set("$count")
            expireNumber.set(it.searchExpireNumber.toString())
            serviceItems[5].warningCount.set("${it.sleepWarnNumber}")

        })
//        launch({repo.requestEmployeesNumber()}, onSuccess = {
//            employeesNumber.set(it.employeesNumber.toString())
//        })
//        launch({repo.requestServingNumber()}, onSuccess = {
//            servingNumber.set(it.servingNumber.toString())
//        })
//        launch({repo.requestTodayServiceBook()}, onSuccess = {
//            orderItems[0].orderCount.set(it.toString())
//        })
//        launch({repo.requestTodayGoodsOrder()}, onSuccess = {
//            orderItems[1].orderCount.set(it.toString())
//        })
//        launch({repo.requestTodayOldBook()}, onSuccess = {
//            orderItems[2].orderCount.set(it.toString())
//        })
//        launch({repo.requestTodayRestaurantOrder()}, onSuccess = {
//            orderItems[3].orderCount.set(it.toString())
//        })
        //审批代办
//        launch({repo.requestApprovalAgencyCount()}, onSuccess = {
//            approvalAgencyCount.set("${it.shopAgencyCount + it.servicerAgencyCount + it.projectAgencyCount}")
//        })
//        //到期合同数量
//        launch({repo.requestSearchExpireNumber()}, onSuccess = {
//            expireNumber.set("$it")
//
//        })
//        //睡眠垫报警数量
//        launch({repo.requestBedWarningNum()}, onSuccess = {
//            serviceItems[5].warningCount.set("$it")
//        })
    }




}